/*
 * UVa 140: Bandwidth
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=76
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {

	public static String graph;
	public static TreeMap<String, Integer> permutations;
	public static TreeMap<Character, HashSet<Character>> edges;

	public static void init() {
		graph = "";
		permutations = new TreeMap<String, Integer>();
		edges = new TreeMap<Character, HashSet<Character>>();

	}

	public static void allPermutations(String nodes) {
		permutation("", nodes);
	}

	private static void permutation(String perm, String nodes) {
		int n = nodes.length();

		if (n == 0)
			permutations.put(perm, permutationMax(perm));
		else {
			for (int i = 0; i < n; i++) {
				permutation(perm + nodes.charAt(i), nodes.substring(0, i) + nodes.substring(i + 1));
			}
		}
	}

	private static int nodeMax(char c, String perm) {
		HashSet<Character> neighbors = edges.get(c);
		int max = -1;
		for (char n : neighbors) {
			int dist = Math.abs(perm.indexOf(c) - perm.indexOf(n));

			max = dist > max ? dist : max;
		}

		return max;

	}

	public static int permutationMax(String perm) {
		int max = -1;
		for (int i = 0; i < perm.length(); i++) {
			int b = nodeMax(perm.charAt(i), perm);
			max = b > max ? b : max;

		}
		return max;
	}

	public static String minBandwidth() {
		int min = Integer.MAX_VALUE;
		String minPerm = "";

		for (String s : permutations.keySet()) {
			if (permutations.get(s) < min) {
				min = permutations.get(s);
				minPerm = s;
			}
		}
		return minPerm.replace("", " ").trim() + " -> " + min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String raw = br.readLine();

		while (!raw.equals("#")) {

			String[] spl = raw.split(";");
			init();
			for (String s : spl) {
				char c = s.charAt(0);
				if (!edges.containsKey(c)) {	// if we have not seen this character yet, add it to edges and graph
					edges.put(c, new HashSet<Character>());
					graph += c;
				}
				
				char[] neighbors = s.substring(2).toCharArray();

				for (char n : neighbors) {
					if (!edges.containsKey(n)) {	// if we have not seen this character yet, add it to edges and graph
						edges.put(n, new HashSet<Character>());
						graph += n;
					}
					edges.get(n).add(c);
					edges.get(c).add(n);
				}
			}
			
			allPermutations(graph);
			
			System.out.println(minBandwidth());
			raw = br.readLine();

		}

	}

}
