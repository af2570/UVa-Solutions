/*
 * Splitting Numbers
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3084
 */

import java.util.Scanner;

public class Main {
	
	static String split(String bin, boolean index) {
		
		StringBuilder sb = new StringBuilder(bin);
		
		for (int i = bin.length() - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1') {
				
				if (index)
					sb.replace(i, i + 1, "0");
				
				index = !index;
				
			}

		}
		
		return sb.toString();
	}
	
	static int splitNum(int n, boolean index) {
		
		String binStr = Integer.toBinaryString(n);
		
		String splitStr = split(binStr, index);
		
		return Integer.parseInt(splitStr, 2);
		
	}
	
	static int a(int n) {
		return splitNum(n, false);
	}
	
	static int b(int n) {
		return splitNum(n, true);
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int a, b;
		
		while(n != 0) {
			a = a(n);
			b = b(n);
			
			System.out.println(a + " " + b);
			
			n = scan.nextInt();
		}
		
		
		
		scan.close();
		
		
	}

}
