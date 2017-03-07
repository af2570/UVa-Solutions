/*
 * UVa 11413: Fill the Containers
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2408
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Integer> vessels;
	public static int n, m, min, minIndex;
	
	public static boolean tryThis(int x) {
		int max = Integer.MIN_VALUE;
		int inUse = 1;
		int current = 0;
		
		for (int v : vessels) {
			max = Math.max(max,  v);
			current += v;
			
			if (current > x) {
				current = v;
				inUse++;
			}
		}
		
		if (max > x)
			return false;
		
		return inUse <= m;
		
	}
	
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		
		
		while (scan.hasNext()) {
			
			n = scan.nextInt();
			m = scan.nextInt(); 

			vessels = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				vessels.add(scan.nextInt());
			}
			
			int l = 0;
			int r = (int) 1e9 + 5;
			
			for (int i = 0; i < 60; ++i) {
				if (tryThis((l + r) / 2)) {
					r = (l + r) / 2;
				} else {
					l = (l + r) / 2;
				}
			}
			
			System.out.println(r);

		}
		
		scan.close();

	}
}
