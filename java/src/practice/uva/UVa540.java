package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 540
 * @problemName Team Queue
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 04/01/2013
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa540{
	static class Escaner{
	        		BufferedReader in;
	        		StringTokenizer st;
	        		Escaner(){
	              			in = new BufferedReader(new InputStreamReader(System.in));
	              			st = new StringTokenizer("");
	        		}
	        		int nextInt() throws Throwable{
	              			if(st.hasMoreTokens())return Integer.parseInt(st.nextToken());
	              			st = new StringTokenizer(in.readLine().trim());
	              			return nextInt();
	        		}
	        		String next() throws Throwable{
              			if(st.hasMoreTokens())return st.nextToken();
              			st = new StringTokenizer(in.readLine().trim());
              			return next();
        		}
	  	}
	public static void main(String args[]) throws Throwable{
		Escaner sc=new Escaner();
		StringBuilder sb=new StringBuilder();
		int posTeam[]=new int[999999+1];
		boolean enColaGeneral[]=new boolean[posTeam.length];
		LinkedList<Integer> colaGeneral=new LinkedList<Integer>();
		LinkedList<Integer> colas[]=new LinkedList[1001];
		for(int i=0;i<1001;i++)colas[i]=new LinkedList<Integer>();		
		for(int N,caso=1;(N=sc.nextInt())!=0;caso++){
			colaGeneral.clear();
			sb.append("Scenario #");
			sb.append(caso);
			sb.append("\n");
			for(int i=0;i<N;i++) {
				int M=sc.nextInt();
				colas[i].clear();
				for(int j=0;j<M;j++) {
					int s=sc.nextInt();
					posTeam[s]=i;
					enColaGeneral[s]=false;
				}
			}
			for(String ln;!(ln=sc.next().trim()).equals("STOP");) {
				if(ln.equals("DEQUEUE")){
					if(!colaGeneral.isEmpty()) {
						sb.append(colas[colaGeneral.getFirst()].removeFirst());
						if(colas[colaGeneral.getFirst()].isEmpty())colaGeneral.removeFirst();
					}
					sb.append("\n");
				}
				else {
					int num=sc.nextInt();
					int team=posTeam[num];
					if(colas[team].isEmpty()) 
						colaGeneral.addLast(team);
					colas[team].addLast(num);
				}
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
