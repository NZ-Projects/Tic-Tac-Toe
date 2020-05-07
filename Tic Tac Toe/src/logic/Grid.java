package logic;

public class Grid {
	private int x,y;
	private char value;
	private boolean isClicked;
	
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null || obj==this || !(obj instanceof Grid) ) 
            return false;
		
		Grid grid = (Grid)obj;
		if(grid.getX()==this.x && grid.getY()==this.y && grid.getValue()==this.value && grid.isClicked()==this.isClicked)
			return true;
		
		return false;
	}

}
