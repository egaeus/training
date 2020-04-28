package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 118
 * @problemName Mutant Flatworld Explorers
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa118 {
	static int[] f(int p[],int d){
		if(d==0)return new int[]{p[0],p[1]+1};
		if(d==2)return new int[]{p[0],p[1]-1};
		if(d==3)return new int[]{p[0]-1,p[1]};
		return new int[]{p[0]+1,p[1]};
	}
	static int d(char d){
		char[] dirs=new char[]{'N','E','S','W'};
		for(int i=0;i<4;i++)if(dirs[i]==d)return i;
		return -1;
	}
	static char d(int d){
		char[] dirs=new char[]{'N','E','S','W'};
		return dirs[d];
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int W=parseInt(st.nextToken()),N=parseInt(st.nextToken());
		boolean mat[][]=new boolean[N+1][W+1];
		for (String ln;(ln=in.readLine())!=null;) {
			st=new StringTokenizer(ln);
			int p[]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())},d=d(st.nextToken().charAt(0));
			boolean perdido=false;
			char[] str=in.readLine().trim().toCharArray();
			for(int i=0;i<str.length&&!perdido;i++){
				if(str[i]=='R')d=(d+1)%4;
				if(str[i]=='L')d=(d+3)%4;
				if(str[i]=='F'){
					int[] s=f(p,d);
					if(s[0]<0||s[0]>W||s[1]<0||s[1]>N){if(!mat[p[1]][p[0]])mat[p[1]][p[0]]=perdido=true;}
					else p=s;
				}
			}
			System.out.println(p[0]+" "+p[1]+" "+d(d)+(perdido?" LOST":""));
		}
	}
}
