package uk.co.stikman.euler.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import uk.co.stikman.euler.utils.LongList;

public class TestUtils {

	@Test
	public void testLongList1() {
		LongList ll = new LongList();
		ll.add(5);
		assertEquals(1, ll.size());
		assertEquals(5, ll.get(0));

		ll.add(10);
		assertEquals(2, ll.size());
		assertEquals(5, ll.get(0));
		assertEquals(10, ll.get(1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testLongListErrors() {
		LongList ll = new LongList();
		ll.add(5);
		assertEquals(1, ll.size());
		assertEquals(5, ll.get(0));

		ll.get(1); // fail
	}

	@Test
	public void testLongList2() {
		LongList ll = new LongList();
		int total = 0;
		for (int i = 0; i < 100000; i++) {
			ll.add(i);
			total += i;
		}
		assertEquals(100000, ll.size());

		for (int i = 0; i < 100000; i++) {
			total -= ll.get(i);
		}
		assertEquals(0, total);
	}


	@Test
	public void testLongList3() {
		LongList ll = new LongList();
		ll.setIncrement(1000);
		ll.set(100000, 12345);
		assertEquals(100001, ll.size());
	}
	
}
