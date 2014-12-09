package uk.co.stikman.euler.problems;

import java.util.List;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.resources.Resources;
import uk.co.stikman.euler.utils.Utils;

public class P67 extends P18 {

	public static void main(String[] args) {
		System.out.println(new P67().run());
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
	 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
	 * 
	 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
	 * </pre>
	 */
	@Override
	public String run() {
		return run("P67_tri.txt");

	}


	@Override
	public String getName() {
		return "Maximum path sum II";
	}

}