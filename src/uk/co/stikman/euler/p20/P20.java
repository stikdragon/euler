package uk.co.stikman.euler.p20;

import java.math.BigInteger;

import javax.management.RuntimeErrorException;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.base.Utils;

public class P20 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P20().run());
	}

	/**
	 * n! means n × (n − 1) × ... × 3 × 2 × 1
	 * 
	 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
	 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
	 * 
	 * Find the sum of the digits in the number 100!
	 */
	@Override
	public String run() {
		BigInteger a = BigInteger.valueOf(1);
		int n = 0;
		while (++n <= 100) 
			a = a.multiply(BigInteger.valueOf(n));
		String s = a.toString();
		log(s);
		int sum = 0;
		for (int i = 0; i < s.length();++i)
			sum += (s.charAt(i) - '0');
		return Integer.toString(sum);
	}

	@Override
	public String getName() {
		return "Factorial digit sum";
	}

}
