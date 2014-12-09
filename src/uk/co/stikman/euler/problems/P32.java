package uk.co.stikman.euler.problems;

import java.util.HashSet;
import java.util.Set;

import uk.co.stikman.euler.base.ProblemBase;

/**
 * This is a dumb way of solving it but i cba to do anything cleverer
 *
 */
public class P32 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P32().run());
	}

	private char[]		perms;
	private Set<Long>	products;

	private void permute(int k) {

		for (int i = k; i < perms.length; i++) {
			swap(i, k);
			permute(k + 1);
			swap(k, i);
		}
		if (k == perms.length - 1)
			test();
	}

	private void test() {
		int pos1 = 0;
		int pos2 = 0;
		for (int i = 0; i < perms.length; ++i) {
			if (perms[i] == '=')
				pos1 = i;
			else if (perms[i] == 'x')
				pos2 = i;
		}
		if (pos1 < pos2 + 2) // = must be at least 2 chars before x
			return;
		if (pos1 < 3) // = can't be in the first 3 chars
			return;
		if (pos1 == perms.length - 1) // = can't be the last one
			return;
		if (pos2 == 0) // x can't be first
			return;

		int scale = 1;
		int a = 0;
		for (int i = 0; i < pos2; ++i) {
			a += (perms[i] - '0') * scale;
			scale *= 10;
		}
		int b = 0;
		scale = 1;
		for (int i = pos2 + 1; i < pos1; ++i) {
			b += (perms[i] - '0') * scale;
			scale *= 10;
		}
		int c = 0;
		scale = 1;
		for (int i = pos1 + 1; i < perms.length; ++i) {
			c += (perms[i] - '0') * scale;
			scale *= 10;
		}
		if (a * b == c) {
			products.add(new Long(c));
			log(new String(perms));
		}
	}

	private void swap(int a, int b) {
		char t = perms[a];
		perms[a] = perms[b];
		perms[b] = t;
	}

	/**
	 * <pre>
	 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
	 * </pre>
	 */
	@Override
	public String run() {
		products = new HashSet<>();

		perms = "123456789x=".toCharArray();
		permute(0);

		long sum = 0;
		for (Long l : products)
			sum += l.longValue();
		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Pandigital products";
	}

}
