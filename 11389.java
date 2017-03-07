/*
 * UVa 11389: The Bus Driver Problem
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2384
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int d = scan.nextInt();
		int r = scan.nextInt();
		int[] morning, evening;

		while (n > 0 && d > 0 && r > 0) {

			// route lengths
			morning = new int[n];
			evening = new int[n];

			for (int i = 0; i < n; i++) {
				morning[i] = scan.nextInt();
			}

			Arrays.sort(morning);

			for (int i = 0; i < n; i++) {
				evening[i] = scan.nextInt();
			}

			Arrays.sort(evening);
			
			int o = 0;
			for (int i = 0; i < n; i++) {
				int h = morning[i] + evening[n - (i + 1)];
				if (h > d) {
					o += (h - d);
				}
			}
			System.out.println(o * r);
			
			n = scan.nextInt();
			d = scan.nextInt();
			r = scan.nextInt();

		}
	}

}
