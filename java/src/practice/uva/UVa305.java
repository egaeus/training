package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 305
 * @problemName Joseph
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa305 {
	public static void main(String[] args) throws Throwable{
		/*for (int i = 1; i < 14; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < i * 2; j++) arr.add(j);
			int j = 2;
			for (; ; j++) {
				ArrayList<Integer> mm = (ArrayList)arr.clone();
				boolean ws = true;
				for (int m = (j - 1) % mm.size(); ws; m = (m + (j - 1)) % mm.size()) {
					if(mm.get(m) < i)ws = false;
					mm.remove(m);
					if(mm.size() == i)break;
				}
				if(ws){
					System.out.println(j);
					break;
				}
			}
		}*/
		int[] arr = new int[]{2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 2504881};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int n; (n = parseInt(in.readLine().trim())) != 0; )System.out.println(arr[n-1]); 
	}
}