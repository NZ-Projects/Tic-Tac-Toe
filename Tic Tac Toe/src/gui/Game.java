package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class Game extends JFrame{
	private static final long serialVersionUID = 1L;
	BoardPanel boardPanel = new BoardPanel();
	
	public Game() {		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(this.boardPanel, BorderLayout.CENTER);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Game myGame = new Game();
	}

}
