package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 465
 * @problemName Overflow
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/03/2012
 **/
import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class UVa465{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=null;boolean suma=false;
			if(ln.contains("+")){st=new StringTokenizer(ln,"+");suma=true;}
			else st=new StringTokenizer(ln,"*");
			BigInteger a=new BigInteger(st.nextToken().trim()),b=new BigInteger(st.nextToken().trim()),r=suma?a.add(b):a.multiply(b);
			sb.append(ln+"\n");
			if(a.compareTo(BigInteger.valueOf(MAX_VALUE))>0)sb.append("first number too big\n");
			if(b.compareTo(BigInteger.valueOf(MAX_VALUE))>0)sb.append("second number too big\n");
			if(r.compareTo(BigInteger.valueOf(MAX_VALUE))>0)sb.append("result too big\n");
		}
		System.out.print(new String(sb));
	}
}
