package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.Utils;

public class P10 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P10().run());
	}

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * 
	 * Find the sum of all the primes below two million.
	 */
	@Override
	public String run() {
		long sum = 0;
		for (int i = 2; i <= 2000000; ++i)
			if (Utils.isPrime(i))
				sum += i;
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Summation of Primes";
	}

}
