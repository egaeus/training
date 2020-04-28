package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 458
 * @problemName The Decoder 
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa458 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int cont = 0;
		while (true) {
			String x = in.readLine();
			if(x==null)break;
			if(cont++>0)sb.append("\n");
			if(x.equals(""))continue;
			char[] arr = new char[x.length()];
			for (int i = 0; i < x.length(); i++)arr[i]=(char)(x.charAt(i)-7);
			sb.append(arr);
		}
		System.out.print(new String(sb));
	}
}
