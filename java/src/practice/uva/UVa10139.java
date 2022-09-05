package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10139
 * @problemName Factovisors
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 26/07/2010
 **/
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa10139 {
	static boolean divide(long m, long n){
		long M = m;
		if(m<=n)return true;
		TreeMap<Long, Long> divisores = new TreeMap<Long, Long>();
		for(long i = 2; m!=1; i++)if(i > Math.sqrt(M) + 1){divisores.put(m, 1L);m=1;}
		else if(m%i==0){divisores.put(i, divisores.get(i)!=null?divisores.get(i)+1:1); m/=i--;}
		long llevo = 1;
		if(divisores.isEmpty())return false;
		if(divisores.lastKey()>n)return false;
		for (long i = 2; i <= n; i++) {
			long I = i;
			for(Entry<Long, Long> entry: divisores.entrySet()){
				while(I%entry.getKey()==0&&entry.getValue()>0){
					entry.setValue(entry.getValue()-1);
					I/=entry.getKey();
					llevo*=entry.getKey();
				};
				if(I==1||llevo==M||entry.getKey()>I||(M/llevo>i&&M/llevo<=n))break;
			}
			if(llevo==M||(M/llevo>i&&M/llevo<=n))return true;
		}			
		return false;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(String ln; (ln = in.readLine()) != null; ){
			StringTokenizer st = new StringTokenizer(ln.trim());
			long n = parseLong(st.nextToken()), m = parseLong(st.nextToken());
			boolean ws = m==0?false:(n==0&&m==1?true:divide(m, n));
			sb.append(m + (ws?" divides ":" does not divide ") + n + "!\n");
		}
		System.out.print(new String(sb));
	}
}
