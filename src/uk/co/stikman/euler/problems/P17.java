package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P17 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P17().run());
	}

	/**
	 * If the numbers 1 to 5 are written out in words: one, two, three, four,
	 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	 * 
	 * If all the numbers from 1 to 1000 (one thousand) inclusive were written
	 * out in words, how many letters would be used?
	 * 
	 * 
	 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
	 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
	 * 20 letters. The use of "and" when writing out numbers is in compliance
	 * with British usage.
	 */
	@Override
	public String run() {
		int tot = 0;
		for (int i = 1; i <= 1000; ++i) {
			String s = printNumber(i).replaceAll("[^a-z]", "");
			tot += s.length();
			log(s);
		}
		return Integer.toString(tot);

	}

	private static String	UNITS[]	= { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	private static String	TENS[]	= { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	private String printNumber(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 1000)
			return "one thousand";

		if ((n / 100) != 0) {
			sb.append(printNumber(n / 100) + " hundred ");
			n %= 100;
		}
		if (n > 0) {
			if (sb.length() != 0)
				sb.append("and ");

			if (n < 20)
				sb.append(UNITS[n]);
			else {
				sb.append(TENS[n / 10]);
				if ((n % 10) > 0)
					sb.append("-" + UNITS[n % 10]);
			}
		}
		return sb.toString();
	}

	@Override
	public String getName() {
		return "Number Letter Counts";
	}

}
