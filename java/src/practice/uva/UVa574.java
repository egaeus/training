package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 574
 * @problemName Sum It Up
 * @judge http://uva.onlinejudge.org/
 * @category PD
 * @level easy
 * @date 26/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa574 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (; ; ) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int T = parseInt(st.nextToken()), N = parseInt(st.nextToken());
			if(T==0&&N==0)break;
			Comparator<ArrayList<Integer>> comp = new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					for (int i = 0; i < Math.min(o1.size(), o2.size()); i++)
						if(o1.get(i).compareTo(o2.get(i))!=0)return o1.get(i).compareTo(o2.get(i));
					return o1.size() > o2.size()?1:(o1.size()==o2.size()?0:-1);
				}
			};
			TreeSet<ArrayList<Integer>> res[] = new TreeSet[T+1];
			res[0] = new TreeSet<ArrayList<Integer>>(comp);
			res[0].add(new ArrayList<Integer>());
			int[] valores = new int[N];
			for (int i = 0; i < valores.length; i++) valores[i] = parseInt(st.nextToken());
			Arrays.sort(valores);
			for (int i = valores.length - 1; i >= 0 ; i--) 
				for (int j = res.length - 1; j >= 0; j--) 
					if(res[j]!=null&&j+valores[i]<res.length){
						if(res[j+valores[i]]==null)res[j+valores[i]] = new TreeSet<ArrayList<Integer>>(comp);
						for(ArrayList<Integer> arr: res[j]){
							ArrayList<Integer> temp = new ArrayList<Integer>();
							temp.addAll(arr);
							temp.add(valores[i]);
							res[j+valores[i]].add(temp);
						}
					}
			sb.append("Sums of " + T + ":\n");
			if(res[T]==null)sb.append("NONE\n");
			else 
				for (ArrayList<Integer> arr: res[T].descendingSet()){
					for (int i = 0; i < arr.size(); i++)sb.append(arr.get(i) + (i<arr.size()-1?"+":""));
					sb.append("\n");
				}
		}
		System.out.print(new String(sb));
	}
}
