package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 441
 * @problemName Lotto
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa441 {
	static StringBuilder sb;
	static int[] arr;
	static void f(int p,int l,String s){
		if(l==6){sb.append(s.trim()+"\n");return;}
		if(p==arr.length)return;
		f(p+1,l+1,s+arr[p]+" ");
		f(p+1,l,s);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();int c=0;
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;c++) {
			int N=parseInt(st.nextToken());
			if(N==0)break;
			arr=new int[N];
			if(c>0)sb.append("\n");
			for(int i=0;i<N;i++)arr[i]=parseInt(st.nextToken());
			Arrays.sort(arr);
			f(0,0,"");
		}
		System.out.print(new String(sb));
	}
}
