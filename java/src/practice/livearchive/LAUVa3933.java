package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3933
 * @problemName Galou is Back!
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/10/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3933 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			char[][] mat=new char[N][];
			for(int i=0;i<N;i++)mat[i]=in.readLine().trim().toCharArray();
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)if(mat[i][j]=='I')mat[i][j]='(';
			boolean ws=true;
			int[] vecinos[]=new int[][]{{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0}};
			for(;ws;){
				ws=false;
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++)
						if(mat[i][j]!='.')
							for(int[] v:vecinos){
								if(i+v[0]>=0&&i+v[0]<N&&j+v[1]>=0&&j+v[1]<M&&mat[i+v[0]][j+v[1]]!='.'){
									if(mat[i][j]=='('){
										if(mat[i+v[0]][j+v[1]]=='('){mat[i][j]=mat[i+v[0]][j+v[1]]='B';ws=true;}
										else if(mat[i+v[0]][j+v[1]]=='*'){mat[i+v[0]][j+v[1]]=')';ws=true;}
										else if(mat[i+v[0]][j+v[1]]=='B'){mat[i][j]='B';ws=true;}
									}
									else if(mat[i][j]==')'){
										if(mat[i+v[0]][j+v[1]]=='*'){mat[i+v[0]][j+v[1]]='(';ws=true;}
										else if(mat[i+v[0]][j+v[1]]==')'){mat[i][j]=mat[i+v[0]][j+v[1]]='B';ws=true;}
										else if(mat[i+v[0]][j+v[1]]=='B'){mat[i][j]='B';ws=true;}
									}
									else if(mat[i][j]=='B')
										{if(mat[i+v[0]][j+v[1]]!='B'){mat[i+v[0]][j+v[1]]='B';ws=true;}}
								}
							}
			}
			sb.append("\n");
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)if(mat[i][j]=='*')mat[i][j]='F';
			for(char[] a:mat)sb.append(new String(a)+"\n");
		}
		System.out.print(new String(sb));
	}
}
