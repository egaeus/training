package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2884
 * @problemName The Splitting Club
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 23/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2884 {
	static int a[],mem[];static double R;
	static int f(int h){
		if(h==a.length)return 0;
		if(mem[h]>0)return mem[h];
		int min=MAX_VALUE;
		for(int i=h;i<a.length;i++)
			if(1.*a[i]/a[h]<=R)
				min=Math.min(min,f(i+1)+1);
		return mem[h]=min;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int K=parseInt(st.nextToken());R=Double.parseDouble(st.nextToken());
			if(K==0&&R==0)break;
			int[] arr=new int[120];
			TreeSet<Integer> M=new TreeSet<Integer>();
			for(int k=0;k<K;k++){
				st=new StringTokenizer(in.readLine());
				int N=parseInt(st.nextToken()),m;
				M.add(m=parseInt(st.nextToken())-1);
				arr[m]+=N;
			}
			a=new int[M.size()];int c=0;
			for(int m:M)a[c++]=arr[m];
			Arrays.sort(a);
			mem=new int[c];
			System.out.println(f(0));
		}
	}
}
