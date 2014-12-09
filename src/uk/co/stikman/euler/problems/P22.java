package uk.co.stikman.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uk.co.stikman.euler.base.ProblemBase;
import uk.co.stikman.euler.resources.Resources;

public class P22 extends ProblemBase {

	public static void main(String[] args) {
		System.out.println(new P22().run());
	}

	/**
	 * <pre>
	 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
	 * 
	 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
	 * 
	 * What is the total of all the name scores in the file?
	 * </pre>
	 */
	@Override
	public String run() {
		List<String> list = new ArrayList<>();
		for (String s : Resources.read("P22_names.txt").get(0).split(","))
			list.add(s.toUpperCase().replaceAll("[^A-Z]", ""));
		Collections.sort(list);
		long sum = 0;
		for (int i = 0; i < list.size(); ++i) {
			String s = list.get(i);
			long n = 0;
			for (int j = 0; j < s.length(); ++j)
				n += (1 + s.charAt(j) - 'A');
			sum += n * (i + 1);
		}

		return Long.toString(sum);
	}

	@Override
	public String getName() {
		return "Names scores";
	}

}
