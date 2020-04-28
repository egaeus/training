package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId BEENUMS
 * @problemName Beehive Numbers
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 19/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class SPOJBEENUMS {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i = 1, j = 1; i < 1000000000; i+=j*6, j++)
			list.add(i);
		Object[] arr = list.toArray();
		for (int N; (N = parseInt(in.readLine().trim())) != -1; ) 
			System.out.println(Arrays.binarySearch(arr, N) >= 0?"Y":"N");
	}
}
