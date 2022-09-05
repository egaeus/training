package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10409
 * @problemName Die Game
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class UVa10409 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim())) != 0; ) {
			LinkedList<Integer> v = new LinkedList<Integer>();
			LinkedList<Integer> h = new LinkedList<Integer>();
			v.add(2);v.add(1);v.add(5);v.add(6);
			h.add(4);h.add(1);h.add(3);h.add(6);
			for (int i = 0; i < N; i++){
				String ln = in.readLine().trim();
				if(ln.equals("north")){
					int n = v.removeFirst();
					v.add(n);
					h.set(1, v.get(1));
					h.set(3, v.get(3));
				}
				if(ln.equals("south")){
					int n = v.removeLast();
					v.addFirst(n);
					h.set(1, v.get(1));
					h.set(3, v.get(3));
				}
				if(ln.equals("east")){
					int n = h.removeFirst();
					h.add(n);
					v.set(1, h.get(1));
					v.set(3, h.get(3));
				}
				if(ln.equals("west")){
					int n = h.removeLast();
					h.addFirst(n);
					v.set(1, h.get(1));
					v.set(3, h.get(3));
				}
			}
			System.out.println(v.get(1));	
		}
	}
}