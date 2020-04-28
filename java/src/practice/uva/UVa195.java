package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 195
 * @problemName Anagrams
 * @judge http://uva.onlinejudge.org/
 * @category permutations
 * @level medium
 * @date 10/02/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
public class UVa195 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Comparator<Character> comp = new Comparator<Character>() {
			public int compare(Character o1, Character o2) {
				return ((Character)Character.toLowerCase(o1)).compareTo((Character)Character.toLowerCase(o2))!=0?((Character)Character.toLowerCase(o1)).compareTo((Character)Character.toLowerCase(o2)):(o1.compareTo(o2));
			}
		};
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			char[] arr = in.readLine().toCharArray();
			Character []arr1 = new Character[arr.length];
			for(int i = 0; i < arr.length; i++)arr1[i] = arr[i];
			Arrays.sort(arr1, comp);
			for(Character w: arr1)
				sb.append(w);
			sb.append("\n");
			for(Character[] res = arr1; (res = next_permutation(res, comp, (Character)Character.MAX_VALUE)) != null; ){
				for(Character w: res)
					sb.append(w);
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
	static <T> T[] next_permutation(T[] arr, Comparator<? super T> comp, T max_value){
    	int I = -1; T min = null; boolean ws = false;
    	for (int i = arr.length - 1; i >= 0 && !ws; i--) {
          	min = max_value;
          	for(int j = arr.length - 1; j > i && !ws; j--){
                	min = comp.compare(arr[j], arr[i]) > 0?(comp.compare(arr[j], min) < 0?arr[j]:min):min;
                	if(ws = comp.compare(arr[i], arr[j]) < 0) I = i;
          	}
    	}
    		if(I == -1)return null;
    		T[] res = (T[])Array.newInstance(arr.getClass().getComponentType(), arr.length), temp = (T[])Array.newInstance(arr.getClass().getComponentType(), arr.length - I);
    	for (int j = I; j < arr.length; j++) temp[j - I] = arr[j];
    	Arrays.sort(temp, comp); ws = false;
    	for (int j = 0, i = 0; j < res.length; j++)
          	if(j <= I)res[j] = j < I?arr[j]:min;
          			else if(!ws && temp[i]==min){i++; res[j]=temp[i++]; ws=true;}
          	else res[j] = temp[i++];
    	return res;
	}
}
