package uk.co.stikman.euler.utils;

public class IntGrid {

	private int[]	grid;
	private int		width;
	private int		height;

	public IntGrid(int width, int height) {
		this.grid = new int[width * height];
		this.width = width;
		this.height = height;
		for (int i = 0; i < grid.length; ++i)
			grid[i] = 0;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int set(int x, int y, int val) {
		checkBounds(x, y);
		int r = grid[y * width + x];
		grid[y * width + x] = val;
		return r;
	}

	public int get(int x, int y) {
		checkBounds(x, y);
		return grid[y * width + x];
	}

	private void checkBounds(int x, int y) {
		if (x < 0 || x >= width)
			throw new IndexOutOfBoundsException("x: " + Integer.toString(x));
		if (y < 0 || y >= height)
			throw new IndexOutOfBoundsException("y: " + Integer.toString(y));
	}

	@Override
	public String toString() {
		int max = getMax();
		String s = Integer.toString(max);
		int pad = s.length();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < grid.length; ++i) {
			s = Integer.toString(grid[i]);
			sb.append(s);
			int n = pad - s.length();
			while (n-- >= 0)
				sb.append(" ");
			if ((i + 1) % width == 0)
				sb.append("\n");
		}

		return sb.toString();

	}

	public int getMax() {
		int max = grid[0];
		for (int i = 0; i < grid.length; ++i)
			max = Math.max(grid[i], max);
		return max;
	}

	public int getMin() {
		int min = grid[0];
		for (int i = 0; i < grid.length; ++i)
			min = Math.min(grid[i], min);
		return min;
	}

}
