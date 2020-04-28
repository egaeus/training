package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10018
 * @problemName Reverse and Add
 * @judge http://uva.onlinejudge.org/
 * @category math, characters
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10018 {
	static int cont = 0;
	public static long res[][] = new long[1000000][2];
	public static boolean esPalindroma(String x) {
		for (int i = 0; i < x.length() / 2; i++)
			if (x.charAt(i) != x.charAt(x.length() - 1 - i))
				return false;
		return true;
	}
	public static long voltear(String x) {
		String res = "";
		for (int i = x.length() - 1; i >= 0; i--)
			res += x.charAt(i);
		return Long.parseLong(res);
	}
	public static long f(long i) {
		if (i < 1000000)
			if (res[(int) i][0] > 0) {
				cont += res[(int) i][1];
				return res[(int) i][0];
			}
		String x = "" + i;
		if (esPalindroma(x)) {
			if (i < 1000000)
				res[(int) i][1] = cont;
			return i < 1000000 ? res[(int) i][0] = i : i;
		}
		cont++;
		int temp = cont;
		long foo = f(voltear(x) + i);
		if (i < 1000000)
			res[(int) i][1] = cont - temp + 1;
		return i < 1000000 ? res[(int) i][0] = foo : foo;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; i++) {
			cont = 0;
			long x = Long.parseLong(in.readLine().trim());
			long casa = f(x);
			System.out.println(cont + " " + casa);
		}
	}
}