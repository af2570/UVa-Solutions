/*
* Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1099
*/

import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] p;
	
	static void init(int N) {
		n = N;
		p = new int[n * 2];
		for (int i = 0; i < n * 2; i++) {
			p[i] = i;
		}
	}
	
	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
			return p[x];
		}
		return x;
	}
	
	static boolean areFriends(int x1, int y1) {
		return x1 == y1;
	}
	
	static boolean areEnemies(int x1, int y2) {
		return x1 == y2;
	}
	
	static void setFriends(int x1, int x2, int y1, int y2) {
	
		if (x1 == y2) {
			System.out.println("-1");
			return;
		}
		
		p[x1] = y1;
		p[x2] = y2;
		
	}
	
	static void setEnemies(int x1, int x2, int y1, int y2) {
		
		if (x1 == y1) {
			System.out.println("-1");
			return;
		}
		
		p[x1] = y2;
		p[x2] = y1;
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		init(scan.nextInt());
		
		int c = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		int x1, x2, y1, y2;
		
		while (c != 0) {
			
			x1 = find(x);
			x2 = find(x + n);
			y1 = find(y);
			y2 = find(y + n);
			
			if (c == 1)
				setFriends(x1, x2, y1, y2);
			
			if (c == 2)
				setEnemies(x1, x2, y1, y2);
			
			if (c == 3) {
				if (areFriends(x1, y1))
					System.out.println("1");
				else
					System.out.println("0");
			}
			
			if (c == 4) {
				if (areEnemies(x1, y2))
					System.out.println("1");
				else
					System.out.println("0");
			}
			
			c = scan.nextInt();
			x = scan.nextInt();
			y = scan.nextInt();
		}
		

		scan.close();
	}

}
