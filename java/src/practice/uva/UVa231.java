package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 231
 * @problemName Testing the CATCHER
 * @judge http://uva.onlinejudge.org/
 * @category pd
 * @level easy
 * @date 22/10/2010
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class UVa231 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int caso = 1;;caso++){
			int n = parseInt(in.readLine().trim());
			if(n==-1)break;
			if(caso!=1)System.out.println();
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(n);
			for (int i; (i = parseInt(in.readLine().trim())) != -1; ) 
				list.addFirst(i);
			System.out.println("Test #" + caso + ":");
			Comparator<Integer> comparador = new Comparator<Integer>() {			
				public int compare(Integer o1, Integer o2) {
					return (Integer)(o1).compareTo((Integer)o2);
				}
			}; 
			System.out.println("  maximum possible interceptions: "+lis2(list.toArray(), comparador));
		}
	}
	static int lis2(Object[] arr, Comparator comparador) {
		int n=arr.length, res=0; 
		Object val[]=new Object[n+1]; 
		val[0]=MIN_VALUE; 
		for (Object v:arr) { 
			int j = Arrays.binarySearch(val,0,res+1,v, comparador); 
			j=(j<0?-j-1:j)-1; 
			if (j==res|| comparador.compare(v, val[j+1]) < 0) {
				val[j+1]=v; 
				res=Math.max(res,j+1);
			} 
		}
		return res;
	}
}
