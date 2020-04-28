package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2282
 * @problemName P,MTHBGWB
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 18/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2282 {
	static boolean compare(char[] str, char[] str1){
		if(str.length!=str1.length)return false;
		for(int i=0;i<str.length;i++)if(str[i]!=str1[i])return false;
		return true;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		char[][][] letras=new char[][][]{
				{{'A'},".-".toCharArray()},{{'B'},"-...".toCharArray()},{{'C'},"-.-.".toCharArray()},{{'D'},"-..".toCharArray()},
				{{'E'},".".toCharArray()},{{'F'},"..-.".toCharArray()},{{'G'},"--.".toCharArray()},{{'H'},"....".toCharArray()},
				{{'I'},"..".toCharArray()},{{'J'},".---".toCharArray()},{{'K'},"-.-".toCharArray()},{{'L'},".-..".toCharArray()},
				{{'M'},"--".toCharArray()},{{'N'},"-.".toCharArray()},{{'O'},"---".toCharArray()},{{'P'},".--.".toCharArray()},
				{{'Q'},"--.-".toCharArray()},{{'R'},".-.".toCharArray()},{{'S'},"...".toCharArray()},{{'T'},"-".toCharArray()},
				{{'U'},"..-".toCharArray()},{{'V'},"...-".toCharArray()},{{'W'},".--".toCharArray()},{{'X'},"-..-".toCharArray()},
				{{'Y'},"-.--".toCharArray()},{{'Z'},"--..".toCharArray()},{{'_'},"..--".toCharArray()},{{','},".-.-".toCharArray()},
				{{'.'},"---.".toCharArray()},{{'?'},"----".toCharArray()}
		};
		StringBuilder sb=new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			sb.append(c+": ");
			char[] A=in.readLine().trim().toCharArray();
			int[] arr=new int[A.length];
			String s="";
			for(int i=0;i<A.length;i++)
				for(int j=0;j<letras.length;j++)
					if(letras[j][0][0]==A[i]){
						arr[i]=letras[j][1].length;
						s+=new String(letras[j][1]);
						break;
					}
			A=s.toCharArray();
			for(int i=arr.length-1,j=0;i>=0;i--){
				char[] t=new char[arr[i]];
				for(int k=0;k<arr[i];k++,j++)t[k]=A[j];
				for(int k=0;k<letras.length;k++)
					if(compare(letras[k][1],t))
						sb.append(letras[k][0]);
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
