/*
 * UVa 11586: Train Tracks
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2633
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.nextLine());
		String[] line;
		
		int m, f;
		
		for (int i = 0; i < n; i++) {
			line = scan.nextLine().split(" ");
			
			if (line.length < 2) {
				System.out.println("NO LOOP");
				continue;
			}
			
			m = 0;
			f = 0;
			
			for (String s : line) {
				if (s.charAt(0) == 'M')
					m++;
				else
					f++;
				
				if (s.charAt(1) == 'M')
					m++;
				else 
					f++;
			}
			
			
			if (m == f) {
				System.out.println("LOOP");
			} else {
				System.out.println("NO LOOP");
			}
		
		}
		
		scan.close();

	}

}
