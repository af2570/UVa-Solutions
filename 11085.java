/*
 * UVa 11085: Back to the 8-Queens
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2026
 */

import java.util.Scanner;

public class Main {
	
	static int[] queens = new int[8];
	static int min;

	public static boolean place(int r, int c, int[] moved) {
		for (int pc = 0; pc < c; pc++) {
			int pr = moved[pc];
			
			if (pr == r)
				return false;
			
			int rDist = Math.abs(pr - r);
			int cDist = Math.abs(pc - c);
			
			if (rDist == cDist)
				return false;
		}
		return true;
	}
	
	public static void backtrack(int c, int[] moved) {

		
		for (int i = 0; i < 8; i++) {
			if (place(i, c, moved)) {
				
				moved[c] = i;				
				
				if (c < 7) {
					backtrack(c + 1, moved);
				} else {
					int count = 0;
					for (int j = 0; j < 8; j++) {
						if (moved[j] - (queens[j]) != 0)
							count++;
					}
					
					min = Math.min(count, min);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int n = 1;
		
		while(scan.hasNext()) {
			for (int i = 0; i < 8; i++) {
				queens[i] = scan.nextInt() - 1;
			}
			
			min = Integer.MAX_VALUE;
			
			backtrack(0, queens.clone());
			System.out.println("Case " + n + ": " + min);
			n++;
		}
	}

}
