package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 4244
 * @problemName Party Party Party
 * @judge http://livearchive.onlinejudge.org/
 * @category backtracking
 * @level easy
 * @date 03/09/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVa4244{
	static int f(int n,int v){
		if(n==arr.length)return 0;
		Integer res=mem[n].get(v);
		if(res!=null)return res;
		int max=f(n+1,v);
		for(int i=0;i<31;i++)
			if((v&(1<<i))==0&&arr[n][0]<=i&&arr[n][1]>=i+1)
				max=max(max,f(n+1,v|(1<<i))+1);
		mem[n].put(v,max);
		return max;				
	}
	static int[][] arr;
	static TreeMap<Integer,Integer> mem[]=new TreeMap[100];
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<100;i++)mem[i]=new TreeMap<Integer,Integer>();
		for(int N,t=1;(N=parseInt(in.readLine().trim()))!=0;t++){
			arr=new int[N][];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				arr[i]=new int[]{(parseInt(st.nextToken())-8)*2,(parseInt(st.nextToken())-8)*2};
			}
			sb.append("On day "+t+" Emma can attend as many as "+f(0,0)+" parties.\n");
			for(TreeMap a:mem)a.clear();
		}
		System.out.print(new String(sb));
	}
}
