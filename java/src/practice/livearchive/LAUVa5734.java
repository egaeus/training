package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5734
 * @problemName Shape Number
 * @judge http://livearchive.onlinejudge.org/
 * @category binary-search
 * @level easy
 * @date Aug 21, 2013
 **/
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa5734 {
	static long[][] arr;
	static char[] s;
	static long[] primos=new long[]{252097800623L,22801763489L,2038074743};
	static int max_size=500,base=8,size=-1;
	static long[][] pot;
	static void init() {
		arr=new long[s.length][primos.length];
		size=min(s.length,max_size);
		pot=new long[size][primos.length];
		for(int i=0;i<primos.length;i++)
			pot[0][i]=1;
		for(int i=1;i<size;i++)
			for(int j=0;j<primos.length;j++)
				pot[i][j]=(pot[i-1][j]*base)%primos[j];
		for(int i=0,b=size-1;i<size;i++,b--)
			for(int j=0;j<primos.length;j++)
				arr[0][j]=(arr[0][j]+(pot[b][j]*(s[i]-'0'))%primos[j])%primos[j];
		for(int i=1;i<s.length-size+1;i++)
			for(int j=0;j<primos.length;j++)
				arr[i][j]=(((base*(arr[i-1][j]+(primos[j]-(pot[size-1][j]*(s[i-1]-'0'))%primos[j])%primos[j])%primos[j])%primos[j])+(s[i+size-1]-'0'))%primos[j];
	}
	static boolean compare1(int p,int min,int sizeTo) {
		for(int i=0;i<sizeTo;i++)
			if(s[p+i]<s[min+i])return true;
			else if(s[p+i]>s[min+i])return false;
		return false;		
	}
	static boolean compare(int p,int min) {
		for(int i=0;i<primos.length;i++)
			if(arr[p][i]!=arr[min][i])
				return false;
		return true;
	}
	static boolean compare(int p,int min,int sizeTo) {
		if(sizeTo<size||min>=s.length-size+1||p>=s.length-size+1||!compare(p,min))
			return compare1(p,min,sizeTo);
		return compare(p+size,min+size,sizeTo-size);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null&&(!ln.equals(""));) {
			ln=ln.trim();
			s=ln.toCharArray();
			int first=s[0]-'0';
			for(int i=0;i<s.length-1;i++) {
				int a=s[i]-'0',b=s[i+1]-'0',r=(b+8-a)%8;
				s[i]=(char)(r+'0');
			}
			s[s.length-1]=(char)((-s[s.length-1]+'0'+8+first)%8+'0');
			char[] ss=new char[2*s.length];
			for(int i=0;i<s.length;i++)
				ss[i]=ss[i+s.length]=s[i];
			s=ss;
			init();
			int min=0;
			for(int i=0;i<ln.length();i++) {
				if(compare(i, min, ln.length()))
					min=i;
			}
			for(int i=0;i<ln.length();i++)
				sb.append(s[i+min]);
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
