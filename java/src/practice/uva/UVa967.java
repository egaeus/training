package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 967
 * @problemName Circular
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 10/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa967{
	public static void main(String args[]) throws Throwable{
		int MAX=1000000;
		boolean[] primes=new boolean[MAX],circularPrimes=new boolean[MAX];
		primes[0]=primes[1]=true;
		for(int i=0;i<primes.length;i++)
			if(!primes[i])
				for(int j=i+i;j<primes.length;j+=i)primes[j]=true;
		for(int i=100;i<circularPrimes.length;i++){
			boolean ws=true;
			String num=i+"";
			for(int j=0;j<num.length()&&ws;j++) {
				ws=!primes[parseInt(num)];
				num=num.substring(1)+num.substring(0,1);
			}
			circularPrimes[i]=ws;
		}
		int res[]=new int[MAX];
		for(int i=100;i<res.length;i++)
			res[i]=res[i-1]+(circularPrimes[i]?1:0);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int I=parseInt(st.nextToken());
			if(I==-1)break;
			int J=parseInt(st.nextToken());
			int c=res[J]-res[I-1];
			if(c==0)sb.append("No Circular Primes.\n");
			else if(c==1)sb.append("1 Circular Prime.\n");
			else sb.append(c+" Circular Primes.\n");
		}
		System.out.print(new String(sb));
	}
}
