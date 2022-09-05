package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10038
 * @problemName Jolly Jumpers
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
public class UVa10038 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String a = in.readLine();
			if (a == null || a.equals(""))break;
			String arr[] = a.trim().split(" +");
			if (Integer.parseInt(arr[0]) > 1) {
				TreeSet<Integer> arbol = new TreeSet<Integer>();
				for (int i = 2; i < arr.length; i++){
					int x = Math.abs(Integer.parseInt(arr[i-1])-Integer.parseInt(arr[i]));
					if(x<=Integer.parseInt(arr[0])-1&&x>0)arbol.add(x);
				}				
				System.out.println(arbol.size()==Integer.parseInt(arr[0])-1?"Jolly":"Not jolly");
			} else if (Integer.parseInt(arr[0]) == 1) System.out.println("Jolly");
			else System.out.println("Not jolly");
		}
	}
}
