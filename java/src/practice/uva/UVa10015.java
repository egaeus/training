package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10015
 * @problemName Joseph's Cousin
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 20/12/2010
 **/
import java.util.ArrayList;
import java.util.Scanner;
public class UVa10015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean primos[] = new boolean[10000000];
		primos[0] = primos[1] = true;
		for (int i = 0; i < primos.length; i++) 
			if(!primos[i])
				for (int j = i+i; j < primos.length; j+=i)
					primos[j] = true;
		for(int N; (N = sc.nextInt()) != 0; ){
			ArrayList<Integer> mans = new ArrayList<Integer>(N);
			for (int i = 0; i < N; i++) mans.add(i+1);
			for(int i = 0, j = 0; mans.size() > 1; i++)
				if(!primos[i])mans.remove(j=(j+i-1)%mans.size());
			System.out.println(mans.get(0));
		}
	}
}
