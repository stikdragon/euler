package uk.co.stikman.euler.problems;

import java.util.ArrayList;
import java.util.List;

import uk.co.stikman.euler.base.ProblemBase;

public class P33 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P33().run());
	}

	/**
	 * <pre>
	 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
	 * 
	 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
	 * 
	 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
	 * 
	 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
	 * </pre>
	 */
	@Override
	public String run() {
		List<Double> list = new ArrayList<>();
		for (int bottom = 10; bottom < 100; ++bottom) {
			for (int top = 10; top < bottom; ++top) {
				String stop = Integer.toString(top);
				String sbot = Integer.toString(bottom);
				String s = stop;
				for (int i = 0; i < s.length(); ++i) {
					if (sbot.indexOf(s.charAt(i)) != -1) {
						// whee.. this one doesn't need to be fast at all
						stop = stop.replace(s.charAt(i), 'x');
						sbot = sbot.replace(s.charAt(i), 'x');
					}
				}
				stop = stop.replaceAll("x", "");
				sbot = sbot.replaceAll("x", "");
				int a = 0;
				int b = 0;
				if (!stop.isEmpty())
					a = Integer.parseInt(stop);
				if (!sbot.isEmpty())
					b = Integer.parseInt(sbot);
				if (b > 0) {
					double delta = ((double) top / bottom) - ((double) a / b);
					if (delta < 0.0)
						delta *= -1.0;
					if (b > 0 && delta < 0.00001)
						list.add((double) a / b);
				}
			}
		}

		for (Double d : list)
			log(d);
		long sum = 0;
		if (sum == 0)
			throw new RuntimeException("Not working");
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Digit cancelling fractions";
	}

}
