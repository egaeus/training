package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10074
 * @problemName Take the land
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Aug 29, 2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10074 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int H=parseInt(st.nextToken()),W=parseInt(st.nextToken());
			if(H==0&&W==0)break;
			int[][] tab=new int[H][W];
			for(int i=0;i<H;i++) {
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<W;j++)
					tab[i][j]=(parseInt(st.nextToken())+1)%2;
			}
			for(int i=1;i<H;i++) 
				tab[i][0]+=tab[i-1][0];
			for(int i=1;i<W;i++)
				tab[0][i]+=tab[0][i-1];
			for(int i=1;i<H;i++)
				for(int j=1;j<W;j++)
					tab[i][j]+=tab[i-1][j]+tab[i][j-1]-tab[i-1][j-1];
			int max=0;
			for(int i=0;i<H;i++)
				for(int j=0;j<W;j++)
					for(int i1=i;i1<H;i1++)
						for(int j1=j;j1<W;j1++) {
							int val=tab[i1][j1]-(i>0?tab[i-1][j1]:0)-(j>0?tab[i1][j-1]:0)+(i>0&&j>0?tab[i-1][j-1]:0);
							if(val==(i1-i+1)*(j1-j+1))
								max=max(max,val);
						}
			System.out.println(max);
		}
	}
}
