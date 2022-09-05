package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId PIGBANK
 * @problemName Piggy - Bank
 * @judge http://www.spoj.pl
 * @category dp
 * @level easy
 * @date 24/02/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJPIGBANK {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C; ){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int W = abs(parseInt(st.nextToken()) - parseInt(st.nextToken()));
			int N = parseInt(in.readLine());
			int[][] coins = new int[N][2];
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(in.readLine());
				coins[i][0] = parseInt(st.nextToken());
				coins[i][1] = parseInt(st.nextToken());
			}
			long[] mem = new long[W+1];
			Arrays.fill(mem, MAX_VALUE);
			mem[0] = 0;
			for(int[] coin: coins)
				for(int i = 0; i < W+1; i++)
					if(mem[i]!=MAX_VALUE&&i+coin[1]<W+1&&mem[i+coin[1]]>mem[i]+coin[0])
						mem[i+coin[1]]=mem[i]+coin[0];
			sb.append(mem[W]==MAX_VALUE?"This is impossible.\n":("The minimum amount of money in the piggy-bank is " + mem[W] + ".\n"));
		}
		System.out.print(new String(sb));
	}
}
