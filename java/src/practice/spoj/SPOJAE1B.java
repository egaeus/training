package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId AE1B
 * @problemName Tables
 * @judge http://www.spoj.pl
 * @category sorting
 * @level easy
 * @date 22/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJAE1B {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = parseInt(st.nextToken()), costo = parseInt(st.nextToken())*parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++)arr[i] = parseInt(st.nextToken());
		Arrays.sort(arr);
		int I = 0;
		for(int sol = 0; sol < costo; sol+=arr[arr.length-1-I], I++);
		System.out.println(I);
	}
}
