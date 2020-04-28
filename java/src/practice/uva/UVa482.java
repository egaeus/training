package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 482
 * @problemName Permutation Arrays
 * @judge http://uva.onlinejudge.org/
 * @category Simulation
 * @level easy
 * @date 26/07/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa482 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, C = Integer.parseInt(in.readLine().trim()); i < C; i++) {
			in.readLine();
			String[] arr = in.readLine().trim().split(" +"), arr1 = in.readLine().trim().split(" +"), sol = new String[arr1.length];
			for (int j = 0; j < sol.length; j++)sol[Integer.parseInt(arr[j]) - 1] = arr1[j];
			for (int j = 0; j < sol.length; j++) System.out.println(sol[j]);
			if(i<C-1)System.out.println();
		}
	}
}
