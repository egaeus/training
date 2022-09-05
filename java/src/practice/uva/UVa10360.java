package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10360
 * @problemName Rat Attack
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 21/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10360 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println(in.readLine().replaceAll("${user.name}", "Diego"));
		for (int T = 0, C = parseInt(in.readLine().trim()); T < C; T++) {
			int D = parseInt(in.readLine().trim());
			int N = parseInt(in.readLine().trim());
			long[][] mat = new long[1025][1025];
			int maxX = 0, maxY = 0;
			StringTokenizer st;
			for (int i = 0; i < N; i++){
				st = new StringTokenizer(in.readLine().trim());
				int x = parseInt(st.nextToken()), y = parseInt(st.nextToken()), s = parseInt(st.nextToken());
				mat[y][x] = s;
				maxX = Math.max(maxX, x+1);
				maxY = Math.max(maxY, y+1);
			}
			for (int j = 1; j < maxX; j++) mat[0][j] += mat[0][j-1];
			for (int i = 1; i < maxY; i++) mat[i][0] += mat[i-1][0];
			for (int i = 1; i < maxY; i++)
				for (int j = 1; j < maxX; j++)
					mat[i][j] += mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
			long res = 0, valX = 0, valY = 0;
			for (int j = 0; j < maxX; j++)
				for (int i = 0; i < maxY; i++) { 
					int valIzq = Math.max(0, j-D), valArr = Math.max(0, i-D),
					valDer = Math.min(maxX-1, j+D), valAbj = Math.min(maxY-1, i+D);
					long areaRect = mat[valAbj][valDer];
					if(valArr>0)areaRect -= mat[valArr-1][valDer];
					if(valIzq>0)areaRect -= mat[valAbj][valIzq-1];
					if(valIzq>0&&valArr>0) areaRect += mat[valArr-1][valIzq-1];
					if(areaRect > res){
						res = areaRect;
						valX = j;
						valY = i;
					}
				}
			System.out.println(valX + " " + valY + " " + res);
		}
	}
}
