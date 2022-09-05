package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 146
 * @problemName ID Codes
 * @judge http://uva.onlinejudge.org/
 * @category permutations
 * @level easy
 * @date 10/02/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa146 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; !(ln = in.readLine().trim()).equals("#"); ){
			char[] arr = ln.toCharArray();
			char[] res = next_permutation(arr);
			System.out.println(res==null?"No Successor":Arrays.toString(res).replaceAll("[\\[\\], ]", ""));
		}
	}
	static char[] next_permutation(char[] arr){
		int I = -1; char min = '\0';
		for (int i = arr.length - 1; i >= 0; i--) {
			boolean ws = false; min = Character.MAX_VALUE;
			for(int j = arr.length - 1; j > i && !ws; j--){
				min = arr[j] > arr[i]?(char)Math.min(arr[j], min):min;
				if(ws = arr[i] < arr[j]) I = i;
			}
			if(ws)break;
		}
		if(I == -1)return null;
		char[] res = new char[arr.length];char[] temp = new char[arr.length - I];
		for (int j = I; j < arr.length; j++) temp[j - I] = arr[j];
		Arrays.sort(temp); boolean ws = false;
		for (int j = 0, i = 0; j < res.length; j++) 
			if(j <= I)res[j] = j < I?arr[j]:min;
			else if(!ws && temp[i]==min){i++; res[j]=temp[i++]; ws=true;}
			else res[j] = temp[i++];
		return res;
	}
}
