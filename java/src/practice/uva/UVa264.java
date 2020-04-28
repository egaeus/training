package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 264
 * @problemName Count on Cantor
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa264 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = in.readLine();
			if(s==null)break;
			int r = Integer.parseInt(s.trim());
			int n = (int)Math.ceil((Math.sqrt(1+8*r)-1)/2.);
			System.out.println("TERM " + r + " IS " + (n%2!=0?(((n*(n+1))/2)-r)+1:(n-(((n*(n+1))/2-r)))) + "/" + (n%2!=0?(n-(((n*(n+1))/2-r))):(((n*(n+1))/2)-r)+1));
		}
	}
}
