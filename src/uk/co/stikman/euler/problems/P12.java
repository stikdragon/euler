package uk.co.stikman.euler.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.LongList;
import uk.co.stikman.euler.utils.MutableInteger;
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
		LongList list = new LongList();
		long sum = 1;
		int idx = 1;
		Map<Long, MutableInteger> map = new HashMap<>();
		while (true) {
			list.clear();
			Utils.calculatePrimeFactors(sum, list);
			clearMap(map);
			for (int i = 0; i < list.size(); ++i) 
				addMap(map, list.get(i));
			int cnt = 1;
			for (Entry<Long, MutableInteger> e : map.entrySet()) 
				if (e.getValue().getVal() > 0)
					cnt *= (e.getValue().getVal()+1);
			
		//	log(sum + " - " + list.size());
			if (cnt >= 500)
				return Long.toString(sum);
			++idx;
			sum += idx;
		}

	}

	private static void addMap(Map<Long, MutableInteger> map, long l) {
		MutableInteger mi = map.get(l);
		if (mi == null) {
			mi = new MutableInteger(1);
			map.put(l, mi);
		} else {
			mi.inc();
		}
	}

	private static void clearMap(Map<Long, MutableInteger> map) {
		for (Entry<Long, MutableInteger> e : map.entrySet())
			e.getValue().setVal(0);
	}

	@Override
	public String getName() {
		return "Highly divisible triangular number";
	}

}
