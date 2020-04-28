package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10252
 * @problemName Common Permutation
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 14/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10252 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String str1; (str1 = in.readLine())!=null;){
			char[] a = str1.toCharArray(), b = in.readLine().toCharArray();
			int[] arrA = new int[256];
			int[] arrB = new int[256];
			for (int i = 0; i < a.length; i++) 
				arrA[a[i]]++;
			for (int i = 0; i < b.length; i++) 
				arrB[b[i]]++;
			String res = "";
			for (int i = 0; i < arrA.length; i++) 
				if(arrA[i] > 0 && arrB[i]>0)
					for (int j = 0; j < Math.min(arrA[i], arrB[i]); j++) 
						res += (char)i;
			char[] sol = res.toCharArray();
			Arrays.sort(sol);
			System.out.println(new String(sol));
		}
	}
}
