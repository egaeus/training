package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 579
 * @problemName ClockHands 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa579 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s[] = in.readLine().trim().split(":");
			int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
			if (m==0 && n == 0)break;
			System.out.printf(Locale.US ,"%.3f\n", Math.abs(((m%12)*5.+(n*5.)/60.-n)*6)>180?360-Math.abs(((m%12)*5.+(n*5.)/60.-n)*6):Math.abs(((m%12)*5.+(n*5.)/60.-n)*6));
		}		
	}	
}
