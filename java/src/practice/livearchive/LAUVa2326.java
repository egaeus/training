package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 11678
 * @problemName Moving Tables
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 23/04/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2326 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			int N=parseInt(in.readLine().trim());
			int sol[]=new int[201],max=0;
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int a=(int)ceil(parseInt(st.nextToken())/2.),b=(int)ceil(parseInt(st.nextToken())/2.);
				for(int j=min(a,b);j<=max(a,b);j++)max=max(max,++sol[j]);
			}
			System.out.println(max*10);
		}
	}
}
