package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId OFFSIDE
 * @problemName He is offside!
 * @judge http://www.spoj.pl
 * @category adhoc
 * @level easy
 * @date 24/02/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJOFFSIDE {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(StringTokenizer st; (st = new StringTokenizer(in.readLine()))!=null; ){
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			int atck = MAX_VALUE;
			int def1 = MAX_VALUE, def2 = MAX_VALUE;
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++)atck = Math.min(parseInt(st.nextToken()), atck);
			st = new StringTokenizer(in.readLine());
			for(int i = 0, K; i < M; i++)if(def1>(K=parseInt(st.nextToken()))){def2=def1;def1=K;}else if(def2>K)def2=K;
			sb.append(atck>=def2?"N\n":"Y\n");
		}
		System.out.print(new String(sb));
	}
}
