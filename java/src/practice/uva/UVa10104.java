package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10104
 * @problemName Euclid Problem
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 26/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10104 {
	static int[] euclidesExtendido(int a,int b){
		for(int q,s=1,t=0,s1=0,t1=1,x;;){
			x=b;q=a/b;b=a%b;a=x;
			x=s1;s1=s-q*s1;s=x;
			x=t1;t1=t-q*t1;t=x;
			if(b==0)return new int[]{a,s,t};
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			int[] res=euclidesExtendido(parseInt(st.nextToken()),parseInt(st.nextToken()));
			System.out.println(res[1]+" "+res[2]+" "+res[0]);
		}
	}
}
