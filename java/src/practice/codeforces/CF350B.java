package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 350B
 * @problemName Resort
 * @judge http://www.codeforces.com
 * @category graph
 * @level easy
 * @date Oct 1, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class CF350B {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=parseInt(in.readLine().trim());
		boolean hotels[]=new boolean[N];
		StringTokenizer st=new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++)
			hotels[i]=parseInt(st.nextToken())==1;
		st=new StringTokenizer(in.readLine());
		ArrayList<Integer> lAdy[]=new ArrayList[N];
		ArrayList<Integer> lAdySol[]=new ArrayList[N];
		for(int i=0;i<N;i++)
			lAdySol[i]=new ArrayList<Integer>();
		int[] cant=new int[N];
		for(int i=0;i<N;i++) {
			lAdy[i]=new ArrayList<Integer>();
			int v=parseInt(st.nextToken());
			if(v>0) {
				lAdy[i].add(v-1);
				lAdySol[v-1].add(i);
				cant[v-1]++;
			}
		}
		int max=0,sol=-1;
		int[][] cola=new int[N][2];
		for(int i=0;i<N;i++) {
			int p=0,c=0;
			if(hotels[i]) {
				cola[c][0]=i;
				cola[c++][1]=1;
				for(;p<c;) {
					int[] n=cola[p++];
					if(n[1]>max) {
						max=n[1];
						sol=n[0];
					}
					for(int a:lAdy[n[0]])
						if(cant[a]==1) {
							cola[c][0]=a;
							cola[c++][1]=n[1]+1;
						}
				}
			}
		}
		sb.append(max).append("\n");
		for(;!hotels[sol];sol=lAdySol[sol].get(0))
			sb.append(sol+1).append(" ");
		sb.append(sol+1).append("\n");
		System.out.print(new String(sb));
	}
}
