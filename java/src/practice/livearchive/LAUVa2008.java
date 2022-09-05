package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2008
 * @problemName Bouncy Balls
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 27/07/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2008 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int R,caso=1;(R=parseInt(in.readLine().trim()))!=0;caso++){
			if(caso>1)System.out.println();
			System.out.println("Test Rig "+caso);
			for(;;){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int D=parseInt(st.nextToken()),T=parseInt(st.nextToken());
				if(D==0&&T==0)break;
				if(T==90)System.out.println(D/(2*R));
				else System.out.println((int)(D/((sin(2*toRadians(T))*R)/sin(toRadians(90-T)))));
			}
		}

	}

}
