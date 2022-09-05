package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 160
 * @problemName Factors and Factorials
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVa160 {
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
		TreeMap<Integer, Integer> casa = (TreeMap<Integer, Integer>) raiz
				.clone();
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
			if (i < primos.length)
				break;
		}
	}	
	public static int[] ordenaArbol(TreeMap<Integer, Integer> raiz, int max){
		int[] res = new int[max];
		for (int i = 0; i < res.length; i++) {
			if(raiz.containsKey(primos[i]))res[i]=raiz.get(primos[i]);
			else res[i]=0;
		}
		return res;
	}
	public static void main(String[] args) throws Throwable {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso=0;
		while(true){
			String r = in.readLine().trim();
			int n = Integer.parseInt(r);
			if(n==0)break;
			//if(caso>0)System.out.println();
			TreeMap<Integer, Integer> raiz = new TreeMap<Integer, Integer>();
			for (int i = n; i >1; i--) raiz.put(i, 1);
			multiplicatoria(raiz);
			int k=0;
			int max = 0;			
			for(Entry entry: raiz.entrySet())
				if((Integer)entry.getKey()>max)max=(Integer)entry.getKey();
			for (int i = 0; i < primos.length; i++) {
				if(primos[i]>max){
					max=i;
					break;
				}
			}
			int[] res = ordenaArbol(raiz, max);
			for(int i = r.length(); i < 3; i++)System.out.print(" ");
			System.out.print(r + "! =");
			for (int i = 0; i < res.length; i++) {
				String foo = res[i] + "";
				for(int j = foo.length(); j < 3; j++)System.out.print(" ");
				System.out.print(foo);
				if(i==14 && res.length>15){
					System.out.println();
					System.out.print("      ");
				}
			}
			System.out.println();
			caso++;
		}
	}
}
