package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2858
 * @problemName Blurred Vision
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 24/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2858 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;!(ln=in.readLine().trim()).equals("ENDOFINPUT");){
			StringTokenizer st=new StringTokenizer(ln);
			st.nextToken();int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			char[][] arr=new char[N][],sol=new char[N-1][M-1];
			for(int i=0;i<N;i++)arr[i]=in.readLine().trim().toCharArray();
			in.readLine();
			for(int i=1;i<N;i++)
				for(int j=1;j<M;j++)
					sol[i-1][j-1]=(char)(((arr[i-1][j]-'0')+(arr[i][j-1]-'0')+(arr[i-1][j-1]-'0')+(arr[i][j]-'0'))/4+'0');
			for(int i=0;i<N-1;i++)sb.append(new String(sol[i])+"\n");
		}
		System.out.print(new String(sb));
	}
}
