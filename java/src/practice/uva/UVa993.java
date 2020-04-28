package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 993
 * @problemName Product of digits
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 26/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa993 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, C = parseInt(in.readLine().trim()); i < C; i++) {
			int N = parseInt(in.readLine().trim());
			if(N==1)System.out.println(N);
			else if(N==0)System.out.println(10);
			else{
				String res = "";
				for (int j = 9; j > 1; ){
					if(N%j==0){res+=j; N/=j;}
					else j--;
				}
				char[] result = res.toCharArray();
				Arrays.sort(result);
				System.out.println(N==1?new String(result):-1);	
			}
		}
	}
}
