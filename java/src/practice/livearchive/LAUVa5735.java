package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 5735
 * @problemName Stock Prices
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Aug 21, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class LAUVa5735 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso=1;
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++) {
			int N=parseInt(st.nextToken()),L=parseInt(st.nextToken()),H=parseInt(st.nextToken());
			if(N==0&&L==0&&H==0)break;
			int[][] arr=new int[N][];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)
				arr[i]=new int[]{parseInt(st.nextToken()),i+1};
			Arrays.sort(arr,new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[0]!=o2[0])return o1[0]-o2[0];
					return o1[1]-o2[1];
				}
			});
			int[] s1=new int[L],s2=new int[H];
			for(int i=0;i<L;i++)
				s1[i]=arr[i][1];
			for(int i=arr.length-1,j=0;j<H;j++,i--)
				s2[j]=arr[i][1];
			Arrays.sort(s1);
			Arrays.sort(s2);
			sb.append("Case ").append(caso).append("\n");
			for(int i=0;i<L;i++)
				sb.append(i>0?" ":"").append(s1[i]);
			sb.append("\n");
			for(int i=s2.length-1;i>=0;i--)
				sb.append(i<s2.length-1?" ":"").append(s2[i]);
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
