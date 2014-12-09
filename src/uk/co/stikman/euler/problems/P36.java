package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.Utils;

public class P36 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P36().run());
	}

	/**
	 * <pre>
	 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
	 * 
	 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
	 * 
	 * (Please note that the palindromic number, in either base, may not include leading zeros.)
	 * </pre>
	 */
	@Override
	public String run() {
		long sum = 0;
		for (int n = 0; n < 1000000; ++n)
			if (Utils.isPalindrome(n, 10) && Utils.isPalindrome(n, 2))
				sum += n;

		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Double-base palindromes";
	}

}
