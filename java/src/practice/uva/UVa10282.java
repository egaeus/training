package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10282
 * @problemName Babelfish
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/01/2012
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class UVa10282 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,String> dic=new HashMap<String, String>();
		StringBuilder sb=new StringBuilder();
		for (String ln,a;!(ln=in.readLine().trim()).equals("");) {
			StringTokenizer st=new StringTokenizer(ln);a=st.nextToken();
			dic.put(st.nextToken(),a);
		}
		for(String ln,c;(ln=in.readLine())!=null;){
			c=dic.get(ln.trim());
			if(c==null)c="eh";
			sb.append(c+"\n");
		}
		System.out.print(new String(sb));
	}
}
