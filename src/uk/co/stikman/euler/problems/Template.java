package uk.co.stikman.euler.problems;

import uk.co.stikman.euler.base.ProblemBase;

public class Template extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new Template().run());
	}

	/**
	 * <pre>
	 * Description
	 * </pre>
	 */
	@Override
	public String run() {
		long sum = 0;
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "TEMPLATE";
	}

}
