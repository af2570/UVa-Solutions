/*
 * UVa 10608: Friends
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1549
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] people;
	public static int[] rank;
	public static int max;
	
	public static void init(int n) {
		people = new int[n + 1];
		rank = new int[n + 1];
		
		for (int i = 0; i < people.length; i++) {
			people[i] = i;
			rank[i] = 1;
		}
		
		max = 1;
	}
	
	public static int find(int x) {
		while (people[x] != x) {
			x = people[x];
		}
		return x;
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
				
		if (rootA != rootB) {
			if (rank[rootA] < rank[rootB]) {
				people[rootA] = rootB;
				rank[rootB] += rank[rootA];
				max = (rank[rootB] > max) ? rank[rootB] : max;
			} else {
				people[rootB] = rootA;
				rank[rootA] += rank[rootB];
				max = (rank[rootA] > max) ? rank[rootA] : max; 
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		int n, m;
		
		while (t-- > 0) {
			n = scan.nextInt();
			m = scan.nextInt();
			
			init(n);
			
			while (m-- > 0) {
				union(scan.nextInt(), scan.nextInt());
				System.out.println(Arrays.toString(people));
				System.out.println(Arrays.toString(rank));
			}
			
			System.out.println(max);
		}
		

	}

}
