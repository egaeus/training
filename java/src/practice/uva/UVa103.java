package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 103
 * @problemName Stacking Boxes
 * @judge http://uva.onlinejudge.org/
 * @category DP, Graph
 * @level Medium
 * @date 17/06/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa103 {
	static int[][] matriz;
	static Point[] res;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(String ln;(ln = in.readLine()) != null;){
			StringTokenizer st = new StringTokenizer(ln.trim());
			int cajas = parseInt(st.nextToken()), dimensiones = parseInt(st.nextToken());
			matriz = new int[cajas][dimensiones];
			for (int i = 0; i < matriz.length; i++){
				st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < matriz[i].length; j++)matriz[i][j] = parseInt(st.nextToken());
				Arrays.sort(matriz[i]);				
			}
			Comparator<int[]> comp = new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					for (int i = 0; i < o1.length; i++) {
						if(o1[i]>=o2[i])return 1;
					}	
					return -1;
				}
			};
			boolean mAdy[][] = new boolean[cajas][cajas];
			ArrayList<Integer> lAdy[] = new ArrayList[cajas];
			res = new Point[cajas];
			for (int i = 0; i < mAdy.length; i++) {
				lAdy[i] = new ArrayList<Integer>();
				res[i] = new Point(0, -1);
				for (int j = 0; j < mAdy.length; j++){
					if(comp.compare(matriz[i], matriz[j])==-1){
						mAdy[i][j]=true;
						lAdy[i].add(j);
					}
				}
			}
			for (int i = 0; i < lAdy.length; i++)function(i, mAdy, lAdy);
			int max = res[0].x, pos = 0;
			for (int i = 0; i < lAdy.length; i++) if(res[i].x>max){max=res[i].x;pos=i;}
			LinkedList<Integer> arr = new LinkedList<Integer>();
			while(pos>-1){
				arr.addFirst(pos + 1);
				pos=res[pos].y;
			}
			sb.append((max + 1) + "\n" + Arrays.toString(arr.toArray()).replaceAll("[\\[\\],]", "") + "\n");			
		}
		System.out.print(new String(sb));
	}
	static void function(int desde, boolean [][]mAdy, ArrayList<Integer> lAdy[]){
		for (int i = 0; i < lAdy[desde].size(); i++) {
			if(res[desde].x + 1 > res[lAdy[desde].get(i)].x){
				res[lAdy[desde].get(i)].x = res[desde].x + 1;
				res[lAdy[desde].get(i)].y = desde;
			}
			function(lAdy[desde].get(i), mAdy, lAdy);
		}	
	}
}
