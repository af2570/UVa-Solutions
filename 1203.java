/*
 * UVa 1203: Argus
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3644
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	private static class Query {
		public int qnum, val, period;
		
		public Query(int qnum, int val, int period) {
			this.qnum = qnum;
			this.val = val;
			this.period = period;
		}
	}
	
	public static class Qcomp implements Comparator<Query> {
		@Override
		public int compare(Query a, Query b) {
			if (a.val == b.val) {
				return a.qnum < b.qnum ? -1 : 1;
			} else {
				return a.val < b.val ? -1 : 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		String[] lnspl;
		
		int period, qnum, n;
		
		PriorityQueue<Query> q1 = new PriorityQueue<Query>(10, new Qcomp());
		PriorityQueue<Query> q2 = new PriorityQueue<Query>(10, new Qcomp());
		
		while (!(line = br.readLine()).equals("#")) {
			lnspl = line.split("\\s+");
			qnum = Integer.parseInt(lnspl[1]);
			period = Integer.parseInt(lnspl[2]);
			
			q1.add(new Query(qnum, period, period));
		}
		
		n = Integer.parseInt(br.readLine());
	
		while(n > q2.size()) {
			Query c = q1.poll();
			q2.add(new Query(c.qnum, c.val, c.period));
			c.val += c.period;
			q1.add(c);
		}
		
		while(n-- != 0) {
			System.out.println(q2.poll().qnum);
		}
		
	}

}
