package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 409
 * @problemName Excuses, Excuses!
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 12/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa409 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();int caso=1;
		for (String ln;(ln=in.readLine())!=null;caso++) {
			StringTokenizer st=new StringTokenizer(ln);
			int K=parseInt(st.nextToken()),E=parseInt(st.nextToken()),max=0;
			TreeSet<String> keyWords=new TreeSet<String>();
			for(int i=0;i<K;i++)keyWords.add(in.readLine().trim().toLowerCase());
			ArrayList<String> solucion=new ArrayList<String>();
			for(int i=0,n=0;i<E;i++,n=0){
				String[] arr=(ln=in.readLine()).toLowerCase().split("[^a-z]+");
				for(String s:arr)if(keyWords.contains(s))n++;
				if(max<n){max=n;solucion=new ArrayList<String>();solucion.add(ln);}
				else if(max==n)solucion.add(ln);
			}
			sb.append("Excuse Set #"+caso+"\n");
			for(String s:solucion)sb.append(s+"\n");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
