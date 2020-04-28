package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 435
 * @problemName Block Voting 
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 13/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa435{
	static int[] arr;
	static int suma(int n){
		int r=0;
		for(int i=0;i<arr.length;i++)
			if((n&(1<<i))>0)r+=arr[i];
		return r;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int T=parseInt(in.readLine().trim()),t=0;t<T;t++){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken());arr=new int[N];int s=0;
			for(int i=0;i<N;i++)s+=(arr[i]=parseInt(st.nextToken()));
			s/=2;
			int[] sol=new int[N];
			for(int i=0;i<1<<N;i++){
				int suma=suma(i);
				for(int j=0;j<N;j++)
					if((i&(1<<j))>0&&suma>s&&suma-arr[j]<=s)sol[j]++;
			}
			for(int i=0;i<N;i++)sb.append("party "+(i+1)+" has power index "+sol[i]+"\n");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
