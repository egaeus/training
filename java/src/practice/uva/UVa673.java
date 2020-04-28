package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 673
 * @problemName Parentheses Balance
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa673 {
	static boolean function(String st){
		char cerrado = '\0', abierto = '\0';
		if(st.length()==0)return true;
		if(st.charAt(0) == '('){
			cerrado = ')';
			abierto = '(';
		}
		else{
			cerrado = ']';
			abierto = '[';
		}		
		int nAbiertos = 1;
		for (int i = 1; i < st.length() && nAbiertos > 0; i++){ 
				if(st.charAt(i)==abierto)nAbiertos++;
				if(st.charAt(i)==cerrado)nAbiertos--;
				if (nAbiertos == 0)
					return function(st.substring(1, i)) && function(st.substring(i+1));
		}
		return false;
	}

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, N = parseInt(in.readLine().trim()); i < N; i++) {
			System.out.println(function(in.readLine().trim())?"Yes":"No");
		}
	}
}