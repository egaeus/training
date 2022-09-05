package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 543
 * @problemName Goldbach's Conjecture
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa543 {
	static boolean primos[] = new boolean[1000000];
	public static void main(String[] args) throws IOException {
		for (int i = 2; i < 1000000; i++)
			if (!primos[i])
				for (int j = i + i; j < 1000000; j += i)
					primos[j] = true;		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n = Integer.parseInt(in.readLine().trim());
			if(n==0)break;
			for(int i = 2; i < n; i++)
				if(!primos[i]&&!primos[n-i]){
					System.out.println(n + " = " + i + " + " + (n-i));
					break;
				}		
		}
	}
}
