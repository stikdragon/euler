package uk.co.stikman.euler.problems;

import java.math.BigInteger;

import uk.co.stikman.euler.base.ProblemBase;

public class P26 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P26().run());
	}

	/**
	 * <pre>
	 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
	 * 
	 * 1/2	= 	0.5
	 * 1/3	= 	0.(3)
	 * 1/4	= 	0.25
	 * 1/5	= 	0.2
	 * 1/6	= 	0.1(6)
	 * 1/7	= 	0.(142857)
	 * 1/8	= 	0.125
	 * 1/9	= 	0.(1)
	 * 1/10	= 	0.1
	 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
	 * 
	 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
	 * </pre>
	 */
	@Override
	public String run() {
		BigInteger bignum = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		for (int d = 1; d < 1000; ++d) {
			BigInteger a = BigInteger.valueOf(d);
			a.multiply(bignum);

			log(d + " -- 0." + bignum.divide(a).toString());
		}
		long sum = 0;
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Reciprocal cycles";
	}

}
