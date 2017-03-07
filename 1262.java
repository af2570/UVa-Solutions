/*
 * UVa 1262: Password
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3703
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static String[] grid1, grid2;
	public static ArrayList<Set<Character>> unique, rep;
	public static ArrayList<Character[]> sorted;
	public static ArrayList<String> poss;

	public static void init() {
		grid1 = new String[6];
		grid2 = new String[6];

		unique = new ArrayList<Set<Character>>();
		rep = new ArrayList<Set<Character>>();

		poss = new ArrayList<String>();
		sorted = new ArrayList<Character[]>();

		for (int i = 0; i < 5; i++) {
			unique.add(new HashSet<Character>());
			rep.add(new HashSet<Character>());
		}
	}

	public static void getPoss(String current, int i) {
		try {
			for (Character c : sorted.get(i)) {
				getPoss(current + c, i + 1);
			}
		} catch (IndexOutOfBoundsException e) {
			poss.add(current);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			init();

			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < 6; i++) {
				String s = br.readLine();
				grid1[i] = s;
				for (int j = 0; j < 5; j++) {
					unique.get(j).add(s.charAt(j));
				}
			}
			for (int i = 0; i < 6; i++) {
				String s = br.readLine();
				grid2[i] = s;
				for (int j = 0; j < 5; j++) {
					char c = s.charAt(j);
					if (unique.get(j).contains(c)) {
						rep.get(j).add(c);
					}
				}
			}
			
			int j = 0;
			for (Set<Character> s : rep) {
				Character[] sArr = s.toArray(new Character[s.size()]);
				Arrays.sort(sArr);
				sorted.add(sArr);
			}
			
			String res = "";
			
			getPoss("", 0);
			
			Collections.sort(poss);
			try {
				res = poss.get(k - 1);
			} catch (IndexOutOfBoundsException e) {
				res = "NO";
			}
			System.out.println(res);
		}
	}

}
