package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P9 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P9().run());
	}

	/**
	 
	 */
	@Override
	public String run() {
		for (int a = 1; a < 1000; ++a) {
			for (int b = 1; b < 1000; ++b) {
				for (int c = 1; c < 1000; ++c) {
					if (a + b + c != 1000)
						continue;
					if (a * a + b * b == c * c)
						return Long.toString(a * b * c);
				}
			}
		}
		throw new RuntimeException("Couldn't solve");
	}

	@Override
	public String getName() {
		return "Special Pythagorean Triplet";
	}

}
