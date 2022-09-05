package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId BITMAP
 * @problemName Bitmap
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJBITMAP {
	static int[][] function(char[][] mat){
		int N, M;
		int[][] res = new int[N=mat.length][M=mat[0].length];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(mat[i][j]=='0')res[i][j]=MAX_VALUE;
		for(int c = 0; ; c++){
			boolean ws = false;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(res[i][j]==c){
						ws = true;
						int[][] cambios = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
						for(int[] s: cambios)
							if(i+s[0]>=0&&i+s[0]<res.length&&j+s[1]>=0&&j+s[1]<res[0].length&&res[i+s[0]][j+s[1]]>res[i][j]+1)
								res[i+s[0]][j+s[1]]=res[i][j]+1;
					}
			if(!ws)break;
		}
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			if(c > 0)in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			char[][] mat = new char[N][];
			for(int i = 0; i < N; i++)mat[i]=in.readLine().trim().toCharArray();
			int[][] res = function(mat);
			for(int[] sol: res)System.out.println(Arrays.toString(sol).replaceAll("[\\[\\],]", ""));
		}
	}
}
