package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 446
 * @problemName Kibbles "n" Bits "n" Bits "n" Bits
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa446 {
	static String llenarCeros(String s){
		for(;s.length()<13;)s="0"+s;return s;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c=0,C=parseInt(in.readLine().trim());c++<C;) {
			String ln,sgn,arr[]=(ln=in.readLine()).split("[\\+-]");
			int A=parseInt(arr[0].trim(),16),B=parseInt(arr[1].trim(),16),R;
			if(ln.contains("-")){R=A-B;sgn="-";}
			else {R=A+B;sgn="+";}
			System.out.println(llenarCeros(Integer.toString(A,2))+" "+sgn+" "+llenarCeros(Integer.toString(B,2))+" = "+R);
		}
	}
}
