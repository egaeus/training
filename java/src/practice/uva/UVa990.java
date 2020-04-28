package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 990
 * @problemName Diving for Gold
 * @judge http://uva.onlinejudge.org/
 * @category pd
 * @level easy
 * @date 03/11/2010
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa990 {
	static Point mem[][];
	static int[][] arr;
	static int w;
	static int function(int pos, int t){
		if(pos >= arr.length)return 0;
		if(mem[pos][t] != null)return mem[pos][t].x;
		int val1 = function(pos + 1, t);
		int val2 = MIN_VALUE; 
		if(3*arr[pos][0]*w <= t)
			val2 = function(pos + 1, t - 3*arr[pos][0]*w) + arr[pos][1];
		if(val2 >= val1)mem[pos][t] = new Point(val2, 1);
		else mem[pos][t] = new Point(val1, 0);
		return mem[pos][t].x;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int t = parseInt(st.nextToken());
			w = parseInt(st.nextToken());
			int N = parseInt(in.readLine().trim());
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim());
				arr[i][0] = parseInt(st.nextToken());
				arr[i][1] = parseInt(st.nextToken());
			}
			mem = new Point[N][t+1];
			System.out.println(function(0, t));
			ArrayList<Integer> sol = new ArrayList<Integer>();
			for (int res = 0, pos = 0, T = t; res < function(0, t); ) {
				if(mem[pos][T].y == 1){
					sol.add(pos);
					T -= 3*arr[pos][0]*w;
					res += arr[pos][1];
				}
				pos++;
			}
			System.out.println(sol.size());
			for(int p: sol)
				System.out.println(arr[p][0] + " " + arr[p][1]);
			if(in.readLine() == null)break;
			System.out.println();
		}
	}
}
