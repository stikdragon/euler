package uk.co.stikman.euler.base;

public abstract class ProblemBase {

	public abstract String getName();
	public abstract String run();
	
	protected void log(String msg) {
		System.out.println(msg);
	}
	public int getId() {
		return Integer.parseInt(getClass().getSimpleName().substring(1));
	}
}
