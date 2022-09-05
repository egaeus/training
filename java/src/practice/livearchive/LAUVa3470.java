package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3470
 * @problemName Pascal Library
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 12/09/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3470 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),D=parseInt(st.nextToken());
			if(N==0&&D==0)break;
			int[] arr=new int[N];
			boolean ws=false;
			for(int i=0;i<D;i++){
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++){
					arr[j]+=parseInt(st.nextToken());
					if(arr[j]==D)ws=true;
				}
			}
			System.out.println(ws?"yes":"no");
		}
	}
}
