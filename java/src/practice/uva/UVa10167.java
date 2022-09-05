package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10167
 * @problemName Birthday Cake
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date Jun 17, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10167 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			int[][] pts=new int[2*N][];
			for(int i=0;i<2*N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				pts[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			int A=-500,B=-500;
			boolean ws=false;
			for(;A<=500&&!ws;A++)
				for(B=-500;B<=500&&!ws;B++) {
					int min=0,max=0;
					for(int i=0;i<2*N;i++)
						if(A*pts[i][0]+B*pts[i][1]>0)max++;
						else if(A*pts[i][0]+B*pts[i][1]<0)min++;
					ws=min==N&&max==N;
				}
			sb.append(A-1).append(" ").append(B-1).append("\n");
		}
		System.out.print(new String(sb));
	}
}
