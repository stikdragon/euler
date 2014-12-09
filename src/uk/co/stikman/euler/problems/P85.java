package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class P85 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P85().run());
	}

	/**
	 * <pre>
	 * By counting carefully it can be seen that a rectangular grid measuring 3 by 2 contains eighteen rectangles:
	 * 
	 *  -image-
	 * 
	 * Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid with the nearest solution.
	 * </pre>
	 */
	@Override
	public String run() {
		//
		// We can see that in the case WxH where H=1 that area = 2million at
		// W=2000.5 (solve 0.5n(n+1)), which gives an upper limit, so only need 
		// to test up to that
		//
		int best = 2000000;
		int bestXY = 0;
		for (int w = 1; w < 2000; ++w) {
			for (int h = 1; h < 2000; ++h) {
				int c = w * (w + 1) * h * (h + 1) / 4;
				int d = 2000000 - c;
				if (d < 0)
					d *= -1;
				if (d < best) {
					best = d;
					bestXY = h * 10000 + w;
					log(w + " x " + h + " == " + c);
				}
			}
		}

		long sum = (bestXY % 10000) * (bestXY / 10000);
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Counting rectangles";
	}

}
