package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.Utils;

public class P31 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P31().run());
	}

	/**
	 * <pre>
	 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
	 * 
	 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
	 * It is possible to make £2 in the following way:
	 * 
	 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
	 * How many different ways can £2 be made using any number of coins?
	 * </pre>
	 */
	@Override
	public String run() {
		int values[] = { 100, 50, 20, 10, 5, 2, 1 };
		int counts[] = new int[values.length];
		for (int i = 0; i < values.length; ++i)
			counts[i] = (200 / values[i]) + 1;
		log("counts: " + Utils.arrayToString(counts));
		long permcount = 1;
		for (int i = 0; i < values.length; ++i)
			permcount *= counts[i];
		int count = 1; // start at 1 for the single case of 1x200
		for (long perm = 0; perm < permcount; ++perm) {
			long cur = perm;
			int sum = 0;
			for (int i = 0; i < values.length; ++i) {
				long c = cur % counts[i];
				sum += (c * values[i]);
				cur /= counts[i];
			}
			if (sum == 200)
				++count;
			if (perm % 10000000 == 0)
				log((int) (100.0 * perm / permcount) + "%");
		}
		return Long.toString(count);
	}

	@Override
	public String getName() {
		return "Coin sums";
	}
	
	@Override
	public boolean isSlowRunning() {
		return true;
	}


}
