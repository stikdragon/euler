package uk.co.stikman.euler.p7;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.base.Utils;

public class P7 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P7().run());
	}

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	 * see that the 6th prime is 13.
	 * 
	 * What is the 10 001st prime number?
	 */
	@Override
	public String run() {
		int count = 1;
		long cur = 1;
		while (count < 10001) {
			++cur;
			if (Utils.isPrime(cur))
				++count;
		}
		return Long.toString(cur);
	}

	@Override
	public String getName() {
		return "10001th Prime";
	}

}
