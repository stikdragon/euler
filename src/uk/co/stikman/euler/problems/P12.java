package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.LongList;
import uk.co.stikman.euler.utils.Utils;

public class P12 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P12().run());
	}

	/**
	 * <pre>
	 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
	 * 
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * 
	 * Let us list the factors of the first seven triangle numbers:
	 * 
	 *  1: 1
	 *  3: 1,3
	 *  6: 1,2,3,6
	 * 10: 1,2,5,10
	 * 15: 1,3,5,15
	 * 21: 1,3,7,21
	 * 28: 1,2,4,7,14,28
	 * We can see that 28 is the first triangle number to have over five divisors.
	 * 
	 * What is the value of the first triangle number to have over five hundred divisors?
	 * </pre>
	 */
	@Override
	public String run() {
		throw new RuntimeException("Unsolved");
		/*long sum = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 23 * 31;
		LongList list = new LongList();
		Utils.calculateFactors(sum, list);
		log(list.toString());

		sum += 1;
		list.clear();
		Utils.calculateFactors(sum, list);
		log(list.toString());

		long tri = (sum * (sum + 1)) / 2;
		log(tri);*/
		/*
		 * int idx = 1; while (true) { list.clear(); Utils.calculateFactors(sum,
		 * list); log(sum + " - " + list.size()); if (list.size() > 500) return
		 * Long.toString(sum); ++idx; sum += idx; }
		 */
		//return Long.toString(tri);
	}

	@Override
	public String getName() {
		return "Highly divisible triangular number";
	}

}