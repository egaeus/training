package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 111
 * @problemName History Grading
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 07/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa111 {
	static int N;
	static int[] arr, sol;
	static int[][] mem;
	static int function(int pos, int pos2){
		if(pos==N||pos2==N)return 0;
		if(mem[pos][pos2] > 0)return mem[pos][pos2];
		if(arr[pos]==sol[pos2])return mem[pos][pos2] = Math.max(function(pos+1, pos2+1) + 1, Math.max(function(pos, pos2+1), function(pos+1, pos2)));
		return mem[pos][pos2] = Math.max(function(pos, pos2+1), function(pos+1, pos2));
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(in.readLine().trim());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		for (int i = 0; i < N; i++) arr[parseInt(st.nextToken()) - 1] = i;
		for (String ln; (ln = in.readLine()) != null; ) {
			st = new StringTokenizer(ln.trim());
			sol = new int[N];
			for (int i = 0; i < N; i++) sol[parseInt(st.nextToken()) - 1] = i;
			mem = new int[N][N]; 
			System.out.println(function(0, 0));
		}
	}
}
