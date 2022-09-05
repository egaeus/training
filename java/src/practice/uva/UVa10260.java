package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10260
 * @problemName Soundex
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 15/12/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10260 {
	public static void main(String args[]) throws Throwable {
		int[] arr=new int[]{0,1,2,3,0,1,2,0,0,2,2,4,5,5,0,1,2,6,2,3,0,1,0,2,0,2};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			char[] str=ln.trim().toCharArray();int ult=0;
			for(int i=0;i<str.length;i++){
				if(arr[str[i]-'A']>0&&ult!=arr[str[i]-'A'])
					sb.append(arr[str[i]-'A']);
				ult=arr[str[i]-'A'];
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
