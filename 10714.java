/*
 * UVa 10714: Ants
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1655
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		int min, max;
		
		for (int i = 0; i < t; i++) {
			int l = scan.nextInt();
			int n = scan.nextInt();
			min = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				int pos = scan.nextInt();
				min = Math.max(min,  Math.min(pos, l - pos));
				max = Math.max(max, Math.max(pos, l - pos));
			}
			System.out.println(min + " " + max);
		}

	}

}
