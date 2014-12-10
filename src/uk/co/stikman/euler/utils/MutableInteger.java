package uk.co.stikman.euler.utils;

public class MutableInteger {
	private int	val;

	public MutableInteger() {
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public MutableInteger(int val) {
		super();
		this.val = val;
	}

	public void inc() {
		++val;
	}

	@Override
	public String toString() {
		return Integer.toString(val);
	}
	
	

}
