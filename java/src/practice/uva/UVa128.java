package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 128
 * @problemName Software CRC
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 29/12/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
import static java.lang.Integer.toHexString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa128 {
	static String llenarCeros(String s,int c){
		for(;s.length()<c;)s="0"+s;
		return s;
	}
	static long getSuma(String s){
		char[] str=s.toCharArray();long res=0;
		for(int i=0;i<str.length;i++){
			res=res<<8;
			res%=34943;
			res+=str[i];
			res%=34943;
		}
		res=res<<16;
		return (34943-(res%34943))%34943;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String msj;(msj=in.readLine()).length()==0||msj.charAt(0)!='#';){
			long s=getSuma(msj);
			msj=llenarCeros(toBinaryString((int)s),16);
			System.out.println(llenarCeros(toHexString(parseInt(msj.substring(0,8),2)).toUpperCase(),2)+" "+llenarCeros(toHexString(parseInt(msj.substring(8),2)).toUpperCase(),2));
		}
	}
}
