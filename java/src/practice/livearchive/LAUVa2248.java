package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2248
 * @problemName Desert Bitmap
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 18/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2248 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			char[][] masq=new char[N][];
			for(int i=0;i<N;i++)masq[i]=in.readLine().trim().toCharArray();
			st=new StringTokenizer(in.readLine());
			int N1=parseInt(st.nextToken()),M1=parseInt(st.nextToken());
			char[][] mat=new char[N1][];
			for(int i=0;i<N1;i++)mat[i]=in.readLine().trim().toCharArray();
			int res=0;
			for(int i=0;i<N1-N+1;i++)
				for(int j=0;j<M1-M+1;j++){
					boolean ws=true;
					for(int h=0;h<N&&ws;h++)
						for(int k=0;k<M&&ws;k++)
							ws=masq[h][k]=='.'||masq[h][k]==mat[i+h][j+k];
					if(ws)res++;
				}
			System.out.println(res);
		}
	}
}
