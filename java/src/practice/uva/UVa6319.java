package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 6319
 * @problemName No Name
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Sep 19, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa6319 {
	static int[][] segments=new int[10000000][4];
	static int c=0;
	static void copy(int i, int k) {
		segments[i][0]=segments[k][0];
		segments[i][1]=segments[k][1];
		segments[i][2]=segments[k][2];
		segments[i][3]=segments[k][3];
	}
	static void addSegment(int p, int lenght, int posString) {
		for(int i=0;i<c;i++) {
			if(p>=segments[i][0]&&p<segments[i][1]) {
				System.out.println("----");
			}
			if(p==segments[i][0]) {
				for(int j=c;j>i;j--) {
					copy(i-1,i);
					segments[i][0]+=lenght;
					segments[i][1]+=lenght;
				}
				segments[i][1]=lenght;
				segments[i][2]=posString;
				segments[i][3]=0;
				break;
			}
			if(p==segments[i][1]) {
				for(int j=c;j>i+1;j--) {
					copy(i-1,i);
					segments[i][0]+=lenght;
					segments[i][1]+=lenght;
				}
				segments[i+1][0]=segments[i][1];
				segments[i+1][1]=segments[i][1]+lenght;
				segments[i+1][2]=posString;
				segments[i+1][3]=0;
				break;
			}
		}
		c++;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			ArrayList<String> strings=new ArrayList<String>();
			strings.add(in.readLine());
			segments[0][0]=0;
			segments[0][1]=strings.get(0).length();
			segments[0][2]=0;
			segments[0][3]=0;
			c=1;
			for(String ln;!(ln=in.readLine().trim()).equals("END");) {
				
			}
		}
		System.out.print(new String(sb));
	}
}
