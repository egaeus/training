package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 443
 * @problemName Humble Numbers
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 21/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
public class UVa443 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int p[]=new int[]{2,3,5,7},c=1,v=0,MAX=1000000;
		long[][] res=new long[MAX][];res[0]=new long[]{1,0};
		HashSet<Long> vis=new HashSet<Long>();
		for(;v<c;v++){
			for(int k=0;k<4;k++)if(res[v][1]<30&&res[v][0]*p[k]>0&&!vis.contains(res[v][0]*p[k]))
				{res[c++]=new long[]{res[v][0]*p[k],res[v][1]+1};vis.add(res[v][0]*p[k]);}
		}
		Arrays.sort(res,0,c,new Comparator<long[]>(){
			public int compare(long[] arg0, long[] arg1) {
				return arg0[0]<arg1[0]?-1:1;
			}
		});
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			String card="";
			if((N/10)%10==1)card=N+"th";
			else if(N%10==1)card=N+"st";
			else if(N%10==2)card=N+"nd";
			else if(N%10==3)card=N+"rd";
			else card=N+"th";
			System.out.println("The "+card+" humble number is "+res[N-1][0]+".");
		}
	}
}
