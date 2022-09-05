package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 4215
 * @problemName Feynman
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa4215{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int res=0;
			for(int i=0;i<=N;i++)
				res+=(N-i)*(N-i);
			System.out.println(res);
		}
	}
}
