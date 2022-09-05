package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId JSTAMPS
 * @problemName Stamps
 * @judge http://www.spoj.pl
 * @category sort
 * @level easy
 * @date 09/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJSTAMPS {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int P = parseInt(st.nextToken()), N = parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) arr[i] = parseInt(st.nextToken());
			Arrays.sort(arr);
			int I = 0, cont = 0;
			for(; I < arr.length && cont < P; cont+=arr[arr.length - 1 - (I++)]);
			System.out.println("Scenario #" + c + ":");
			System.out.println(cont>=P?I:"impossible");
			System.out.println();
		}
	}
}
