package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 440
 * @problemName Eeny Meeny Moo
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 21/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa440 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim())) != 0; ) {
			for(int M = 2; ; M++){
				ArrayList<Integer> arr = new ArrayList<Integer>(N);
				for (int i = 1; i <= N; i++) arr.add(i);
				for (int i = 0; ; ){
					if(arr.get(i)==2)break;
					arr.remove(i);
					i=(i+M-1)%arr.size();
				}
				if(arr.size() == 1){
					System.out.println(M);
					break;
				}
			}
		}
	}
}
