package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 459
 * @problemName Graph Connectivity
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 12/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class UVa459 {
	static int f(boolean[][] mAdy){
		int s=0,n;boolean[] v=new boolean[n=mAdy.length];
		for(int i=0;i<n;i++)if(!v[i]){s++;f(mAdy,v,i,n);}
		return s;
	}
	static void f(boolean[][] mAdy,boolean[] v,int d,int n){
		v[d]=true;LinkedList<Integer> cola=new LinkedList<Integer>();cola.add(d);
		for(int u;!cola.isEmpty();){
			u=cola.pollFirst();
			for(int i=0;i<n;i++)if(mAdy[u][i]&&!v[i]){v[i]=true;cola.add(i);}
		}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String ln;
		for (int t=0,T=parseInt(in.readLine().trim());t<T;t++) {
			if(t>0)sb.append("\n");else ln=in.readLine();
			int cota=in.readLine().trim().charAt(0)-'A';
			boolean[][] mAdy=new boolean[cota+1][cota+1];
			for(ln="-";(ln=in.readLine())!=null&&(ln=ln.trim()).length()>0;)
				mAdy[ln.charAt(0)-'A'][ln.charAt(1)-'A']=mAdy[ln.charAt(1)-'A'][ln.charAt(0)-'A']=true;
			sb.append(f(mAdy)+"\n");
		}
		System.out.print(new String(sb));
	}
}
