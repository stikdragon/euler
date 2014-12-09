package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P31 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P31().run());
	}

	private int		values[]	= { 200, 100, 50, 20, 10, 5, 2, 1 };
	private int[]	counts;
	private int		count;

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
		counts = new int[values.length];
		for (int i = 0; i < values.length; ++i)
			counts[i] = (200 / values[i]) + 1;
		count = 0;
		calc(0, 0);
		return Long.toString(count);
	}

	private void calc(int coin, int total) {
		if (coin == values.length) {
			if (total == 200)
				++count;
		} else {
			if (total > 200)
				return;
			for (int i = 0; i < counts[coin]; ++i)
				calc(coin + 1, total + i * values[coin]);
		}
	}

	@Override
	public String getName() {
		return "Coin sums";
	}

}
