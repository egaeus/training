package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId SAMER08C
 * @problemName Candy
 * @judge http://www.spoj.pl
 * @category pd
 * @level medium
 * @date 19/10/2010
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJSAMER08C {
	static int function(int[] arr){
		if(arr.length == 1)return arr[0];
		int[] mem = new int[arr.length];
		mem[arr.length - 1] = arr[arr.length - 1];
		mem[arr.length - 2] = max(arr[arr.length - 2], mem[arr.length - 1]);
		for(int i = arr.length - 3; i >= 0; i--)
			mem[i] = max(arr[i] + mem[i+2], mem[i+1]);
		return max(mem[0], mem[1]);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int M = parseInt(st.nextToken()), N = parseInt(st.nextToken());
			if(M==0 && N == 0)break;
			int[][] mat = new int[M][N];
			for (int i = 0; i < M; i++){
				st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) 
					mat[i][j] = parseInt(st.nextToken());
			}
			int[] arr = new int[M];
			for (int i = 0; i < arr.length; i++)
				arr[i] = function(mat[i]);
			System.out.println(function(arr));
		}
	}
}
