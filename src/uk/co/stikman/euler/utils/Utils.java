package uk.co.stikman.euler.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static boolean isPrime(long n) {
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (long i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	public static long factorial(long i) {
		long res = i;
		while (i > 1)
			res *= --i;
		return res;
	}

	public static long[] calculateFactors(long n) {
		List<Long> lst = new ArrayList<>();
		for (long i = 1; i < n / 2; ++i)
			if (n % i == 0)
				lst.add(i);
		long[] res = new long[lst.size()];
		for (int i = 0; i < lst.size(); ++i)
			res[i] = lst.get(i).intValue();
		return res;
	}

	public static void calculateFactors(long n, LongList output) {
		for (long i = 1; i < n / 2; ++i)
			if (n % i == 0)
				output.add(i);
	}

	public static int[] stringsToIntArray(String input, String separator) {
		String[] x = input.split(separator);
		int[] res = new int[x.length];
		for (int i = 0; i < x.length; ++i)
			res[i] = Integer.parseInt(x[i]);
		return res;
	}

	public static String arrayToString(int[] array) {
		StringBuilder sb = new StringBuilder();
		int size = array.length;
		for (int i = 0; i < size; ++i) {
			if (i == size - 1)
				sb.append(array[i]);
			else
				sb.append(array[i]).append(", ");
		}
		return sb.toString();
	}
}
