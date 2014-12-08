package uk.co.stikman.euler.p4;

import uk.co.stikman.euler.base.ProblemBase;

public class P4 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P4().run());
	}

	/**
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	@Override
	public String run() {
		int best = 0;
		for (int i = 0; i < 1000; ++i) {
			for (int j = 0; j < 1000; ++j) {
				int n = i * j;
				if (isPalindrome(n) && n > best)
					best = n;
			}
		}
		return Long.toString(best);
	}

	private static boolean isPalindrome(int num) {
		String s = Integer.toString(num);
		int l = s.length();
		for (int i = 0; i < l / 2; ++i)
			if (s.charAt(i) != s.charAt(l - i - 1))
				return false;
		return true;
	}

	@Override
	public String getName() {
		return "Largest palindrome product";
	}

}
