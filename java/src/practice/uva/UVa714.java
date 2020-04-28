package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 714
 * @problemName Copying Books
 * @judge http://uva.onlinejudge.org/
 * @category binary search
 * @level easy
 * @date 14/01/2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa714{
	static long[] arr;
	static int K;
	static long bs(long a,long b) {
		if(a==b)return a;
		long p=(a+b)/2;
		if(f(p))return bs(a,p);
		return bs(p+1,b);
	}
	static boolean f(long p){
		int sol=1;long s=0;
		for(int i=0;i<arr.length;s+=arr[i],i++)
			if(arr[i]>p)return false;
			else if(s+arr[i]>p) {
				s=0;
				sol++;
			}
		return sol<=K;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N=parseInt(in.readLine().trim()),n=0;n++<N;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int M=parseInt(st.nextToken());K=parseInt(st.nextToken());
			arr=new long[M];
			st=new StringTokenizer(in.readLine());
			long sum=0;
			for(int i=0;i<M;i++)sum+=(arr[i]=parseInt(st.nextToken()));
			long sol=bs(0,sum),s=sol+1;
			LinkedList<LinkedList<Long>> solution=new LinkedList<LinkedList<Long>>();
			for(int i=M-1;i>=0;s+=arr[i],i--) {
				if(s+arr[i]>sol||i+1<=K-solution.size()) {
					solution.addFirst(new LinkedList<Long>());					
					s=0;
				}
				solution.getFirst().addFirst(arr[i]);
			}
			for(LinkedList<Long> a:solution) {
				if(a!=solution.getFirst())sb.append(" / ");
				int c=0;
				for(long b:a){
					if(c++>0)sb.append(" ");
					sb.append(b);
				}
			}
			sb.append("\n");
					
		}
		System.out.print(new String(sb));
	}
}
