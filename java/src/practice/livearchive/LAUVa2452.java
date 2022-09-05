package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2452
 * @problemName Cable master
 * @judge http://uva.onlinejudge.org/
 * @category binary search
 * @level easy
 * @date 17/04/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2452{
	static int arr[];static int K;
	static boolean sePuede(int p){
		int s=0;
		for(int i=0;i<arr.length&&s<K;i++)s+=(arr[i]/p);
		return s>=K;
	}
	static int binaria(int k,int s){
		if(k==s)return k;
		int p=(int)Math.ceil((k+s)/2.);
		if(sePuede(p))return binaria(p,s);
		return binaria(k,p-1);
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t<T;t++){
			if(t>0)sb.append("\n");
			in.readLine();
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken());K=parseInt(st.nextToken());
			arr=new int[N];int b=0;
			for(int i=0;i<N;i++)b=max(b,arr[i]=(int)((Double.parseDouble(in.readLine().trim()))*100));
			int res=binaria(0,b);
			sb.append((res/100)+"."+(res%100<10?"0":"")+(res%100)+"\n");
		}
		System.out.print(new String(sb));
	}
}
