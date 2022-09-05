package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId NGM
 * @problemName A Game with Numbers
 * @judge http://www.spoj.pl
 * @category adhoc, dp
 * @level easy
 * @date 10/03/2011
 **/
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJNGM {
	/* Funci�n y Memoization: Era m�s facil que eso....
	static TreeMap<Long, Boolean> mem;
	static boolean function(long N){
		if(mem.containsKey(N))return mem.get(N);
		boolean ws = N%2==1;
		N = N>>1;
		if(N==0)return !ws;
		boolean[] arr = new boolean[10];
		for(int M = (int)N; M > 0; M/=10)arr[M%10]=true;
		boolean res = !ws;
		for(int i = 1; i < arr.length && res!=ws; i++)
			if(arr[i])
				res=function(ws?(N-i)<<1:(((N-i)<<1)+1));
		mem.put((N<<1) + (ws?1:0), res);
		return res;
	}*/
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null;){
			long N = parseLong(ln);
			if(N%10==0)sb.append("2\n");
			else sb.append("1\n" + N%10 + "\n\n");
			System.out.print(new String(sb));
		}
	}
}
