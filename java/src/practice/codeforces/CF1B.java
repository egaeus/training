package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 1B
 * @problemName Spreadsheets
 * @judge http://codeforces.com/
 * @category adhoc
 * @level easy
 * @date Sep 27, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
public class CF1B {
	static int toInteger(char[] a) {
		int sol=0,pot=1;
		for(int i=a.length-1;i>=0;i--,pot*=26)
			sol+=(a[i]-'A'+1)*pot;
		return sol;
	}
	static boolean isZ(char[] a) {
		for(int i=0;i<a.length;i++)
			if(a[i]!='Z')
				return false;
		return true;
	}
	static String llenarA(int l) {
		String s="";
		for(;s.length()<l;)
			s+="A";
		return s;
	}
	static String calculateString(int n) {
		String sol="";
		int pot=1,c=0;
		for(;n/pot>0;pot*=26,c++);
		pot/=26;
		for(int i=0;i<c;i++,n%=pot,pot/=26) {
			if(n/pot==0){
				sol=parseZ(sol);
			}
			else
				sol+=(char)(n/pot+'A'-1);
		}
		return sol;
	}
	
	static String parseZ(String sol) {
		if(sol.length()==0)return "";
		char a=sol.charAt(sol.length()-1);
		sol=sol.substring(0, sol.length()-1);
		if(a>'A')
			sol+=(char)(a-1);
		else {
			sol=parseZ(sol);
		}
		sol+="Z";
		return sol;
	}
	
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Pattern pattern=Pattern.compile("R[0-9]+C[0-9]+");
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			String ln=in.readLine().trim();
			if(pattern.matcher(ln).matches()) {
				String nums=ln.substring(1, ln.indexOf("C"));
				String letras=ln.substring(ln.indexOf("C")+1);
				sb.append(calculateString(parseInt(letras))).append(nums);
			}
			else {
				String letras="",nums="";
				char[] str=ln.toCharArray();
				for(int i=0;i<str.length;i++)
					if(Character.isDigit(str[i]))
						nums+=str[i];
					else
						letras+=str[i];
				sb.append("R").append(nums).append("C").append(toInteger(letras.toCharArray()));
			}
			if(sb.length()>1000000) {
				System.out.print(new String(sb));
				sb=new StringBuilder();
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
