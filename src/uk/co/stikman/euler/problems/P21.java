package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.Utils;

public class P21 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P21().run());
	}

	/**
	 * <pre>
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
	 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
	 * 
	 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
	 * 
	 * Evaluate the sum of all the amicable numbers under 10000.
	 * </pre>
	 */
	@Override
	public String run() {
		log(countFactors(220));
		log(countFactors(284));
		long results[] = new long[10000];
		for (int i = 0; i < 10000; ++i)
			results[i] = countFactors(i);

		boolean amicable[] = new boolean[10000];
		for (int i = 0; i < 10000; ++i)
			amicable[i] = false;
		for (int i = 1; i < 10000; ++i)
			if (results[i] < 10000 && results[(int) results[i]] == i && results[i] != i)
				amicable[i] = true;
		long sum = 0;
		for (int i = 1; i < 10000; ++i)
			if (amicable[i])
				sum += i;
		return Long.toString(sum);
	}

	private long countFactors(int i) {
		long[] x = Utils.calculateFactors(i);
		long res = 0;
		for (long a : x)
			res += a;
		return res;
	}

	@Override
	public String getName() {
		return "Amicable numbers";
	}

}
