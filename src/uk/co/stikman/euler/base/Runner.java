package uk.co.stikman.euler.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
	private static final int	MAX_PROBLEMS	= 1000;
	private static final int	THREAD_COUNT	= 8;

	public static void main(String[] args) {

		Runner r = new Runner();
		r.go();

		/*
		*/
	}

	@SuppressWarnings("unchecked")
	private void go() {
		//
		// Try to load all the classes that look right :)
		//
		List<ProblemBase> problems = new ArrayList<>();
		for (int i = 1; i < MAX_PROBLEMS; ++i) {
			Class<? extends ProblemBase> cls;
			try {
				cls = (Class<? extends ProblemBase>) Class.forName("uk.co.stikman.euler.problems.P" + i);
				ProblemBase inst = cls.newInstance();
				problems.add(inst);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			}
		}
		Map<ProblemBase, ProblemResult> results = new HashMap<>();

		final List<ProblemBase> pending = new ArrayList<>(problems);

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; ++i) {
			threads.add(new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						ProblemBase p;
						synchronized (pending) {
							if (pending.isEmpty())
								break;
							p = pending.remove(0);
						}
						ProblemResult pr = null;
						try {
							System.out.println("Running (" + p.getId() + ") " + p.getName() + "...");
							pr = new ProblemResult(p);
							synchronized (results) {
								results.put(p, pr);
							}
							
							long start = System.nanoTime();
							pr.setResult(p.run());
							long dt = System.nanoTime() - start;
							pr.setTime((double)dt / 1000000000.0);
						} catch (Throwable th) {
							th.printStackTrace();
							if (pr != null)
								pr.setError(th);
						}
					}
				}
			}));
		}

		for (Thread t : threads)
			t.start();

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("======================");
		System.out.println("Finished!  Solutions:");
		System.out.println("======================");
		for (ProblemBase pb : problems) {
			ProblemResult pr = results.get(pb);
			if (pr.getError() != null)
				System.err.println(pr.toString());
			else
				System.out.println(pr.toString());
		}

	}
}
