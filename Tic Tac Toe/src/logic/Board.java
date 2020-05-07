package logic;

public class Board {
	public final static int SIZE = 3;
	private Grid[] boardGame = new Grid[SIZE*SIZE];
	
	public Board() {
		int x=0, y=0;
		for(int i=0; i<boardGame.length; i++) {
			if(y==SIZE) {
				y=0;
				x++;
				i--;
				continue;
			}
			this.boardGame[i] = new Grid(x,y);
			y++;
		}		
	}
	
	public Grid get(int index) {
		return this.boardGame[index];
	}
	
	public int getGridIndex(Grid grid) {
		for(int i=0; i<boardGame.length; i++) {
			if(this.boardGame[i].equals(grid))
				return i;
		}
		
		return -1;
	}
}
