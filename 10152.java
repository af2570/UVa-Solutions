/*
 * UVa 10152: ShellSort
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1093
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static ArrayList<String> original, sorted, toMove;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			int m = Integer.parseInt(br.readLine());
			sorted = new ArrayList<String>();
			original = new ArrayList<String>();
			toMove = new ArrayList<String>();
			
			for (int j = 0; j < m; j++) {
				original.add(br.readLine());
			}
			
			for (int j = 0; j < m; j++) {
				sorted.add(br.readLine());
			}
			
			Collections.reverse(sorted);
			
			for (int j = 0; j < m - 1; ++j) {
				int last = original.indexOf(sorted.get(j));
				int next = original.indexOf(sorted.get(j + 1));
				
				if (next > last) {
					String moved = original.remove(next);
					toMove.add(moved);
					original.add(0, moved);
				}
			}
			
			for (String s : toMove) {
				System.out.println(s);
			}
			System.out.println();
			
		}
	}

}
