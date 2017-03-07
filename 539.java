/*
 * UVa 539: The Settlers of Catan
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=480
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int[][] board;
	public static boolean[][] seen;

	public static void init(int n) {
		board = new int[n][n];
		seen = new boolean[n][n];
	}
	
	public static int maxPath(int node, int n) {
		int path = 0;
		
		for (int i = 0; i < n; i++) {
			if (board[node][i] > 0 && !seen[node][i]) {
				seen[node][i] = true;
				seen[i][node] = true;
				path = Math.max(path, maxPath(i, n) + 1);
				seen[node][i] = false;
				seen[i][node] = false;
			}
		}
		return path;
	}
	
	public static int maxPathTotal(int n) {
		int maxPath = 0;
		for (int i = 0; i < n; i++) {
			maxPath = Math.max(maxPath, maxPath(i, n));
		}
		return maxPath;
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] t = br.readLine().split(" ");
		int n = Integer.parseInt(t[0]);
		int m = Integer.parseInt(t[1]);

		while (n != 0 && m != 0) {

			init(n);

			for (int i = 0; i < m; i++) {
				String[] edge = br.readLine().split(" ");

				int a = Integer.parseInt(edge[0]);
				int b = Integer.parseInt(edge[1]);
				
				board[a][b] = 1;
				board[b][a] = 1;
			}
			
			System.out.println(maxPathTotal(n));
			
			t = br.readLine().split(" ");
			n = Integer.parseInt(t[0]);
			m = Integer.parseInt(t[1]);
		}

	}

}
