package uk.co.stikman.euler.base;

public class ProblemResult {
	private String		result;
	private Throwable	error;
	private double		time;
	private ProblemBase	problem;

	/**
	 * @param problem
	 */
	public ProblemResult(ProblemBase problem) {
		super();
		this.problem = problem;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

	public double getTime() {
		return time;
	}

	public ProblemBase getProblem() {
		return problem;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public String toString() {
		if (getError() == null)
			return String.format("(%-3d) %6.1fms - %s == %s", getProblem().getId(), getTime() * 1000.0, getProblem().getName(), getResult());
		else
			return String.format("(%-3d) ! ERROR ! - %s", getProblem().getId(), getError().toString());
	}

}
