package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId MIRRORED
 * @problemName Mirrored Pairs
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJMIRRORED {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ready");
		for(String ln;!(ln = in.readLine()).equals("  ");)
			System.out.println((ln.replaceFirst("pq|qp|db|bd", "").equals("")?"Mirrored":"Ordinary") + " pair");
	}
}
