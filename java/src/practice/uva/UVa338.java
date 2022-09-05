package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 338
 * @problemName Long Multiplication
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 15/07/2012
 **/
import static java.lang.Integer.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
public class UVa338{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String str[];;){
			str=in.readLine().trim().split(" +");
			if(str.length<2) break;
			str[0]=Long.parseLong(str[0])+"";
			str[1]=Long.parseLong(str[1])+"";
			long n=Long.parseLong(str[0]);
			ArrayList<String> s=new ArrayList<String>();
			ArrayList<Integer> p=new ArrayList<Integer>();
			char[] n2=str[1].toCharArray();
			for(int i=n2.length-1,j=0;i>=0;i--,j++){
				long t=n*(n2[i]-'0');
				if(t>0){
					s.add(t+"");
					p.add(j);
				}
			}
			int dist=max((new BigInteger(str[0]).multiply(new BigInteger(str[1]))+"").length(),max(str[0].length(),str[1].length()));
			sb.append(llenar(' ',dist,str[0])+"\n");
			sb.append(llenar(' ',dist,str[1])+"\n");
			sb.append(llenar(' ',dist,llenar('-',max(str[0].length(),str[1].length()),""))+"\n");
			if(s.size()==0) s.add("0");
			if(s.size()==1)
				sb.append(llenar(' ',dist,new BigInteger(str[0]).multiply(new BigInteger(str[1]))+"")+"\n");
			else{
				for(int i=0;i<p.size();i++)
					sb.append(llenar(' ',dist-p.get(i),s.get(i))+"\n");
				sb.append(llenar('-',(new BigInteger(str[0]).multiply(new BigInteger(str[1]))+"").length(),"")+"\n");
				sb.append(llenar(' ',dist,new BigInteger(str[0]).multiply(new BigInteger(str[1]))+"")+"\n");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	static String llenar(char s,int c,String str){
		for(int i=str.length();i<c;i++)
			str=s+str;
		return str;
	}
}
