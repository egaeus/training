package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3056
 * @problemName Flow Layout
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 26/07/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3056{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int maxWidth=0,maxHeight=0,actualHeight=0,actualWidht=0;
			for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
				int W=parseInt(st.nextToken()),H=parseInt(st.nextToken());
				if(W==-1&&H==-1)break;
				if(actualWidht+W>N){
					actualHeight=maxHeight;
					actualWidht=0;
				}
				actualWidht+=W;
				maxWidth=max(maxWidth,actualWidht);
				maxHeight=max(maxHeight,actualHeight+H);
			}
			System.out.println(maxWidth+" x "+maxHeight);
		}
	}
}
