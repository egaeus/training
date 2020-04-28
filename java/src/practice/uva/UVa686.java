package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 686
 * @problemName Goldbach's Conjecture (II)
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
public class UVa686 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> primos = new TreeSet<Integer>();
		boolean[] arr = new boolean[32769];
		int[] arr1 = new int[32769];
		for (int i = 2; i < 32768; i++)
			if(!arr[i]){
				primos.add(i);
				for (int j = i+i; j < 32768; j+=i) arr[j]=true;
			}
		Object[] casa = primos.toArray();
		for (int i = 0; i < casa.length; i++)
			for (int j = i; j < casa.length; j++) 
				if((Integer)casa[i]+(Integer)casa[j]<=32768)arr1[(Integer)casa[i]+(Integer)casa[j]]++;
		while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if(n==0)break;
			System.out.println(arr1[n]);
		}
	}	
}
