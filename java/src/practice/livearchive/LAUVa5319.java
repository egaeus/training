package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5319
 * @problemName Sum It Up
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 11/08/2012
 **/
import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa5319{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int T=parseInt(st.nextToken()),N=parseInt(st.nextToken());
			if(N==0)break;
			int[] arr=new int[N];
			TreeSet<int[]> set=new TreeSet<int[]>(new Comparator<int[]>(){
				public int compare(int[] o1,int[] o2){
					for(int i=0;i<o1.length&&i<o2.length;i++)
						if(o1[i]!=o2[i])return o2[i]-o1[i];
					return 0;
				}
				
			});
			for(int i=0;i<N;i++)arr[i]=parseInt(st.nextToken());
			for(int i=0;i<(1<<N);i++){
				int s=0,c=0,a[]=new int[bitCount(i)];
				for(int j=0;j<N;j++)
					if((i&(1<<j))>0){s+=arr[j];a[c++]=arr[j];}
				if(s==T)set.add(a);
			}
			sb.append("Sums of "+T+":\n");
			if(set.size()==0)sb.append("NONE\n");
			else for(int[] a:set){
				boolean ws=false;
				for(int i=0;i<a.length;i++,ws=true)sb.append((!ws?"":"+")+a[i]);
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
