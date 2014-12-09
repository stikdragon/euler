package uk.co.stikman.euler.problems;

import java.math.BigInteger;

import uk.co.stikman.euler.base.ProblemBase;

public class P16 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P16().run());
	}

	/**
	 * <pre>
	 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * 
	 * What is the sum of the digits of the number 21000?
	 * </pre>
	 */
	@Override
	public String run() {
		BigInteger TWO = BigInteger.valueOf(2);
		BigInteger n = BigInteger.ONE;
		for (int i = 0; i < 1000; ++i)
			n = n.multiply(TWO);
		String s = n.toString();
		log(s);
		long sum = 0;
		for (int i = 0; i < s.length(); ++i)
			sum += (s.charAt(i) - '0');
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Power digit sum";
	}

}
