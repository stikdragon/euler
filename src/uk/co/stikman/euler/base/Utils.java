package uk.co.stikman.euler.base;

public class Utils {
	public static boolean isPrime(long n) {
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	public static long factorial(int i) {
		long res = i;
		while (i > 1)
			res *= --i;
		return res;
	}
}
