package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P85 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P85().run());
	}

	/**
	 * <pre>
	 * By counting carefully it can be seen that a rectangular grid measuring 3 by 2 contains eighteen rectangles:
	 * 
	 *  -image-
	 * 
	 * Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid with the nearest solution.
	 * </pre>
	 */
	@Override
	public String run() {
		
		for (int i = 0; i < 100000; ++i) {
			
		}
		
		
		long sum = 0;
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Counting rectangles";
	}

}
