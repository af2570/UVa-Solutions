/*
 * UVa 11876: N + NOD(N)
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2987
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
	
	public static BitSet primes;
	public static ArrayList<Integer> primeVals;

	public static void primes(int x) {
		primes = new BitSet(x + 1);
		primeVals = new ArrayList<Integer>();
		primes.set(2, x + 1);
		
		for (int i = 2; i < x + 1; i++) {
			if (primes.get(i)) {
				for (int j = i * i; j <= x + 1; j += i) {
					primes.clear(j);
				}
				primeVals.add(i);
			}
		}

	}
	
	public static int nod(int x) {

		int f = primeVals.get(0);
		int n = 1;
		int pIndex = 0;
		
		while (f * f <= x) {
			int pow = 0;
			while (x % f == 0) {
				x = x / f;
				pow++;
			}
			
			n = n * (pow + 1);
			f = primeVals.get(++pIndex);
		}
		
		if (x != 1)
			n = n * 2;
		
		return n;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		primes(1000);

		int[] nds = new int[1100000];
		Arrays.fill(nds, 0);
		nds[1] = 1;
		int n = 1;
		
		for (int i = 1; i < 65000; i++) {
			n += nod(n);
			nds[n] = i + 1;
		}
		
		for (int i = 1; i <= t; i++) {

			int a = scan.nextInt();
			int b = scan.nextInt();
			
			while (nds[a] == 0)
				a++;
			
			while (nds[b] == 0)
				b--;
			

			System.out.println("Case " + i + ": " + ((nds[b] - nds[a]) + 1));
		}

	}

}
