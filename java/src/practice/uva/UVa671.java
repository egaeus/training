package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 671
 * @problemName Spell checker
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 22/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;
public class UVa671 {
	static boolean esAceptada(char[] str1, char[] str2){
		if(str1.length == str2.length){
			int cont = 0;
			for (int i = 0; i < str1.length && cont<=1; i++)if(str1[i]!=str2[i])cont++;
			return cont == 1;
		}
		if(str1.length == str2.length + 1)
			for (int i = 0; i < str1.length; i++) {
				int cont = 0;
				for (int j = 0; j < i && cont==0; j++)if(str1[j]!=str2[j])cont++; 
				for (int j = i+1; j < str1.length && cont==0; j++)if(str1[j]!=str2[j-1])cont++;
				if(cont==0)return true;
			}
		if(str1.length + 1 == str2.length)return esAceptada(str2, str1);
		return false;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			in.readLine();
			TreeSet<String> diccionario = new TreeSet<String>();
			ArrayList<String> palabras = new ArrayList<String>();
			for(String ln; !(ln = in.readLine().trim()).equals("#");){
				diccionario.add(ln);
				palabras.add(ln);
			}
			for(String ln; !(ln = in.readLine().trim()).equals("#");){
				sb.append(ln);
				if(diccionario.contains(ln))sb.append(" is correct\n");
				else{
					sb.append(":");
					for (String str: palabras) 
						if(esAceptada(ln.toCharArray(), str.toCharArray()))sb.append(" " + str);
					sb.append("\n");
				}
			}
			if(c<C-1)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
