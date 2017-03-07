/*
 * UVa 12346: Water Gate Management
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3768
 */

import java.util.Scanner;

public class Main {
	
	public static int[][] gates;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		
		gates = new int[n][2];
	
		for (int i = 0; i < n; i++) {
			gates[i][0] = scan.nextInt();
			gates[i][1] = scan.nextInt();
		}
		
		int m = scan.nextInt();
		int v, t;
		for (int i = 1; i <= m; i++) {
			v = scan.nextInt();
			t = scan.nextInt();
			
			int min = Integer.MAX_VALUE;
			
			int tf, tc;
			
			for (int j = 0; j < (1 << n); j++) {
				tf = 0;
				tc = 0;
				
				for (int k = 0; k < n; k++) {
					
					tf += (1 & (j >> k)) * gates[k][0];
					tc += (1 & (j >> k)) * gates[k][1];
				}
				
				if (tf * t >= v) {
					min = Math.min(min, tc);
				}
			}
			
			if (min < Integer.MAX_VALUE)
				System.out.println("Case " + i + ": " + min);
			else
				System.out.println("Case " + i + ": IMPOSSIBLE");
		}

	}

}
