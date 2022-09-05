package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 524
 * @problemName Prime Ring Problem
 * @judge http://uva.onlinejudge.org/
 * @category backtracking
 * @level easy
 * @date 11/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa524 {
	static int N;
	static boolean primos[];
	static StringBuilder sb = new StringBuilder();
	static void f(ArrayList<Integer> arr){
		if(arr.size()==N&&!primos[arr.get(N-1)+arr.get(0)])sb.append(arr.toString().replaceAll("[,\\[\\]]","")+"\n");
		for(int i=1;i<=N;i++){
			if(arr.indexOf(i)==-1&&!primos[arr.get(arr.size()-1)+i]){
				arr.add(i);
				f(arr);
				arr.remove(arr.size()-1);
			}
		}
	}
	public static void main(String args[]) throws Throwable {
		primos=new boolean[32];primos[0]=primos[1]=true;
		for(int i=0;i<primos.length;i++)if(!primos[i])for(int j=2*i;j<primos.length;j+=i)primos[j]=true;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso=1;
		for (String ln;(ln=in.readLine())!=null;caso++) {
			if(caso>1)sb.append("\n");
			N=parseInt(ln.trim());
			sb.append("Case "+caso+":\n");
			ArrayList<Integer> arr=new ArrayList<Integer>();
			arr.add(1);
			f(arr);
		}
		System.out.print(new String(sb));
	}
}
