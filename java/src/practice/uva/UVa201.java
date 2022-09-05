package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 201
 * @problemName Squares
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jun 17, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa201 {
	static boolean is(int size,int I,int J,int N,boolean[][] vertical,boolean[][] horizontal) {
		for(int i=0;i<size;i++)
			if(!vertical[I+i][J]||!vertical[I+i][J+size]||!horizontal[I][J+i]||!horizontal[I+size][J+i])
				return false;
		return true;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso=1;
		for (String ln;(ln=in.readLine())!=null;caso++) {
			if(caso>1)sb.append("\n**********************************\n\n");
			sb.append("Problem #").append(caso).append("\n\n");
			int N=parseInt(ln.trim());
			boolean[][] horizontal=new boolean[N][N];
			boolean[][] vertical=new boolean[N][N];
			int M=parseInt(in.readLine().trim());
			for(int i=0;i<M;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				char a=st.nextToken().charAt(0);
				int desde=parseInt(st.nextToken())-1,hasta=parseInt(st.nextToken())-1;
				if(a=='H') 
					horizontal[desde][hasta]=true;
				else if(a=='V')
					vertical[hasta][desde]=true;
			}
			int[] cant=new int[N];
			boolean ws=false;
			for(int i=1;i<N;i++)
				for(int I=0;I<N-i;I++)
					for(int J=0;J<N-i;J++)
						if(is(i, I, J, N, vertical, horizontal)) {
							cant[i]++;
							ws=true;
						}
			if(ws){
				for(int i=0;i<N;i++)
					if(cant[i]>0)
						sb.append(cant[i]).append(" square (s) of size ").append(i).append("\n");
			}
			else sb.append("No completed squares can be found.\n");
		}
		System.out.print(new String(sb));
	}
}
