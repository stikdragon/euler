package uk.co.stikman.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.resources.Resources;

public class P59 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P59().run());
	}

	private char[]	chars;
	private int[]	key;

	/**
	 * <pre>
	 * Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
	 * 
	 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
	 * 
	 * For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes. The user would keep the encrypted message and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.
	 * 
	 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key. If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message. The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
	 * 
	 * Your task has been made easy, as the encryption key consists of three lower case characters. Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
	 * </pre>
	 */
	@Override
	public String run() {
		String[] input = Resources.read("P59_cipher.txt").get(0).split(",");
		Set<String> lkp = new HashSet<>(Resources.read("words"));
		int maxLen = 0;
		for (String s : lkp)
			if (s.length() > maxLen)
				maxLen = s.length();
		int[] numbers = new int[input.length];
		for (int i = 0; i < input.length; ++i)
			numbers[i] = Integer.parseInt(input[i]);

		List<Integer> scores = new ArrayList<>();
		chars = new char[numbers.length];
		key = new int[3];
		for (int attempt = 0; attempt < 26 * 26 * 26; ++attempt) {

			String text = decode(numbers, attempt).toLowerCase();
			String[] pieces = text.split(" ");
			int count = 0;
			for (String s : pieces) {
				if (s.length() > maxLen)
					break;
				if (lkp.contains(s))
					++count;
			}
			scores.add(count);
		}
		int bestScore = 0;
		int bestKey = 0;
		for (int i = 0; i < scores.size(); ++i) {
			if (scores.get(i) > bestScore) {
				bestScore = scores.get(i);
				bestKey = i;
			}
		}
		String s = decode(numbers, bestKey);
		log(bestKey + " - " + s);
		long sum = 0;
		for (int i = 0; i < s.length(); ++i)
			sum += s.charAt(i);
		return Long.toString(sum);
	}

	private String decode(int[] numbers, int attempt) {
		key[0] = 'a' + (attempt % 26);
		key[1] = 'a' + ((attempt / 26) % 26);
		key[2] = 'a' + ((attempt / (26 * 26)) % 26);
		for (int i = 0; i < numbers.length; ++i)
			chars[i] = (char) (numbers[i] ^ key[i % 3]);
		return new String(chars);
	}

	@Override
	public String getName() {
		return "XOR decryption";
	}

}
