package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 4596
 * @problemName Headshot
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 24/10/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa4596 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln=in.readLine())!=null;){
			char[] str=ln.trim().toCharArray();
			int cant0=0,cant00=0;
			for(int i=0;i<str.length;i++){
				if(str[i]=='0')cant0++;
				if(str[i]=='0'&&str[(i+1)%str.length]=='0')cant00++;
			}
			double pS=1.*cant00/cant0,pR=1.*cant0/str.length;
			if(pS==pR)System.out.println("EQUAL");
			else if(pS>pR)System.out.println("SHOOT");
			else System.out.println("ROTATE");
		}
	}
}
