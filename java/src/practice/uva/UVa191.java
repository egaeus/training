package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 191
 * @problemName Intersection
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 26/03/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa191 {
	static boolean intersecta(int ln[][],int[][] rect){
		return Line2D.linesIntersect(ln[0][0],ln[0][1],ln[1][0],ln[1][1],rect[0][0],rect[0][1],rect[1][0],rect[0][1])||
				Line2D.linesIntersect(ln[0][0],ln[0][1],ln[1][0],ln[1][1],rect[0][0],rect[0][1],rect[0][0],rect[1][1])||
				Line2D.linesIntersect(ln[0][0],ln[0][1],ln[1][0],ln[1][1],rect[1][0],rect[1][1],rect[1][0],rect[0][1])||
				Line2D.linesIntersect(ln[0][0],ln[0][1],ln[1][0],ln[1][1],rect[1][0],rect[1][1],rect[0][0],rect[1][1])||
				(min(rect[0][0],rect[1][0])<=ln[0][0]&&max(rect[0][0],rect[1][0])>=ln[0][0]&&min(rect[0][1],rect[1][1])<=ln[0][1]&&max(rect[0][1],rect[1][1])>=ln[0][1])||
				(min(rect[0][0],rect[1][0])<=ln[1][0]&&max(rect[0][0],rect[1][0])>=ln[1][0]&&min(rect[0][1],rect[1][1])<=ln[1][1]&&max(rect[0][1],rect[1][1])>=ln[1][1]);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int c=0,C=parseInt(in.readLine().trim());c++<C;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int[][] line=new int[][]{{parseInt(st.nextToken()),parseInt(st.nextToken())},{parseInt(st.nextToken()),parseInt(st.nextToken())}},
					rect=new int[][]{{parseInt(st.nextToken()),parseInt(st.nextToken())},{parseInt(st.nextToken()),parseInt(st.nextToken())}};
			sb.append(intersecta(line,rect)?"T\n":"F\n");
		}
		System.out.print(new String(sb));
	}
}
