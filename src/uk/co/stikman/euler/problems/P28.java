package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.IntGrid;

public class P28 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P28().run());
	}

	/**
	 * <pre>
	 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
	 * 
	 * 21 22 23 24 25
	 * 20  7  8  9 10
	 * 19  6  1  2 11
	 * 18  5  4  3 12
	 * 17 16 15 14 13
	 * 
	 * It can be verified that the sum of the numbers on the diagonals is 101.
	 * 
	 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
	 * </pre>
	 */
	@Override
	public String run() {
		final int SIZE = 1001;
		IntGrid grid = new IntGrid(SIZE, SIZE);
		grid.set(0, 0, 100);
		grid.set(1, 4, 120);

		int dir = 0;
		int j = 1;
		int k = 2;
		int x = SIZE / 2;
		int y = SIZE / 2;
		for (int i = 1; i <= SIZE * SIZE; ++i) {
			grid.set(x, y, i);
			switch (dir) {
				case 0:
					++x;
					break;
				case 1:
					++y;
					break;
				case 2:
					--x;
					break;
				case 3:
					--y;
					break;
			}

			if (--j == 0) {
				j = ++k / 2;
				if (++dir == 4)
					dir = 0;
			}
		}
		//		System.out.println(grid.toString());
		long sum = 0;
		for (int i = 0; i < SIZE; ++i) {
			sum += grid.get(i, i);
			sum += grid.get(SIZE - i - 1, i);
		}
		// will include the middle twice (which is 1)
		--sum;
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Number spiral diagonals";
	}

}
