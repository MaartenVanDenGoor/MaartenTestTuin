package nl.maarten.ocp.m8concurrency;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class PriemGetal extends RecursiveAction {
	private final int start, end;
	private static final int THRESHOLD = 100;
	static List<Integer> lijst = new CopyOnWriteArrayList<>();

	//
	PriemGetal(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public static boolean isPriem(int getal) {
		if (getal <= 1)
			return false;
		if (getal == 2)
			return true;
		if (getal % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(getal); i += 2) {
			if (getal % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public void compute() {
		if (end - start <= THRESHOLD) {
			// Niet splitsen
			for (int cnt = start; cnt <= end; cnt++) {
				if (isPriem(cnt)) {
					lijst.add(cnt);
				}
			}
		} else {
			// splitsen
			int mid = start + THRESHOLD;
			PriemGetal p1 = new PriemGetal(start, mid);
			PriemGetal p2 = new PriemGetal(mid + 1, end);
			invokeAll(p1, p2);
		}
	}

	public static void main(String[] args) {
		ForkJoinPool fjPool = new ForkJoinPool();
		PriemGetal priem = new PriemGetal(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		fjPool.invoke(priem);
		fjPool.shutdown();
		Collections.reverse(PriemGetal.lijst);
		PriemGetal.lijst.stream().forEach(System.out::println);

		
	}


}
