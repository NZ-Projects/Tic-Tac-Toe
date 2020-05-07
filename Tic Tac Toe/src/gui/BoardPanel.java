package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.Board;
import logic.Grid;
import logic.Player;

public class BoardPanel extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private Board board = new Board();
	private Player player = new Player("Zouhair", 'X');
	private Player computer = new Player("computer", 'O');
	private boolean gameOver, gameWon, gameTie;
	private int mousePressX, mousePressY;
	private int remainingGrids = Board.SIZE*Board.SIZE;
	
	private ArrayList<Point> coordinates = new ArrayList<Point>(Board.SIZE);
	
	
	public BoardPanel() {
		this.addMouseListener(this);		
	}
	
	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
		
		drawBoard(graphic);
		
		if(this.gameWon || this.gameOver || this.gameTie)
			drawGameResult(graphic);
	}
	
	private void drawBoard(Graphics graphic) {
		int squareWidth = getWidth()/Board.SIZE, squareHeight = getHeight()/Board.SIZE;
		
		for(int i=0; i<Board.SIZE; i++) {
			for(int j=0; j<Board.SIZE; j++) {
				int xsquare = this.board.get(i,j).getX() * squareWidth;
				int ysquare = this.board.get(i,j).getY() * squareHeight;
				graphic.drawRect(xsquare, ysquare, squareWidth, squareHeight);
				
				if(this.board.get(i,j).isClicked()) {
					int x = this.board.get(i,j).getX() * (squareWidth) + (squareWidth / 2);
					int y = (this.board.get(i,j).getY() + 1) * (squareHeight) - (squareHeight / 2);
					
					String str = String.valueOf(this.board.get(i,j).getValue());
					graphic.drawString(str, x, y);
				}
					
				coordinates.add(new Point(xsquare, ysquare));
			}
		}
	}
	

	private void drawGameResult(Graphics graphic) {
		Font myFont = new Font ("Courier New", 1, 17);
		graphic.setFont (myFont);
		
		String str;
		Color backgroundColor;
		if(this.gameWon) {
			str = "Congratulations, You Won!";
			backgroundColor = Color.green;
		}
			
		else if(this.gameOver) {
			str = "Game Over, You Lost!";
			backgroundColor = Color.red;
		}
		else {
			str = "It's a tie!";
			backgroundColor = Color.orange;
		}
						
		FontMetrics myFontMetrics = graphic.getFontMetrics();
		int stringWidth = myFontMetrics.stringWidth(str);
        int stringAccent = myFontMetrics.getAscent();
        
        int x = getWidth() / 2 - stringWidth / 2;
        int y = getHeight() / 2 + stringAccent / 2;
        
		graphic.drawString (str, x, y);
		setBackground(backgroundColor);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.gameOver || this.gameWon || this.gameTie)
			return;
		
		int squareWidth = getWidth()/Board.SIZE, squareHeight = getHeight()/Board.SIZE;
		
		this.mousePressX = e.getX();
		this.mousePressY = e.getY();
		
		for (int i = 0; i < this.coordinates.size(); i++) {
			int minX = (int)this.coordinates.get(i).getX();
			int maxX = (int)this.coordinates.get(i).getX() + squareWidth;

			int minY = (int)this.coordinates.get(i).getY();
			int maxY = (int)this.coordinates.get(i).getY() + squareHeight;

			if ((this.mousePressX >= minX && this.mousePressX <= maxX) && (this.mousePressY >= minY && this.mousePressY <= maxY)) {
				int x = minX / squareWidth;
				int y = minY / squareHeight;
				
				//Ignore mouse click if Grid is already clicked
				if(this.board.get(x,y).isClicked())
					return;
				
				this.board.get(x,y).setClicked(true);
				this.board.get(x,y).setValue(this.player.getSign());
				this.remainingGrids--;
				
				boolean playerWon = this.board.checkBoard(this.player.getSign());
				if (playerWon) {
					this.gameWon = true;
					break;
				}				
				else if (this.remainingGrids>0){
					//Setup computer move
					Grid randomGrid = Grid.GetRandomGrid(Board.SIZE);
					while(this.board.get(randomGrid.getX(), randomGrid.getY()).isClicked()) {
						randomGrid = Grid.GetRandomGrid(Board.SIZE);
					}
					
					this.board.get(randomGrid.getX(),randomGrid.getY()).setClicked(true);
					this.board.get(randomGrid.getX(),randomGrid.getY()).setValue(this.computer.getSign());
					this.remainingGrids--;
					
					boolean computerWon = this.board.checkBoard(this.computer.getSign());
					if (computerWon) {
						this.gameOver = true;
						break;
					}
				}
				else{
					this.gameTie = true;
					break;
				}
				break;					
			}
		}
		
		repaint();
		
	}
	
	
	
	
	
	
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
