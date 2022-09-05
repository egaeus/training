package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 232
 * @problemName Crossword Answers
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 03/01/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa232 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tab = 1;
		for(String ln; (ln = in.readLine()) != null; tab++){
			StringTokenizer st = new StringTokenizer(ln.trim());
			int R = parseInt(st.nextToken());
			if(R==0)break;
			if(tab!=1)sb.append("\n");
			int C = parseInt(st.nextToken());
			int[][] nums = new int[R][C];
			char[][] mat = new char[R][];
			for (int i = 0; i < R; i++) 
				mat[i] = in.readLine().trim().toCharArray();
			for (int i = 0, cont = 0; i < mat.length; i++) 
				for (int j = 0; j < mat[i].length; j++) 
					if(mat[i][j]!='*' && (j == 0 || mat[i][j-1]=='*' || i == 0 || mat[i-1][j]=='*'))nums[i][j]=++cont;
			sb.append("puzzle #" + tab + ":\n");
			sb.append("Across\n");
			for (int i = 0; i < mat.length; i++) 
				for (int j = 0; j < mat[i].length; j++) 
					if(mat[i][j]!='*' && (j==0 || mat[i][j-1]=='*')){
						sb.append(" " + (nums[i][j] < 10?" ":"") + nums[i][j] + ".");
						for (int h = j; h < mat[i].length; h++) 
							if(mat[i][h]!='*')sb.append(mat[i][h]);
							else break;
						sb.append("\n");
					}
			sb.append("Down\n");
			for (int i = 0; i < mat.length; i++) 
				for (int j = 0; j < mat[i].length; j++) 
					if(mat[i][j]!='*' && (i==0 || mat[i-1][j]=='*')){
						sb.append(" " + (nums[i][j] < 10?" ":"")+ nums[i][j] + ".");
						for (int h = i; h < mat.length; h++) 
							if(mat[h][j]!='*')sb.append(mat[h][j]);
							else break;
						sb.append("\n");
					}
		}
		System.out.print(new String(sb));
	}
}
