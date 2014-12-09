package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P1 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P1().run());
	}

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	@Override
	public String run() {
		long tot = 0;
		for (int i = 0; i < 1000; ++i)
			if (i % 3 == 0 || i % 5 == 0)
				tot += i;
		return Long.toString(tot);
	}

	@Override
	public String getName() {
		return "Multiples of 3 and 5";
	}

}
