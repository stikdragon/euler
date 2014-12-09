package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P3 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P3().run());
	}

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 */
	@Override
	public String run() {
		long n = 600851475143L;
		long best = 1;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				best = i;
				n /= i;
			}
		}
		return Long.toString(best);
	}

	@Override
	public String getName() {
		return "Largest prime factor";
	}

}
