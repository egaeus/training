package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 100
 * @problemName 3n+1
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
class UVa100 {
	public static int[] arreglo = new int[1000001];
	public static int func(long n) {
		if (n == 1) return 1;
		if (n < 1000000) 
			if (arreglo[(int) (n)] > 0)return arreglo[(int) (n)];
			else return arreglo[(int) (n)] = func(n % 2 == 0 ? n / 2 : 3 * n + 1) + 1;
		else return func(n % 2 == 0 ? n / 2 : 3 * n + 1) + 1;
	}
	public static void main(String[] args) throws Throwable {
		String[] arr = new String[2];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String temp = in.readLine();
			if (temp == null || temp.equals(""))
				break;
			arr = temp.trim().split(" +");	
			int max = 0;
			for (int i = Math.min(Integer.parseInt(arr[0]), Integer
					.parseInt(arr[1])) ; i <= Math.max(Integer.parseInt(arr[0]), Integer
							.parseInt(arr[1])); i++) {
				int r = func(i);
				if (max < r)
					max = r;
				
			}
			System.out.println(arr[0] + " " + arr[1] + " " + max);
		}
	}
}
