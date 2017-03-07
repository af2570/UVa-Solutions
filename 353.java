/*
 * UVa 353: Pesky Palindromes
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=289
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	public static boolean isPal(String s) {
		StringBuffer sb = new StringBuffer(s);
		String rev = sb.reverse().toString();
		
		return s.equalsIgnoreCase(rev);
	}
	
	public static int countPal(String str) {
		
		ArrayList<String> p = new ArrayList<String>();
		
		for (int i = 0; i <= str.length() - 1; i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				
				String test = str.substring(i, j);
				
				if (isPal(test) && !test.equals("") && !p.contains(test))
					p.add(test);
			}
		}
		
		return p.size();
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String inp;
		
		while(scan.hasNext()) {
			inp = scan.next();
			System.out.println("The string '" + inp + "' contains " + countPal(inp) + " palindromes.");
		}
		
		scan.close();

	}

}
