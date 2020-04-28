package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 10364
 * @problemName practice.uva.UVa10364.java
 * @judge http://www.spoj.pl | http://uva.onlinejudge.org/ | http://livearchive.onlinejudge.org/
 * @category ---
 * @level ???
 * @date Jul 2, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa10364 {
	static int N,mem[][];
	static ArrayList<Integer> W;
	static boolean f(int A,int i) {
		if(i==0)return A==(1<<N)-1;
		if(mem[i][A]>0)return mem[i][A]==1;
		for(int j=0;j<W.size();j++) 
			if((j&W.get(j))==0&&f(A|W.get(j),i-1)) {
				mem[i][A]=1;
				return true;
			}
		mem[i][A]=2;
		return false;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		mem=new int[5][1<<20];
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			N=parseInt(st.nextToken());
			int[] arr=new int[N];
			W=new ArrayList<Integer>();
			int L=0;
			for(int i=0;i<N;i++)L+=(arr[i]=parseInt(st.nextToken()));
			if(L%4==0) {
				L/=4;
				for(int i=0;i<(1<<N);i++) {
					int sum=0;
					for(int j=0;j<N;j++) 
						if((i&(1<<j))!=0)
							sum+=arr[j];
					if(sum==L)
						W.add(i);
					for(int j=0;j<5;j++)mem[j][i]=0;
				}
				sb.append(f(0,4)?"yes\n":"no\n");
			}else sb.append("no\n");
		}
		System.out.print(new String(sb));
	}
}