/*
 * UVa 12015: Google is Feeling Lucky
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3166
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int max = Integer.MIN_VALUE;
		ArrayList<String> winners = new ArrayList<String>();
		
		String url = "";
		int relevance;
		
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < 10; j++) {
				url = scan.next();
				relevance = scan.nextInt();
				
				if (relevance > max) {
					winners.clear();
					max = relevance;
				} 
				
				if (relevance == max) {
					winners.add(url);
				}
			}
			
			System.out.println("Case #" + (i + 1) + ":");
			for (String s : winners) {
				System.out.println(s);
			}
			
			winners = new ArrayList<String>();
			max = Integer.MIN_VALUE;
		}

		scan.close();
	}

}
