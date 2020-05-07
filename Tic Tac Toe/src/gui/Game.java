package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	BoardPanel boardPanel = new BoardPanel();
	JButton startNewGame = new JButton("Start a new game");
	
	public Game() {		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(this.boardPanel, BorderLayout.CENTER);
		this.getContentPane().add(this.startNewGame, BorderLayout.SOUTH);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.startNewGame.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		@SuppressWarnings("unused")
		Game newGame = new Game();
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Game myGame = new Game();
	}

	

}
