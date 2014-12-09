package uk.co.stikman.euler.problems;

import java.util.List;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.resources.Resources;
import uk.co.stikman.euler.utils.Utils;

public class P18 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P18().run());
	}

	/**
	 * <pre>
	 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
	 * 
	 * 3
	 * 7 4
	 * 2 4 6
	 * 8 5 9 3
	 * 
	 * That is, 3 + 7 + 4 + 9 = 23.
	 * 
	 * Find the maximum total from top to bottom of the triangle below:
	 * 
	 * 75
	 * 95 64
	 * 17 47 82
	 * 18 35 87 10
	 * 20 04 82 47 65
	 * 19 01 23 75 03 34
	 * 88 02 77 73 07 63 67
	 * 99 65 04 28 06 16 70 92
	 * 41 41 26 56 83 40 80 70 33
	 * 41 48 72 33 47 32 37 16 94 29
	 * 53 71 44 65 25 43 91 52 97 51 14
	 * 70 11 33 28 77 73 17 78 39 68 17 57
	 * 91 71 52 38 17 14 91 43 58 50 27 29 48
	 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
	 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
	 * 
	 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
	 * </pre>
	 */
	@Override
	public String run() {
		return run("P18_tri.txt");
	}

	@Override
	public String getName() {
		return "Maximum path sum I";
	}

	protected String run(String file) {
		List<String> lines = Resources.read(file);

		int row = 0;
		int bestLast[] = null;
		int tmp[];
		for (String line : lines) {
			++row;
			int[] numbers = Utils.stringsToIntArray(line, " ");
			tmp = new int[row];
			if (row == 1) {
				tmp[0] = numbers[0];
			} else {
				for (int i = 0; i < tmp.length; ++i) {
					int a = (i == 0) ? 0 : bestLast[i - 1];
					int b = (i == row - 1) ? 0 : bestLast[i];
					if (b > a)
						a = b;
					tmp[i] = a + numbers[i];
				}
			}
			bestLast = tmp;
		}
		long best = 0;
		for (int i : bestLast)
			if (i > best)
				best = i;
		return Long.toString(best);
	}

}
