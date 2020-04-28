package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5789
 * @problemName Army Buddies
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa5789 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int[] izq=new int[100001],der=new int[100001];
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int L=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(L==0&&M==0)break;
			for(int i=0;i<=L;i++){
				if(i<=1)izq[i]=-1;
				else izq[i]=i-1;
				if(i<L)der[i]=i+1;
				else der[i]=-1;
			}
			for(int i=0;i<M;i++){
				st=new StringTokenizer(in.readLine());
				int l=parseInt(st.nextToken()),r=parseInt(st.nextToken());
				sb.append((izq[l]<1?"*":izq[l]));
				sb.append(" ");
				sb.append(der[r]<1?"*":der[r]);
				sb.append("\n");
				if(izq[l]>0)der[izq[l]]=der[r];
				if(der[r]>0)izq[der[r]]=izq[l];
			}
			sb.append("-\n");
		}
		System.out.print(new String(sb));
	}
}
