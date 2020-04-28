package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10107
 * @probleName What is the Median?
 * @judge http://uva.onlinejudge.org/
 * @category sort
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class UVa10107 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> res = new ArrayList<Integer>(10000);
		int paso = 0;
		StringBuffer sb = new StringBuffer();
		while(true){
			String s = in.readLine();
			if(s==null||s.equals(""))break;
			res.add(Integer.parseInt(s.trim()));
			Arrays.sort(res.toArray());
			if(paso%2==0)sb.append(res.get(paso/2) + "\n");
			else sb.append((res.get(paso/2) + res.get(paso/2+1))/2 + "\n");
			paso++;
		}
		System.out.print(sb);
	}
}
