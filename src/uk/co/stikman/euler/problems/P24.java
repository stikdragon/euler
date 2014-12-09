package uk.co.stikman.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uk.co.stikman.euler.base.ProblemBase;

public class P24 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P24().run());
	}

	private char[]			perms;
	private List<String>	output;

	private void swap(int a, int b) {
		char t = perms[a];
		perms[a] = perms[b];
		perms[b] = t;
	}

	private boolean permute(int k) {

		for (int i = k; i < perms.length; i++) {
			swap(i, k);
			if (permute(k + 1))
				return true;
			swap(k, i);
		}
		if (k == perms.length - 1) {
			output.add(new String(perms));
			if (output.size() == 10000000)
				return true;
		}
		return false;
	}

	/**
	 * <pre>
	 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	 * 
	 * 012   021   102   120   201   210
	 * 
	 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	 * </pre>
	 */
	@Override
	public String run() {
		output = new ArrayList<>();
		perms = "0123456789".toCharArray();
		permute(0);
		Collections.sort(output);
		return output.get(999999);
	}

	@Override
	public String getName() {
		return "Lexicographic permutations";
	}

}
