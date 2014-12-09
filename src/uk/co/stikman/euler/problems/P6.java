package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.Utils;

public class P6 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P6().run());
	}

	/**
	 * The sum of the squares of the first ten natural numbers is,
	 * 
	 * 12 + 22 + ... + 102 = 385 The square of the sum of the first ten natural
	 * numbers is,
	 * 
	 * (1 + 2 + ... + 10)2 = 552 = 3025 Hence the difference between the sum of
	 * the squares of the first ten natural numbers and the square of the sum is
	 * 3025 − 385 = 2640.
	 * 
	 * Find the difference between the sum of the squares of the first one
	 * hundred natural numbers and the square of the sum.
	 */
	@Override
	public String run() {
		long tot = 0;
		long tot2 = 0;
		for (int i = 1; i <= 100; ++i) {
			tot += i * i;
			tot2 += i;
		}
		tot2 *= tot2;
		return Long.toString(tot2 - tot);
	}

	@Override
	public String getName() {
		return "Sum square difference";
	}

}
