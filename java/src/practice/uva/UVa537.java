package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 537
 * @problemName Artificial Intelligence?
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 7/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa537{
	static double getNum(char[] s){
		int i=0;String n="";for(;s[i]=='.'||Character.isDigit(s[i]);i++)n+=s[i];
		if(s[i]=='m')return Double.parseDouble(n)/1000;
		if(s[i]=='k')return Double.parseDouble(n)*1000;
		if(s[i]=='M')return Double.parseDouble(n)*1000000;
		return Double.parseDouble(n);
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		char[] unidades=new char[]{'U','I','P'};
		StringBuilder sb=new StringBuilder();
		for(int T=parseInt(in.readLine().trim()),t=0;t++<T;){
			System.out.printf("Problem #"+t+"\n");
			String[] s=in.readLine().split("=");
			char u1=s[0].charAt(s[0].length()-1),u2=s[1].charAt(s[1].length()-1);
			double a=getNum(s[1].toCharArray()),b=getNum(s[2].toCharArray());
			Double[] val=new Double[3];
			for(int i=0;i<3;i++){
				if(unidades[i]==u1)val[i]=a;
				if(unidades[i]==u2)val[i]=b;
			}
			if(val[0]==null)System.out.printf(Locale.US,"U=%.2fV\n",val[2]/val[1]);
			else if(val[1]==null)System.out.printf(Locale.US,"I=%.2fA\n",val[2]/val[0]);
			else System.out.printf(Locale.US,"P=%.2fW\n",val[0]*val[1]);
			System.out.printf("\n");
		}
	}
}
