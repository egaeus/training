package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 492
 * @problemName Pig-Latin
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 14/12/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa492 {
	static boolean isVowel(char a){
		return a=='a'||a=='A'||a=='e'||a=='E'||a=='i'||a=='I'||a=='o'||a=='O'||a=='u'||a=='U';
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(char n=0;(n=(char)in.read())!=65535;){
			if(Character.isLetter(n)){
				char ch='\0';
				if(isVowel(n))sb.append(n);
				else ch=n;
				for(;Character.isLetter((n=(char)in.read()));)sb.append(n);
				if(ch!='\0')sb.append(ch);
				sb.append("ay");
				sb.append(n);
			}
			else sb.append(n);
		}
		System.out.print(new String(sb));
	}
}
