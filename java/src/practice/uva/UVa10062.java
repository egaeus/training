package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10062
 * @problemName Tell me the frequencies!
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10062 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 0;
		for (String ln; (ln = in.readLine()) != null; ) {
			if(caso++>0)System.out.println();
			int[] arr = new int[256];
			Arrays.fill(arr, Integer.MAX_VALUE);
			char[] st = ln.toCharArray();
			for (int i = 0; i < st.length; i++) 
				arr[st[i]] = arr[st[i]]==Integer.MAX_VALUE?1:arr[st[i]]+1;
			int[] mm = arr.clone();
			Arrays.sort(mm);
			for (int i = 0; i < mm.length && mm[i] < Integer.MAX_VALUE; i++)
				for (int j = arr.length - 1; j >= 0 ; j--) 
					if(arr[j] == mm[i]){
						System.out.println(j + " " + mm[i]);
						arr[j] = Integer.MAX_VALUE;
						break;
					}
		}		
	}
}
