package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2062
 * @problemName Easier Done than Said?
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 01/08/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2062 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;!(ln=in.readLine()).equals("end");){
			char str[]=ln.toCharArray();
			boolean ws=false,ws1=false,ws2=false;
			for(int i=0;i<str.length;i++){
				ws|=esVocal(str[i]);
				ws1|=i<str.length-2&&((esVocal(str[i])&&esVocal(str[i+1])&&esVocal(str[i+2])||(!esVocal(str[i+1])&&!esVocal(str[i+2])&&!esVocal(str[i]))));
				ws2|=i<str.length-1&&str[i]==str[i+1]&&str[i]!='e'&&str[i]!='o';
			}
			sb.append("<"+ln+"> ");
			if(ws&&!ws1&&!ws2)sb.append("is acceptable.\n");
			else sb.append("is not acceptable.\n");
		}
		System.out.print(new String(sb));
	}
	static boolean esVocal(char ch){
		return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
	}
}
