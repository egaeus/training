package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 369
 * @problemName Combinations
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVa369 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String n[] = in.readLine().trim().split(" +");
			if (n[0].equals("0") && n[1].equals("0"))
				break;
			System.out.println(Integer.parseInt(n[0])
					+ " things taken "
					+ Integer.parseInt(n[1])
					+ " at a time is "
					+ combinatoria(Math.max(Integer.parseInt(n[0]), Integer
							.parseInt(n[1])), Math.min(Integer.parseInt(n[0]),
							Integer.parseInt(n[1]))) + " exactly.");
		}
	}
	public static long combinatoria(int n, int m) {
		TreeMap<Integer, Integer> arriba = new TreeMap<Integer, Integer>();
		for (int i = n; i > Math.max(n - m, m) && i > 1; i--)
			arriba.put(i, 1);
		TreeMap<Integer, Integer> abajo = new TreeMap<Integer, Integer>();
		for (int i = Math.min(n - m, m); i > 1; i--)
			abajo.put(i, 1);
		multiplicatoria(arriba);
		multiplicatoria(abajo);
		long res = 1;
		for (Entry entry : arriba.entrySet()) {
			int val = 0;
			if (abajo.containsKey(entry.getKey())) {
				val = abajo.get(entry.getKey());
				abajo.remove(entry.getKey());
			}
			res *= (Math.pow((Integer) entry.getKey(), (Integer) entry.getValue() - val));
		}
		for (Entry entry : abajo.entrySet()) {
			res /= (Math.pow((Integer) entry.getKey(), (Integer) entry
					.getValue()));
		}
		return res;
	}
	static boolean arr[] = { false, false, false, false, true, false, true,
			false, true, true, true, false, true, false, true, true, true,
			false, true, false, true, true, true, false, true, true, true,
			true, true, false, true, false, true, true, true, true, true,
			false, true, true, true, false, true, false, true, true, true,
			false, true, true, true, true, true, false, true, true, true, true,
			true, false, true, false, true, true, true, true, true, false,
			true, true, true, false, true, false, true, true, true, true, true,
			false, true, true, true, false, true, true, true, true, true,
			false, true, true, true, true, true, true, true, false, true, true,
			true, false, true, false, true, true, true, false, true, false,
			true, true, true, false, true, true, true, true, true, true, true,
			true, true, true, true, true, true, false, true, true, true, false,
			true, true, true, true, true, false, true, false, true, true, true,
			true, true, true, true, true, true, false, true, false, true, true,
			true, true, true, false, true, true, true, true, true, false, true,
			true, true, false, true, true, true, true, true, false, true, true,
			true, true, true, false, true, false, true, true, true, true, true,
			true, true, true, true, false, true, false, true, true, true,
			false, true, false, true, true, true, true, true, true, true, true,
			true, true, true, false, true, true, true, true, true, true, true,
			true, true, true, true, false, true, true, true, false, true,
			false, true, true, true, false, true, true, true, true, true,
			false, true, false, true, true, true, true, true, true, true, true,
			true, false, true, true, true, true, true, false, true, true, true,
			true, true, false, true, true, true, true, true, false, true,
			false, true, true, true, true, true, false, true, true, true,
			false, true, false, true, true, true, true, true, true, true, true,
			true, false, true, true, true, true, true, true, true, true, true,
			true, true, true, true, false, true, true, true, false, true,
			false, true, true, true, false, true, true, true, true, true, true,
			true, true, true, true, true, true, true, false, true, true, true,
			true, true, false, true, true, true, true, true, true, true, true,
			true, false, true, false, true, true, true, false, true, true,
			true, true, true, false, true, true, true, true, true, true, true,
			false, true, true, true, true, true, false, true, true, true, true,
			true, false, true, true, true, false, true, true, true, true, true,
			false, true, true, true, true, true, true, true, false, true, true,
			true, false, true, true, true, true, true, true, true, false, true,
			true, true, true, true, true, true, true, true, false, true, false,
			true, true, true, true, true, true, true, true, true, false, true,
			false, true, true, true, true, true, false, true, true, true,
			false, true, true, true, true, true, false, true, true, true, true,
			true, true, true, false, true, true, true, false, true, false,
			true, true, true, false, true, true, true, true, true, true, true,
			true, true, true, true, false, true, true, true, true, true, true,
			true, false, true, true, true, false, true, true, true, true, true,
			true, true, false, true };
	static int primos[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
			47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
			113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
			191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257,
			263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337,
			347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419,
			421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491,
			499 };
	public static void multiplicatoria(TreeMap<Integer, Integer> raiz) {
		TreeMap<Integer, Integer> casa = (TreeMap<Integer,Integer>)raiz.clone(); 
		for (Entry<Integer, Integer> entry : casa.entrySet()) {
			if (entry.getKey() < 500 && !arr[entry.getKey()])
				continue;
			int i = 0;
			for (i = 0; i < primos.length; i++) {
				if (entry.getKey() % primos[i] == 0) {
					if (entry.getValue() == 1)
						raiz.remove(entry.getKey());
					else
						raiz.put(entry.getKey(), entry.getValue() - 1);
					int val = 0;
					if (raiz.containsKey(entry.getKey() / primos[i]))
						val = raiz.get(entry.getKey() / primos[i]);
					raiz.put(entry.getKey() / primos[i], val + 1);
					val = 0;
					if (raiz.containsKey(primos[i]))
						val = raiz.get(primos[i]);
					raiz.put(primos[i], val + 1);
					multiplicatoria(raiz);
					break;
				}
			}
			if(i<primos.length)break;
		}
	}
}
