package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2077
 * @problemName Clock
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2077 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		sb.append("Program 3 by team X\n");
		sb.append("Initial time  Final time  Passes\n");
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			int HI,MI,hi=HI=parseInt(st.nextToken()),mi=MI=parseInt(st.nextToken()),hf=parseInt(st.nextToken()),mf=parseInt(st.nextToken()),res=0;
			for(double aAnt=mi*6;hf!=hi||mi!=mf;){
				mi=(mi+1)%60;
				if(mi==0)hi=(hi+1)%12;
				if(hi==0)hi=12;
				double aNew=mi*6;
				if((hi%12)*30+mi*0.5<=aNew&&(hi%12)*30+mi*0.5>aAnt)res++;
				aAnt=aNew;
			}
			sb.append("       "+(HI<10?"0":"")+HI+":"+(MI<10?"0":"")+MI+"       "+(hf<10?"0":"")+hf+":"+(mi<10?"0":"")+mi);
			for(int i=(res+"").length();i<8;i++)sb.append(" ");
			sb.append(res+"\n");
		}
		sb.append("End of program 3 by team X\n");
		System.out.print(new String(sb));
	}
}
