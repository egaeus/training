package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId ACTIV
 * @problemName Activities
 * @judge http://www.spoj.pl
 * @category Memoization
 * @level medium
 * @date 21/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class SPOJACTIV {
	static int sgn(double x) {return x!=0?(x<0?-1:1):0;}
	public static void main(String[] args) throws Throwable {
		StringBuffer sb = new StringBuffer();
		Comparator<int[]> comparador = new Comparator<int[]>() {
			public int compare(int[] a, int[] b){	
				return -sgn(sgn(a[0]-b[0])!=0?a[0]-b[0]:a[1]-b[1]);
			}
		};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim())) != -1; ) {
			int[][] sgms = new int[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				sgms[i][0] = parseInt(st.nextToken());
				sgms[i][1] = parseInt(st.nextToken());
			}
			Arrays.sort(sgms, comparador);
			long res = 0;
			long mem[] = new long[sgms.length];
			int i = 0;
			for(int[] seg: sgms){
				int bs = Arrays.binarySearch(sgms, new int[]{seg[1], seg[1]}, comparador);
				if(bs < 0)bs = -bs - 1;
				res+=((bs > 0?mem[bs-1]:0)+1)%1000000000;
				mem[i] = res;
				i++;
			}
			res %= 100000000;
			for (int j = (res + "").length(); j < 8; j++) 
				sb.append("0");
			sb.append(res + "\n");
		}
		System.out.print(new String(sb));
	}
}
