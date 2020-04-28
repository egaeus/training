package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 793
 * @problemName Network Connections
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date Nov 5, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa793 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=parseInt(in.readLine().trim());t<T;t++) {
			if(t==0)
				in.readLine();
			else
				sb.append("\n");
			int N=parseInt(in.readLine().trim());
			TreeSet<Integer> lAdy[]=new TreeSet[N];
			for(int i=0;i<N;i++){
				lAdy[i]=new TreeSet<Integer>();
				lAdy[i].add(i);
			}
			int[] sol=new int[2];
			for(String ln;(ln=in.readLine())!=null&&!ln.equals("");) {
				StringTokenizer st=new StringTokenizer(ln);
				char a=st.nextToken().charAt(0);
				int desde=parseInt(st.nextToken())-1,hasta=parseInt(st.nextToken())-1;
				if(a=='c') {
					lAdy[desde].addAll(lAdy[hasta]);
					for(int u:lAdy[desde])
						lAdy[u]=lAdy[desde];
				}
				else {
					if(lAdy[desde].contains(hasta))
						sol[0]++;
					else
						sol[1]++;
				}
			}
			sb.append(sol[0]).append(",").append(sol[1]).append("\n");
		}
		System.out.print(new String(sb));
	}
}
