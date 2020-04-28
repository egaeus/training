package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 130
 * @problemName Roman Roulette
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 6/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa130{
	static int f(int N,int K){
		TreeSet<Integer> set=new TreeSet<Integer>();
		int[] arr=new int[N+1];arr[N]=-1;
		for(int i=0;i<N;i++)set.add(arr[i]=i);
		for(int p=(K-1)%N,i,j;set.size()>1;){
			set.remove(arr[p]);
			arr[p]=-1;
			for(i=p,j=0;j<K;i=(i+1)%N)if(arr[i]!=-1)j++;
			arr[p]=arr[(i+N-1)%N];arr[(i+N-1)%N]=-1;
			for(i=(p+1)%N,j=0;j<K;i=(i+1)%N)if(arr[i]!=-1)j++;
			p=(i+N-1)%N;
		}
		return set.first();
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),K=parseInt(st.nextToken());
			if(N==0&&K==0)break;
			System.out.println((((N-1-f(N,K))+1)%N+1));
		}
	}
}
