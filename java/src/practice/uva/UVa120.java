package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 120
 * @problemName Stacks of Flapjacks
 * @judge http://uva.onlinejudge.org/
 * @category -
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa120 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String linea = in.readLine();
			if (linea == null)
				break;
			String[] algo = linea.trim().split(" +");
			int[] arr = new int[algo.length], arr1 = new int[algo.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(algo[i]);
				arr1[i] = Integer.parseInt(algo[i]);
			}
			Arrays.sort(arr1);
			String res = "";
			for (int i = arr1.length - 1; i >= 0; i--) {
				if (arr[i] != arr1[i])
					for (int j = i; j >= 0; j--) {
						if (arr[j] == arr1[i] && j != i) {
							res += (j == 0 ? arr.length - i : arr.length - j)
									+ " ";
							int temp = (j == 0 ? i : j);
							for (int k = 0; k < (temp % 2 != 0 ? temp / 2 + 1
									: temp / 2); k++) {
								int temporal = arr[k];
								arr[k] = arr[temp - k];
								arr[temp - k] = temporal;
							}
							if (arr1[i] == arr[i])
								j = -1;
							else {
								res += Math.min(Integer.MAX_VALUE, arr.length
										- i)
										+ " ";
								for (int k = 0; k < (i % 2 != 0 ? i / 2 + 1
										: i / 2); k++) {
									int temporal = arr[k];
									arr[k] = arr[i - k];
									arr[i - k] = temporal;
								}
								j = -1;
							}
						}
					}
			}
			res += "0";
			for (int i = 0; i < algo.length; i++)
				System.out.print(algo[i] + (i < algo.length - 1 ? " " : ""));
			System.out.println();
			System.out.println(res.trim());
		}
	}
}
