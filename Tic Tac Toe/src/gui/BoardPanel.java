package gui;

import java.awt.Color;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board = new Board();
	private Player player = new Player("test", 'X');
	private Player computer = new Player("computer", 'O');
	private int mousePressX, mousePressY;
	
	private ArrayList<Point> coordinates = new ArrayList<Point>(Board.SIZE);
	
	
	public BoardPanel() {
		this.addMouseListener(this);
		
	}
	
	public void paint(Graphics graphic){
		super.paint(graphic);
		drawBoard(graphic);
	}
	
	private void drawBoard(Graphics graphic) {
		int squareWidth = getWidth()/Board.SIZE, squareHeight = getHeight()/Board.SIZE;
		
		for(int i=0; i<Board.SIZE*Board.SIZE; i++) {
				int xsquare = this.board.get(i).getX() * squareWidth;
				int ysquare = this.board.get(i).getY() * squareHeight;
				graphic.drawRect(xsquare, ysquare, squareWidth, squareHeight);
				
				if(this.board.get(i).isClicked()) {
					graphic.setColor(Color.black);
					
					int x = this.board.get(i).getX() * (squareWidth) + (squareWidth / 2);
					int y = (this.board.get(i).getY() + 1) * (squareHeight) - (squareHeight / 2);
					
					String str = String.valueOf(this.board.get(i).getValue());
					graphic.drawString(str, x, y);
					System.out.println("hannna");
				}
					
				coordinates.add(new Point(xsquare, ysquare));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int squareWidth = getWidth()/Board.SIZE, squareHeight = getHeight()/Board.SIZE;
		
		this.mousePressX = e.getX();
		this.mousePressY = e.getY();
		
		for (int i = 0; i < this.coordinates.size(); i++) {
			int minX = (int)this.coordinates.get(i).getX();
			int maxX = (int)this.coordinates.get(i).getX() + squareWidth;

			int minY = (int)this.coordinates.get(i).getY();
			int maxY = (int)this.coordinates.get(i).getY() + squareHeight;

			if ((this.mousePressX >= minX && this.mousePressX <= maxX)
					&& (this.mousePressY >= minY && this.mousePressY <= maxY)) {
				int index = this.board.getGridIndex(new Grid(minX / squareWidth, minY / squareHeight));
				if(index!=-1) {
					this.board.get(index).setClicked(true);
					this.board.get(index).setValue(this.player.getSign());
					break;
				}
				
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
