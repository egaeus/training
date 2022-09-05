package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3934
 * @problemName He is Offside!
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 21/10/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa3934 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			int[] atck=new int[N], def=new int[M];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)atck[i]=parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++)def[i]=parseInt(st.nextToken());
			Arrays.sort(def);
			boolean ws=true;
			for(int i=0;i<N&&ws;i++){
				ws=def[1]<=atck[i];
			}
			System.out.println(ws?"N":"Y");
		}
	}
}
