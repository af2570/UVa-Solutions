/*
 * UVa 12289: One-Two-Three
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3710
 */

import java.util.Scanner;

public class Main {
	
	public static boolean isClose(String target, String attempt) {
		
		if (target.length() != attempt.length())
			return false;
		
		int error = 0;
		
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) != attempt.charAt(i))
				error++;
			
			if (error > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String inp;
		
		for (int i = 0; i < n; i++) {
			inp = scan.next();
			
			if (isClose("one", inp))
				System.out.println("1");
			else if (isClose("two", inp))
				System.out.println("2");
			else if (isClose("three", inp))
				System.out.println("3");
		}
		
		scan.close();

	}

}
