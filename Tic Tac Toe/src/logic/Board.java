package logic;

public class Board {
	public final static int SIZE = 3;
	private Grid[][] boardGame = new Grid[SIZE][SIZE];
	
	public Board() {		
		for(int i=0; i<this.boardGame.length; i++) {
			for(int j=0; j<this.boardGame[0].length; j++) {
				this.boardGame[i][j] = new Grid(i,j);
			}
		}
	}
	
	public Grid get(int x, int y) {
		return this.boardGame[x][y];
	}
	
	
	public boolean checkBoard(char sign) {
		//Check columns
		for(int i=0; i<this.boardGame.length; i++) {
			int count = 0;
			if(this.boardGame[i][0].getValue()!=sign)
				continue;
			
			for(int j=0; j<this.boardGame[0].length; j++) {
				if(this.boardGame[i][j].getValue()==sign)
					count++;			
				if(count==3)
					return true;
			}
		}
		
		//Check rows
		for(int j=0; j<this.boardGame.length; j++) {
			int count = 0;
			if(this.boardGame[0][j].getValue()!=sign)
				continue;
			
			for(int i=0; i<this.boardGame[0].length; i++) {
				if(this.boardGame[i][j].getValue()==sign)
					count++;			
				if(count==3)
					return true;
			}
		}
		
		//Check diagonal
		int count = 0;
		for(int i=0,j=0; (i<SIZE && j<SIZE); i++,j++) {		
			if(this.boardGame[i][j].getValue()==sign)
				count++;		
			if(count==3)
				return true;
		}
		
		//check anti diagonal
		if(this.boardGame[0][2].getValue()==sign && this.boardGame[1][1].getValue()==sign && this.boardGame[2][0].getValue()==sign)
			return true;
		
		
		return false;
	}
}
