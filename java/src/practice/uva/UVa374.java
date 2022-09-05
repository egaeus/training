package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 374
 * @problemName Big Mod
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa374 {
	public static long modulacion(long b, long p, long m){
		if(p==0)return 1;
		if(p%2==0){
			long x = modulacion(b, p/2, m);
			return x*x % m;
		}
		if(p%2!=0){
			long x = modulacion(b, p/2, m);
			return b*x*x%m;
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			long b = Long.parseLong(in.readLine().trim()), p = Long.parseLong(in.readLine().trim()), m = Long.parseLong(in.readLine().trim());
			System.out.println(modulacion(b,p,m));
			String h = in.readLine();
			if(h==null)break;
		}
	}
}
