package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 256
 * @problemName Quirksome Squares
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa256 {
	/*public static String llenarCeros(String st, int cant) {
		int n = st.length();
		for (int i = 0; i < cant - n; i++)
			st = "0" + st;
		return st;
	}*/
	public static void main(String[] args) throws Throwable{
		/*for (int j = 2; j < 10; j += 2){
			for (int i = 0; i < Math.pow(10, j); i++) {
				String st = llenarCeros(i + "", j);
				int izq = parseInt(st.substring(0, st.length() / 2)), der = parseInt(st
						.substring(st.length() / 2));
				if ((izq + der)*(izq + der) == i)
					System.out.print(st + ", ");
			}
			System.out.println();
		}*/
		String mat[][] = new String[][]{{"00", "01", "81"},{"0000", "0001", "2025", "3025", "9801"},{"000000", "000001", "088209", "494209", "998001"},{"00000000", "00000001", "04941729", "07441984", "24502500", "25502500", "52881984", "60481729", "99980001"}};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(String ln; (ln = in.readLine()) != null; ){
			int n = parseInt(ln.trim());
			for (int i = 0; i < mat[n/2 - 1].length; i++)
				sb.append(mat[n/2 - 1][i] + "\n");
		}
		System.out.print(new String(sb));
	}
}
