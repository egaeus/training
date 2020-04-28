package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10105
 * @problemName Polynomial Coefficients
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa10105{
	static long[] toArray(long a, int k){
		long[] res=new long[k];
		for(int i=0;i<k;i++){
			res[i]=a%16;
			a=a>>4;
		}
		return res;
	}
	static long toLong(long[] a){
		long res=0;
		for(int i=0;i<a.length;i++)res|=(a[i]<<(i*4));
		return res;
	}
	static long f(long a){
		if(a==0)return 1;
		if(mem.containsKey(a))return mem.get(a);
		long[] b=toArray(a,K);
		long res=0;
		for(int i=0;i<K;i++)
			if(b[i]>0){
				b[i]--;
				res+=f(toLong(b));
				b[i]++;
			}
		mem.put(a,res);
		return res;
	}
	static TreeMap<Long,Long> mem;
	static int K;
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			int N=parseInt(st.nextToken());K=parseInt(st.nextToken());
			long[] caso=new long[K];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<K;i++)caso[i]=parseInt(st.nextToken());
			mem=new TreeMap<Long,Long>();
			System.out.println(f(toLong(caso)));
		}
		System.out.print(new String(sb));
	}
}
