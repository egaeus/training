package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2052
 * @problemName Number Steps
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2052 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int x=parseInt(st.nextToken()),y=parseInt(st.nextToken());
			if(x==y)System.out.println(x%2==0?2*x:(2*x-1));
			else if(x==y+2)System.out.println(x%2==0?(x-1)*2:((x-1)*2-1));
			else System.out.println("No Number");
		}
	}
}
