package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2066
 * @problemName PC^3
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 02/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2068 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),P=parseInt(st.nextToken()),
			T=parseInt(st.nextToken()),R=parseInt(st.nextToken());
			if(N==0&&P==0&&T==0&&R==0)break;
			int PS[]=new int[P],pts[]=new int[T];
			boolean[][] sol=new boolean[T][P];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<P;i++)PS[i]=parseInt(st.nextToken());
			for(int i=0;i<R;i++){
				st=new StringTokenizer(in.readLine());
				int t=parseInt(st.nextToken()),p=parseInt(st.nextToken()),time=parseInt(st.nextToken()),d=parseInt(st.nextToken());
				if(d==0&&!sol[t-1][p-1]){pts[t-1]+=PS[p-1];sol[t-1][p-1]=true;}
			}
			int max=0;
			for(int s:pts)max=Math.max(max, s);
			sb.append("Contest "+N+" Winner: ");
			for(int i=0,j=0;i<T;i++)
				if(pts[i]==max)sb.append((j++>0?" and ":"")+"Team "+(i+1));
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
