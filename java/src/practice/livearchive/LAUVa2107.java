package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2107
 * @problemName Double, Double, Toil and Trouble
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2107 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			double vars[][]=new double[4][3];
			for(int i=0;i<4;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int j=0;j<3;j++)vars[i][j]=parseDouble(st.nextToken());
			}
			StringTokenizer st=new StringTokenizer(in.readLine());
			double T=parseDouble(st.nextToken()),V=parseDouble(st.nextToken());
			boolean ws=vars[0][0]*T+vars[0][1]*V>=vars[0][2]&&vars[1][0]*T+vars[1][1]*V>=vars[1][2]&&
					vars[2][0]*T+vars[2][1]*V<=vars[2][2]&&vars[3][0]*T+vars[3][1]*V<=vars[3][2];
			System.out.println(c+" "+(ws?"SAFE":"UNSAFE"));
		}
	}
}
