package uk.co.stikman.euler.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uk.co.stikman.euler.base.ProblemBase;

public class P29 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P29().run());
	}

	/**
	 * <pre>
	 * Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
	 * 
	 * 22=4, 23=8, 24=16, 25=32
	 * 32=9, 33=27, 34=81, 35=243
	 * 42=16, 43=64, 44=256, 45=1024
	 * 52=25, 53=125, 54=625, 55=3125
	 * If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:
	 * 
	 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
	 * 
	 * How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
	 * </pre>
	 */
	@Override
	public String run() {
		Set<BigInteger> set = new HashSet<BigInteger>();
		for (int i = 2; i <= 100; ++i)
			for (int j = 2; j <= 100; ++j) 
				set.add(BigInteger.valueOf(i).pow(j));
		return Long.toString(set.size());
	}

	@Override
	public String getName() {
		return "Distinct powers";
	}

}
