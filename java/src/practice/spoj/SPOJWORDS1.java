package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId WORDS1
 * @problemName Play on Words
 * @judge http://www.spoj.pl
 * @category graph
 * @level easy
 * @date 11/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
public class SPOJWORDS1 {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			int[] arr = new int[26];
			ArrayList<Integer>[] lAdy = new ArrayList[26];
			for(int i = 0; i < lAdy.length; i++)lAdy[i] = new ArrayList<Integer>();
			TreeSet<Integer> visitas = new TreeSet<Integer>();
			for(int i = 0, I = parseInt(in.readLine().trim()); i++<I; ){
				char[] str = in.readLine().trim().toCharArray();
				arr[str[0]-'a']++;
				arr[str[str.length-1]-'a']--;
				visitas.add(str[0]-'a');
				visitas.add(str[str.length-1]-'a');
				lAdy[str[0]-'a'].add(str[str.length-1]-'a');
				lAdy[str[str.length-1]-'a'].add(str[0]-'a');
			}
			int totalNegativos = 0, totalPositivos = 0;
			for(int n: arr)
				if(n<0)totalNegativos+=n;
				else totalPositivos+=n;
			if((totalNegativos==-1&&totalPositivos==1)||(totalNegativos==0&&totalPositivos==0)){
				LinkedList<Integer> cola = new LinkedList<Integer>();
				TreeSet<Integer> visitados = new TreeSet<Integer>();
				visitados.add(visitas.first());
				cola.add(visitas.first());
				while(!cola.isEmpty()){
					int actual = cola.pollFirst();
					for(int n: lAdy[actual])
						if(!visitados.contains(n)){
							visitados.add(n);
							cola.add(n);
						}
				}
				if(visitados.size() == visitas.size())sb.append("Ordering is possible.\n");
				else sb.append("The door cannot be opened.\n");
			}
			else sb.append("The door cannot be opened.\n");
		}
		System.out.print(new String(sb));
	}
}
