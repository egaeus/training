package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 392
 * @problemName Polynomial Showdown
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/12/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa392 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			ArrayList<Integer> coef=new ArrayList<Integer>();
			for(int i=0,c=0,n;i<9;i++){
				n=parseInt(st.nextToken());
				if(n!=0||(n==0&&c>0)){coef.add(n);c++;}
			}
			String res="";
			for(int i=0,n;i<coef.size();i++){
				n=coef.get(i);
				if(n!=0){
					if(i==0&&n<0)res+="-";
					else if(i>0){
						if(n>0)res+="+ ";
						else res+="- ";
					}
					if((i<coef.size()-1&&abs(n)!=1)||coef.size()-1==i)res+=abs(n);
					if(i<coef.size()-1)res+="x";
					if(i<coef.size()-2)res+="^"+(coef.size()-i-1);
					if(i<coef.size()-1)res+=" ";
				}
			}
			if(res.length()==0)res="0";
			sb.append(res.trim()+"\n");
		}
		System.out.print(new String(sb));
	}
}
