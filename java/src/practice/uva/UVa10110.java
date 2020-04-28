package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10110
 * @probleName Light, more light
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10110 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			long n = Long.parseLong(in.readLine().trim());
			if(n==0)break;
			System.out.println(Math.sqrt(n)==Math.ceil(Math.sqrt(n))?"yes":"no");
		}
	}	
}