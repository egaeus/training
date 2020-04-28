package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10192
 * @probleName Vacation 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10192 {
	static int funcion(int pos1, int pos2, char[] arr1, char[] arr2, int[][] mat){
		if(pos1==arr1.length)return 0;
		if(pos2==arr2.length)return 0;
		if(mat[pos1][pos2]>-1)return mat[pos1][pos2];
		int i = pos2;
		for (; i < arr2.length; i++) 
			if(arr1[pos1]==arr2[i])return mat[pos1][pos2] = Math.max(funcion(pos1 + 1, pos2, arr1, arr2, mat), funcion(pos1 + 1, i + 1, arr1, arr2, mat) + 1);
		return mat[pos1][pos2] = funcion(pos1 + 1, pos2, arr1, arr2, mat);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		for(String ln; (ln = in.readLine())!=null; ){
			if(ln.length() > 0 && ln.charAt(0) == '#')break;
			char[] arr1 = ln.toCharArray(), arr2 = in.readLine().toCharArray();
			int[][] mat = new int[arr1.length][arr2.length];
			for (int i = 0; i < mat.length; i++)Arrays.fill(mat[i], -1); 
			System.out.println("Case #" + (caso++) + ": you can visit at most " + funcion(0, 0, arr1, arr2, mat) + " cities.");
		}
	}
}
