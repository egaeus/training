package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 196
 * @problemName Spreadsheet 
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 03/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa196 {
	public static int function(int posI, int posJ){
		if(!pts.containsKey(new Point(posI, posJ)))return mat[posI][posJ];
		String str = pts.remove(new Point(posI, posJ));
		StringTokenizer st = new StringTokenizer(str.substring(1), "+");
		int sol = 0;
		for (;st.hasMoreTokens();) {
			char[] l = st.nextToken().toCharArray();
			String temp = "", temp1 = "";
			for(char a: l)
				if(Character.isLetter(a))temp += a;
				else temp1 += a;
			int n = 0;
			for(int i = temp.length() - 1, j = 1; i >= 0; i--, j*=26)
				n += j*(temp.charAt(i)-'A'+1);
			sol+=function(parseInt(temp1) - 1, n - 1);
		}
		return mat[posI][posJ] = sol;
	}
	static TreeMap<Point, String> pts;
	static int mat[][];
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c = 0, T = parseInt(in.readLine().trim()); c < T; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int C = parseInt(st.nextToken()), R = parseInt(st.nextToken());
			mat = new int[R][C];
			pts = new TreeMap<Point, String>(new Comparator<Point>() {
				public int compare(Point o1, Point o2) {
					if(o1.x < o2.x)return -1;
					if(o1.x > o2.x)return 1;
					if(o1.y < o2.y)return -1;
					if(o1.y > o2.y)return 1;
					return 0;
				}
			}); 
			for (int i = 0; i < mat.length; i++) {
				st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < mat[0].length; j++){
					String str = st.nextToken();
					if(str.charAt(0)=='=')pts.put(new Point(i,j), str);
					else mat[i][j] = parseInt(str); 
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) 
					System.out.print(function(i,j) + (j < C - 1?" ":""));
				System.out.println();
			}
		}
	}
}
