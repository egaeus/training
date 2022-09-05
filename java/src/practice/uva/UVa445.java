package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 445
 * @problemName Marvelous Mazes
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 13/12/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa445 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			char[] str=ln.toCharArray();
			for(int i=0,j=0;i<str.length;i++)
				if(Character.isDigit(str[i]))j+=str[i]-'0';
				else{
					String s=str[i]+"";
					if(str[i]=='b')s=" ";
					else if(str[i]=='!')s="\n";
					for(j=Math.max(1,j);j>0;j--)sb.append(s);
				}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
