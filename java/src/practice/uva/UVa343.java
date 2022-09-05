package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 343
 * @problemName What Base Is This?
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 12/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa343{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);String a=st.nextToken(),b=st.nextToken();
			boolean ws=false;
			for(int i=2;i<37&&!ws;i++)
				for(int j=2;j<37&&!ws;j++)
					try{
						ws=parseInt(a,i)==parseInt(b,j);
						if(ws)sb.append(a+" (base "+i+") = "+b+" (base "+j+")\n");
					}catch(Exception e){}
			if(!ws)sb.append(a+" is not equal to "+b+" in any base 2..36\n");
		}
		System.out.print(new String(sb));
	}
}
