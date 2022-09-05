package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10361
 * @problemName Automatic Poetry
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10361 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			String l1 = in.readLine();
			char[] cad = l1.toCharArray();
			String l2 = in.readLine();
			String arr[] = new String[5];
			Arrays.fill(arr, "");
			for(int i = 0, j = 0; i < cad.length; i++)
				if(cad[i] == '<' || cad[i] == '>')j++;
				else arr[j]+=cad[i];
			sb.append(l1.replaceAll("[<>]", "") + "\n");
			sb.append(l2.replace("...", arr[3] + arr[2] + arr[1] + arr[4]) + "\n");
		}
		System.out.print(new String(sb));
	}
}
