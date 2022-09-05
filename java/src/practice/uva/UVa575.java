package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 575
 * @problemName Skew Binary 
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa575 {
	public static void main(String[] args) throws Throwable {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		while(true){
			String n = in.readLine().trim();
			if (n.equals("0"))break;
			int sum = 0;
			for (int i = n.length()-1; i >= 0; i--)sum += (int)(n.charAt(i)-'0')*((Math.pow(2, n.length()-i))-1);
			System.out.println(sum);
		}		
	}	
}
