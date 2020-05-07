package logic;

import java.util.Random;

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

	public int getY() {
		return y;
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
	
	public static Grid GetRandomGrid(int max) {
		Random random = new Random();
		int x = random.nextInt(max);
		int y = random.nextInt(max);

		return new Grid(x,y);
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
