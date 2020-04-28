package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ANARC09E
 * @problemName Probability One
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/03/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJANARC09E {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N, caso = 1; (N=Integer.parseInt(in.readLine().trim()))!=0; caso++)
			System.out.println(caso+". "+(N%2==0?"even ":"odd ")+(N/2));
	}
}
