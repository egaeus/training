package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10141
 * @problemName Request for Proposal
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/08/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class UVa10141{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int N=parseInt(st.nextToken()),P=parseInt(st.nextToken());
			if(N==0&&P==0)break;
			if(caso>1)sb.append("\n");
			String[] n=new String[P];
			double [][]arr=new double[P][];
			Integer[] p=new Integer[P];
			for(int i=0;i<N;i++)in.readLine();
			for(int i=0;i<P;i++) {
				n[i]=in.readLine();p[i]=i;
				st=new StringTokenizer(in.readLine()); 
				arr[i]=new double[]{0,Double.parseDouble(st.nextToken())};
				for(int T=(int)(arr[i][0]=parseInt(st.nextToken())),t=0;t++<T;)in.readLine();
			}
			final double[][] copy=arr;
			Arrays.sort(p, new Comparator<Integer>(){
				public int compare(Integer o1,Integer o2){
					if(copy[o1][0]>copy[o2][0])return -1;
					if(copy[o1][0]<copy[o2][0])return 1;
					if(copy[o1][1]<copy[o2][1])return -1;
					if(copy[o1][1]>copy[o2][1])return 1;
					return o1-o2;
				}
			});
			sb.append("RFP #"+caso+"\n"+n[p[0]]+"\n");
		}
		System.out.print(new String(sb));
	}
}
