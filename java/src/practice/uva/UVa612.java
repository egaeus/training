package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 612
 * @problemName DNA Sorting
 * @judge http://uva.onlinejudge.org/
 * @category sort
 * @level easy
 * @date 13/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa612 {
	public static void main(String[] args) throws Throwable{
		class Nodo implements Comparable<Nodo>{
			int pos;char[] str;int total;
			Nodo(int pos, char[] str){this.pos = pos;this.str = str;
				for(int i = 0; i < str.length; i++)for(int j = i+1; j < str.length; j++)if(str[i]>str[j])total++;
			}
			public int compareTo(Nodo o) {
				if(total!=o.total)return total-o.total;
				return pos-o.pos;
			}			
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(int c = 0, C = parseInt(in.readLine().trim()); c++<C;){
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			TreeSet<Nodo> set = new TreeSet<Nodo>();
			st.nextToken(); int M = parseInt(st.nextToken());
			for(int i = 0; i < M; i++)set.add(new Nodo(i, in.readLine().trim().toCharArray()));
			for(Nodo d: set)sb.append(new String(d.str)+"\n");
			if(c<C)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
