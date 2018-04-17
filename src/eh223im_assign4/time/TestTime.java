package eh223im_assign4.time;

import java.util.Arrays;

public class TestTime {
	public static void main(String[] args) {
		long before;
		long after;
		double elapsed;

		before = System.nanoTime();
		System.out.println(before);
		try {
			Thread.sleep(500);
		}
		catch (Exception ignored) {
		}

		after = System.nanoTime();

		System.out.println(after);

		elapsed = (double) (after - before)/1E9;

		System.out.println(elapsed);

	}
}