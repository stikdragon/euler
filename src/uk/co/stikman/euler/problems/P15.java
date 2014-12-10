package uk.co.stikman.euler.problems;

import java.math.BigInteger;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.utils.Utils;

public class P15 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P15().run());
	}

	/**
	 * <pre>
	 * Description
	 * </pre>
	 */
	@Override
	public String run() {
		// this is simply 40!/(20!x20!)
		log(Utils.factorial(BigInteger.valueOf(4)).toString());
		BigInteger a = Utils.factorial(BigInteger.valueOf(40));
		BigInteger b = Utils.factorial(BigInteger.valueOf(20));
		b = b.multiply(b);
		a = a.divide(b);
		return a.toString();
	}

	@Override
	public String getName() {
		return "Lattice Paths";
	}

}
