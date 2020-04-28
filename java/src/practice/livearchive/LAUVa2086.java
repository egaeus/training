package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2086
 * @problemName Scramble Sort
 * @judge http://livearchive.onlinejudge.org/
 * @category sort
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LAUVa2086 {
	static boolean esNumero(String str){
		Pattern p=Pattern.compile("-[0-9]+|[0-9]+");
		Matcher m=p.matcher(str);
		return m.matches();
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		boolean[] esNumero=new boolean[1000000];
		int numeros[]=new int[1000000];
		String[] cadenas=new String[1000000];
		for(String ln;!(ln=in.readLine().trim()).equals(".");){
			int pN=0,pC=0;
			for(StringTokenizer st=new StringTokenizer(ln.replaceAll("[\\., ]"," "));st.hasMoreTokens();){
				String s=st.nextToken();
				if(esNumero[pN+pC]=esNumero(s))numeros[pN++]=parseInt(s);
				else cadenas[pC++]=s;
			}
			Arrays.sort(numeros,0,pN);
			Arrays.sort(cadenas,0,pC,String.CASE_INSENSITIVE_ORDER);
			for(int i=0,j=0;i<pN||j<pC;){
				sb.append((i+j>0?", ":""));
				if(esNumero[i+j])sb.append(numeros[i++]);
				else sb.append(cadenas[j++]);
			}
			sb.append(".\n");
		}
		System.out.print(new String(sb));
	}
}
