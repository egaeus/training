package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4964
 * @problemName What's Next?
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 08/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa4964 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int A=parseInt(st.nextToken()),B=parseInt(st.nextToken()),C=parseInt(st.nextToken());
			if(A==0&&B==0&&C==0)break;
			if(B-A==C-B)System.out.println("AP "+(C+B-A));
			else System.out.println("GP "+(C*(B/A)));
		}
	}
}
