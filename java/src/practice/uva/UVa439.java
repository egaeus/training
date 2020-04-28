package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 439
 * @problemName Knight Moves 
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class UVa439 {
	static ArrayList<Integer>[] mAdy = new ArrayList[64];
	public static void main(String[] args) throws Throwable{
		for (int i = 0; i < mAdy.length; i++) {
			int x1 = i - 8 + (i%8>5?MAX_VALUE:2), x2 = i - 16 + (i%8>6?MAX_VALUE:1), x3 = i - 16 - (i%8<1?MAX_VALUE:1), x4 = i - 8 - (i%8<2?MAX_VALUE:2),
			    x5 = i + 8 - (i%8<2?MAX_VALUE:2), x6 = i + 16 - (i%8<1?MAX_VALUE:1), x7 = i + 8 + (i%8>5?MAX_VALUE:2), x8 = i + 16 + (i%8>6?MAX_VALUE:1);
			mAdy[i] = new ArrayList<Integer>();
			if(x1 >= 0 && x1 <64)mAdy[i].add(x1);
			if(x2 >= 0 && x2 <64)mAdy[i].add(x2);
			if(x3 >= 0 && x3 <64)mAdy[i].add(x3);
			if(x4 >= 0 && x4 <64)mAdy[i].add(x4);
			if(x5 >= 0 && x5 <64)mAdy[i].add(x5);
			if(x6 >= 0 && x6 <64)mAdy[i].add(x6);
			if(x7 >= 0 && x7 <64)mAdy[i].add(x7);
			if(x8 >= 0 && x8 <64)mAdy[i].add(x8);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine()) != null;) {
			String arr[] = ln.trim().split(" +");
			int desde = (arr[0].charAt(1) - '1') * 8 + (arr[0].charAt(0) - 'a'),
			    hasta = (arr[1].charAt(1) - '1') * 8 + (arr[1].charAt(0) - 'a');
			int[] resultado = new int[64];
			Arrays.fill(resultado, MAX_VALUE);
			resultado[desde] = 0;
			dijkstra(desde, hasta, resultado, new boolean[64]);
			System.out.println("To get from " + arr[0] + " to " + arr[1] + " takes " + resultado[hasta] + " knight moves.");
		}
	}
	static void dijkstra(int desde, int hasta, int[] resultado, boolean visitados[]){
		if(desde == hasta)return;
		visitados[desde]=true;
		for (int i = 0; i < mAdy[desde].size(); i++) 
			resultado[mAdy[desde].get(i)] = Math.min(resultado[desde] + 1, resultado[mAdy[desde].get(i)]);
		int min = MAX_VALUE, val = - 1;
		for (int i = 0; i < resultado.length; i++) 
			if(!visitados[i] && resultado[i] < min){
				min = resultado[i];
				val = i;
			}
		dijkstra(val, hasta, resultado, visitados);
	}
}
