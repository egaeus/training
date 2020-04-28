package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2166
 * @problemName Move the Water
 * @judge http://livearchive.onlinejudge.org/
 * @category easy
 * @level graph
 * @date 08/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class LAUVa2166 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int sumIniciales=0,sumDestinos=0;
			int[] capacidades=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())},
			iniciales=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())},
			destino=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
			if(capacidades[0]==0)break;
			for(int i=0;i<iniciales.length;i++){sumIniciales+=iniciales[i];sumDestinos+=destino[i];}
			boolean ws=sumDestinos==sumIniciales;
			for(int i=0;i<capacidades.length&&ws;i++)ws=capacidades[i]>=destino[i];
			if(ws){
				long[][][] mem=new long[capacidades[0]+1][capacidades[1]+1][capacidades[2]+1];
				for(long i[][]: mem)for(long j[]: i)Arrays.fill(j, -1);
				mem[iniciales[0]][iniciales[1]][iniciales[2]]=0;
				LinkedList<int[]> cola=new LinkedList<int[]>();
				cola.add(iniciales);
				for(;!cola.isEmpty();){
					int[] u=cola.pollFirst();
					if(u.equals(destino))break;
					for(int i=0;i<3;i++)
						for(int j=0;j<3;j++)
							if(i!=j){
								int[] v=u.clone();
								int val=u[i]<=capacidades[j]-u[j]?u[i]:(capacidades[j]-u[j]);
								v[i]-=val;v[j]+=val;
								if(mem[v[0]][v[1]][v[2]]==-1){
									mem[v[0]][v[1]][v[2]]=mem[u[0]][u[1]][u[2]]+1;
									cola.add(v);
								}
							}
				}
				System.out.println(mem[destino[0]][destino[1]][destino[2]]);
			}
			else System.out.println(-1);
		}
	}
}
