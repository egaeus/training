package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 384
 * @problemName Slurpys
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 03/01/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa384 {
	static boolean esSlurpy(char[] str){
		for(int i = 0; i < str.length; i++)
			if(esSlimp(str, 0, i) && esSlump(str, i + 1, str.length-1))return true;
		return false;
	}
	static boolean esSlimp(char[] str, int cotaInf, int cotaSup){
		if(cotaInf >= cotaSup)return false;
		if(str[cotaInf] != 'A')return false;
		if(cotaSup == cotaInf + 1 && str[cotaSup] == 'H')return true;
		if(cotaSup <= cotaInf + 1)return false;
		if(str[cotaInf+1] == 'B' && str[cotaSup]=='C')return esSlimp(str, cotaInf + 2, cotaSup - 1);
		return str[cotaSup]=='C' && esSlump(str, cotaInf+1, cotaSup-1);
	}
	static boolean esSlump(char[] str, int cotaInf, int cotaSup){
		if(cotaInf >= cotaSup)return false;
		if(str[cotaInf] != 'E' && str[cotaInf] != 'D')return false;
		int posIni = cotaInf+1;
		if(str[posIni] != 'F')return false;
		for(;posIni <= cotaSup; posIni++)if(str[posIni]!='F')break;
		if(posIni>cotaSup)return false;
		return (posIni == cotaSup && str[cotaSup] == 'G') || esSlump(str, posIni, cotaSup); 
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("SLURPYS OUTPUT");
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++)
			System.out.println(esSlurpy(in.readLine().toCharArray())?"YES":"NO");
		System.out.println("END OF OUTPUT");
	}
}
