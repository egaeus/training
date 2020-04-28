package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10474
 * @problemName Where is the Marble? 
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 24/02/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10474 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++) {
			int N=parseInt(st.nextToken()), Q=parseInt(st.nextToken());
			if(N==0&&Q==0)break;
			sb.append("CASE# "+caso+":\n");
			int[] arr=new int[N];int[] pos=new int[10001];Arrays.fill(pos,MAX_VALUE);
			for(int i=0;i<arr.length;i++)arr[i]=parseInt(in.readLine().trim());
			Arrays.sort(arr);
			for(int i=0;i<arr.length;i++)pos[arr[i]]=min(pos[arr[i]],i);
			for(int i=0,n;i<Q;i++){
				n=parseInt(in.readLine().trim());
				if(pos[n]==MAX_VALUE)sb.append(n+" not found\n");
				else sb.append(n+" found at "+(pos[n]+1)+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
