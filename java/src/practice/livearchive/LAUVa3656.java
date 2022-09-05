package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 3656
 * @problemName Odd or Even
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/07/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3656{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int s[][]=new int[2][2];
			for(int i=0;i<2;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++)s[i][parseInt(st.nextToken())%2]++;
			}
			System.out.println(abs(s[0][0]-s[1][1]));
		}
	}
}
