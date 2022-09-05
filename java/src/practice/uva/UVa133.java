package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 133
 * @problemName The Dole Queue
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa133 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine().trim()) != null; ){
			StringTokenizer st = new StringTokenizer(ln);
			int N = parseInt(st.nextToken()), K  = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(N==0&&K==0&&M==0)break;
			LinkedList<Integer> arr = new LinkedList<Integer>();
			for (int i = 1; i <= N; i++)arr.add(i);
			int pos1 = 0, pos2 = N;
			String sol = "";
			while(!arr.isEmpty()){
				pos1 = (pos1 + K - 1)%arr.size();
				pos2 = (pos2 - M)%arr.size();
				if(pos2<0)pos2=arr.size()+pos2;
				sol += (arr.get(pos1)<10?"  " + arr.get(pos1):(arr.get(pos1)<100?" " + arr.get(pos1):arr.get(pos1))); 
				if(pos2!=pos1)sol += (arr.get(pos2)<10?"  " + arr.get(pos2):(arr.get(pos2)<100?" " + arr.get(pos2):arr.get(pos2)));
				arr.remove(pos1);
				if(pos2>pos1){arr.remove(--pos2);}
				if(pos2<pos1){arr.remove(pos2);pos1--;}
				sol += ",";
			}
			System.out.println(sol.substring(0, sol.length() - 1));
		}
	}
}
