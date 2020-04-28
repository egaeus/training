package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 155
 * @problemName All Squares
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa155{
	static int puntoDentro(int cx,int cy,int k){
		int x1=cx-k,y1=cy-k,x2=cx+k,y2=cy+k;
		return x1<=X&&x2>=X&&y1<=Y&&y2>=Y?1:0;
	}
	static int f(int cx,int cy,int k){
		if(k==0)return 0;
		return f(cx-k,cy-k,k/2)+f(cx+k,cy-k,k/2)+f(cx-k,cy+k,k/2)+f(cx+k,cy+k,k/2)+puntoDentro(cx,cy,k);
	}
	static int X,Y;
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int K=parseInt(st.nextToken());X=parseInt(st.nextToken());Y=parseInt(st.nextToken());
			if(K==0&&X==0&&Y==0)break;
			String s=f(2049/2,2049/2,K)+"";
			for(;s.length()<3;)s=" "+s;
			System.out.println(s);
		}
	}
}
