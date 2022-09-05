package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 514
 * @problemName Rails
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 26/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa514 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N=parseInt(in.readLine().trim()))!=0;) {
			for(;;){
				String ln=in.readLine();
				StringTokenizer st=new StringTokenizer(ln);
				if(parseInt(st.nextToken())==0)break;
				st = new StringTokenizer(ln);
				LinkedList<Integer> A = new LinkedList<Integer>();
				A.add(N+1);
				LinkedList<Integer> B = new LinkedList<Integer>();
				for (int i=0;i<N;i++) B.add(parseInt(st.nextToken()));
				LinkedList<Integer> abajo = new LinkedList<Integer>();
				while(A.size()<N+1){
					if(B.size()>0&&B.getLast()==A.getFirst()-1)A.addFirst(B.pollLast());
					else if(abajo.size()>0&&abajo.getLast()==A.getFirst()-1)A.addFirst(abajo.pollLast());
					else if(B.size()>0)abajo.add(B.pollLast());
					else break;
				}
				System.out.println(A.size()==N+1?"Yes":"No");
			}
			System.out.println();
		}
	}
}
