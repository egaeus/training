package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 417
 * @problemName Word Index
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 2/01/2012
 **/
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
public class UVa417 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr=new String[83682];
		arr[0]="`";int c=1;
		for(int i=0;i<c;i++)
			if(arr[i].length()<6)
				for(int j=arr[i].charAt(arr[i].length()-1)+1;j<='z';j++)
					arr[c++]=arr[i]+(char)j;
		Comparator<String> comp=new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length()!=o2.length()?o1.length()-o2.length():o1.compareTo(o2);
			}
		};
		for (String ln;(ln=in.readLine())!=null;) {
			int bs=Arrays.binarySearch(arr,"`"+ln.trim(),comp);
			System.out.println(max(0,bs));		
		}
	}
}
