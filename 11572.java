/*
 * UVa 11572: Unique Snowflakes
 * 
 * Problem Statement: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2619
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		Map<String, Integer> pos;
		
		int max, cnt, start, n, xPos;
		
		String x;
		
		while (t-- > 0) {
			max = 0;
			cnt = 0;
			start = 0;
			pos = new HashMap<String, Integer>();
			n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n; i++) {
				x = br.readLine();
				
				if (pos.containsKey(x)) {
					xPos = pos.get(x);
					
					if (xPos >= start)
						start = xPos + 1;
					
					if (i - start + 1 > max)
						max = i - start + 1;
					
				} else {
					if (i + 1 - start > max)
						max = i + 1 - start;
				}
				pos.put(x, i);
					
			}
			
			System.out.println(max);
		}
		
		
	}

}
