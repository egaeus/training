package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 711
 * @problemName Dividing up
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Jun 17, 2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa711 {
	static boolean[] f(int[] arr,int pi,int pf,int sum) {
		boolean[] res=new boolean[sum/2+1];
		res[0]=true;
		int max=0;
		for(int j=pi;j<pf;j++)
			for(int k=0;k<arr[j];k++)
				for(int i=min(max,sum/2-(j+1));i>=0;i--)
					if(res[i]){
						res[i+j+1]=true;
						max=max(max,i+j+1);
					}
		return res;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso=1;
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++) {
			int[] arr=new int[6];
			int sum=0;
			for(int i=0;i<arr.length;i++)
				sum+=(arr[i]=parseInt(st.nextToken()))*(i+1);
			if(sum==0)break;
			sb.append("Collection #").append(caso).append(":\n");
			if(sum%2==0) {
				boolean[] sum1=f(arr, 0, 3, sum);
				boolean[] sum2=f(arr, 3, 6, sum);
				boolean ws=false;
				for(int i=0;i<sum1.length&&!ws;i++)
					if(sum1[i]&&sum2[sum/2-i])
						ws=true;
				if(ws)sb.append("Can be divided.");
				else sb.append("Can't be divided.");
			}
			else sb.append("Can't be divided.");
			sb.append("\n\n");
		}
		System.out.print(new String(sb));
	}
}
