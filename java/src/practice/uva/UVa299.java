package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 299
 * @problemName Train Swapping
 * @judge http://uva.onlinejudge.org/
 * @category sorting
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa299 {	
	static int sum=0;	
	public static void sort(String[] str){
		for(int i = 1; i < str.length; i++)
			if(Integer.parseInt(str[i])<Integer.parseInt(str[i-1])){
				String h = str[i];
				str[i] = str[i-1];
				str[i-1] = h;
				sum++;
				sort(str);
			}
	}	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; i++) {
			sum = 0;
			int x = Integer.parseInt(in.readLine().trim());
			String s[] = in.readLine().trim().split(" +");
			sort(s);
			System.out.println("Optimal train swapping takes " + sum + " swaps.");
		}
	}
}
