package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 6162
 * @problemName Log Books
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 10, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa6162 {
	static boolean isNight(int sunrise,int sunset,int start,int finish) {
		if(start>sunrise&&start<sunset&&finish>sunrise&&finish<sunset)return false;
		int cota=start-finish/2+(start-finish)%2;
		if(start>sunrise&&start<sunrise)return finish-sunset>=cota;
		if(finish>sunrise&&finish<sunset)return sunrise-start>=cota;
		return true;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			boolean ws=true;
			int night=0,total=0;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				String sunrise=st.nextToken(),sunset=st.nextToken(),start=st.nextToken(),finish=st.nextToken();
				int rise=parseInt(sunrise.substring(0,sunrise.indexOf(":")))*60+parseInt(sunrise.substring(sunrise.indexOf(":")+1)),
						set=parseInt(sunset.substring(0,sunset.indexOf(":")))*60+parseInt(sunset.substring(sunset.indexOf(":")+1)),
						s=parseInt(start.substring(0,start.indexOf(":")))*60+parseInt(start.substring(start.indexOf(":")+1)),
						f=parseInt(finish.substring(0,finish.indexOf(":")))*60+parseInt(finish.substring(finish.indexOf(":")+1));
				if(f-s>120)ws=false;
				if(isNight(rise, set, s, f))night+=f-s;
				total+=f-s;
			}
			sb.append(ws&&total/60>=50&&night/60>=10?"PASS":"NON").append("\n");
		}
		System.out.print(new String(sb));
	}
}
