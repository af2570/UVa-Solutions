/*
 * UVa 435: Block Voting
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=376
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static LinkedList<Integer> voters;
	public static int majority;

	public static void init(int n, Scanner scan) {
		voters = new LinkedList<Integer>();

		int x, sum = 0;

		for (int i = 0; i < n; i++) {
			x = scan.nextInt();
			voters.add(x);
			sum += x;
		}
		majority = (sum / 2) + 1;

	}
	
	public static int powIndex(int total, int constituent, LinkedList<Integer> available) {
		int n = (total >= majority && constituent < majority) ? 1 : 0;
		
		int c;
		
		while (!available.isEmpty()) {
			c = available.removeFirst();
			n += powIndex(total + c, constituent + c, new LinkedList<Integer>(available));
		}
		return n;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int n, current, power;

		while (t-- > 0) {
			n = scan.nextInt();

			init(n, scan);

			for (int i = 1; i <= n; i++) {
				current = voters.removeFirst();
				power = powIndex(current, 0, new LinkedList<Integer>(voters));
				System.out.println("party " + i + " has power index " + power);
				voters.add(current);
			}
			System.out.println();
		}

	}

}
