package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 344
 * @problemName Roman Digititis
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 13/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa344 {
	public static void main(String[] args) throws Throwable{
		int[][] res = new int[101][5];
		for(int i = 1; i < res.length; i++){
			res[i]=res[i-1].clone();
			if(i%10<=3)res[i][0]+=(i%10);
			else if(i%10==4){res[i][0]++;res[i][1]++;}
			else if(i%10<=8){res[i][1]++;res[i][0]+=(i%10)-5;}
			else {res[i][0]++;res[i][2]++;}
			if(i/10<=3)res[i][2]+=(i/10);
			else if(i/10==4){res[i][2]++;res[i][3]++;}
			else if(i/10<=8){res[i][3]++;res[i][2]+=(i/10)-5;}
			else {res[i][2]++;res[i][4]++;}
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N; (N = parseInt(in.readLine().trim()))!=0;){
			System.out.println(N + ": " + res[N][0] + " i, " + res[N][1] + " v, " + res[N][2] + " x, " + res[N][3] + " l, " + res[N][4] + " c");
		}
	}
}
