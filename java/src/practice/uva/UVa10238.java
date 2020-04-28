package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 10238
 * @problemName Throw the Dice
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 19/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class UVa10238{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			int F=parseInt(st.nextToken()),N=parseInt(st.nextToken()),S=parseInt(st.nextToken());
			BigInteger[] mem=new BigInteger[S+1];
			mem[0]=BigInteger.ONE;
			for(int i=1;i<=S;i++)mem[i]=BigInteger.ZERO;
			for(int i=0;i<N;i++)
				for(int j=S;j>=0;j--){
					for(int h=1;h<=F;h++)
						if(j+h<=S)
							mem[j+h]=mem[j+h].add(mem[j]);
					mem[j]=BigInteger.ZERO;
				}
			sb.append(mem[S]+"/"+BigInteger.valueOf(F).pow(N)+"\n");				
		}
		System.out.print(new String(sb));
	}
}
