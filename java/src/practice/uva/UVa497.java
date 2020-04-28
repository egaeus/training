package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 497
 * @problemName Strategic Defense Initiative
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Aug 29, 2013
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa497 {
	static ArrayList<Integer> arr;
	static int[][] mem[];
	static int f(int p,int ant) {
		if(p==arr.size())return 0;
		if(mem[p][ant]!=null)return mem[p][ant][0];
		int max=f(p+1,ant);
		int[] s=new int[]{max,0};
		if(arr.get(ant)<arr.get(p)&&f(p+1,p)+1>max)
			s=new int[]{max=f(p+1,p)+1,1};
		mem[p][ant]=s;
		return max;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T=parseInt(in.readLine().trim()),t=0;t++<T;) {
			if(t==1)in.readLine();
			arr=new ArrayList<Integer>();
			arr.add(MIN_VALUE);
			for(String ln;(ln=in.readLine())!=null&&!ln.equals("");)
				arr.add(parseInt(ln.trim()));
			mem=new int[arr.size()][arr.size()][];
			sb.append("Max hits: ").append(f(1,0)).append("\n");
			for(int p=1,ant=0;p<arr.size();) 
				if(mem[p][ant][1]==0)p++;
				else {
					sb.append(arr.get(p)).append("\n");
					ant=p++;
				}
			sb.append(t<T?"\n":"");
		}
		System.out.print(new String(sb));
	}
}
