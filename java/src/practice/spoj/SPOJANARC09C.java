package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ANARC09C
 * @problemName Not So Flat After All
 * @judge http://www.spoj.pl
 * @category numbers theory
 * @level easy
 * @date 22/03/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class SPOJANARC09C {
	static TreeMap<Long, Long> descomposicionPrima(long n){
		TreeMap<Long, Long> res = new TreeMap<Long, Long>(); long cont, i, R, N;
		for(cont=0, i=2, R=(long)Math.sqrt(n), N=n; N>1&&i<=R; i++)
			if(N%i==0){cont++;N/=i;i--;}
			else if(cont>0){res.put(i, cont);cont=0;}
		if(cont>0)res.put(i, cont);
		if(N!=1)res.put(N, 1L);
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		for(String ln; (ln = in.readLine())!=null; caso++){
			StringTokenizer st = new StringTokenizer(ln);
			long N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			TreeMap<Long, Long> descN = descomposicionPrima(N);
			TreeMap<Long, Long> descM = descomposicionPrima(M);
			long X = 0, D = 0;
			for(;!descN.isEmpty();){
				Entry<Long, Long> entry = descN.pollFirstEntry();
				X++;
				if(descM.containsKey(entry.getKey())){
					D+=abs(descM.get(entry.getKey())-entry.getValue());
					descM.remove(entry.getKey());
				}
				else D+=entry.getValue();
			}
			for(;!descM.isEmpty();){
				Entry<Long, Long> entry = descM.pollFirstEntry();
				D+=entry.getValue();X++;
			}
			System.out.println(caso+". "+X+":"+D);
		}
	}
}
