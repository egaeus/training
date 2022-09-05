package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 484
 * @problemName The Department of Redundancy Department 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
public class UVa484 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, Integer> pos = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> cant = new TreeMap<Integer, Integer>();
		int pos1 = 0;
		while(sc.hasNextInt()){
			int N = sc.nextInt();
			if(cant.containsKey(N))cant.put(N, cant.get(N) + 1);
			else{
				cant.put(N, 1);
				pos.put(pos1++, N);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (Entry<Integer, Integer> entry: pos.entrySet())
			sb.append(entry.getValue() + " " + cant.get(entry.getValue()) + "\n");
		System.out.print(new String(sb));
	}
}
