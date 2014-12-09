package uk.co.stikman.euler.base;

public abstract class ProblemBase {

	public abstract String getName();

	public abstract String run();

	protected void log(String msg) {
		System.out.println(msg);
	}

	protected void log(long n) {
		log(Long.toString(n));
	}

	protected void log(double d) {
		log(Double.toString(d));
	}

	public int getId() {
		return Integer.parseInt(getClass().getSimpleName().substring(1));
	}
	
	public boolean isSlowRunning() {
		return false;
	}
}
