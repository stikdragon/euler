package uk.co.stikman.euler.problems;

import java.math.BigInteger;

import uk.co.stikman.euler.base.ProblemBase;

public class P25 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P25().run());
	}

	/**
	 * <pre>
	 * The Fibonacci sequence is defined by the recurrence relation:
	 * 
	 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
	 * Hence the first 12 terms will be:
	 * 
	 * F1 = 1
	 * F2 = 1
	 * F3 = 2
	 * F4 = 3
	 * F5 = 5
	 * F6 = 8
	 * F7 = 13
	 * F8 = 21
	 * F9 = 34
	 * F10 = 55
	 * F11 = 89
	 * F12 = 144
	 * The 12th term, F12, is the first term to contain three digits.
	 * 
	 * What is the first term in the Fibonacci sequence to contain 1000 digits?
	 * </pre>
	 */
	@Override
	public String run() {
		BigInteger n = BigInteger.ONE;
		BigInteger l1 = n;
		BigInteger l2 = n;
		int i = 3;
		while (n.toString().length() < 1000) {
			n = l1.add(l2);
			l1 = l2;
			l2 = n;
			++i;
		}

		return Long.toString(i - 1);
	}

	@Override
	public String getName() {
		return "1000-digit Fibonacci number";
	}

}
