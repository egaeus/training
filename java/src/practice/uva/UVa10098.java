package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10098
 * @problemName Generating Fast
 * @judge http://uva.onlinejudge.org/
 * @category permutations
 * @level easy
 * @date 22/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10098 {
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
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			char[] str=in.readLine().trim().toCharArray();
			Arrays.sort(str);
			for(;str!=null;str=next_permutation(str)){
				sb.append(new String(str)+"\n");
				if(sb.length()>30000000){System.out.print(new String(sb));sb=new StringBuilder();}
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
