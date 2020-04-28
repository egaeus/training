package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5933
 * @problemName Shut the Box
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 19/04/2012
 **/
import static java.lang.Integer.bitCount;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa5933{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> casos[][]=new ArrayList[23][23];
		for(int i=0;i<casos.length;i++){
			for(int j=0;j<23;j++)casos[i][j]=new ArrayList<Integer>();
			for(int j=0;j<1<<i;j++){
				int suma=0;
				for(int h=0;h<i;h++)if((j&(1<<h))>0)suma+=h+1;
				if(suma<23)casos[i][suma].add(j);
			}
		}
		boolean mem[]=new boolean[1<<22];int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int N=parseInt(st.nextToken()),T=parseInt(st.nextToken()),res=0,max=0;
			if(N==0&&T==0)break;
			Arrays.fill(mem,false);mem[0]=true;
			st=new StringTokenizer(in.readLine());
			for(int i=0,j;i<T;i++){
				int c=parseInt(st.nextToken());
				for(j=max,max=0;j>=0;j--)
					if(mem[j]){
						for(int a:casos[N][c])
							if(sePuede(j,a)){
								mem[j|a]=true;
								res=max(res,bitCount(j|a));
								max=max(max,j|a);
							}
						mem[j]=false;
					}
			}
			System.out.println("Game "+caso+": "+res);
		}
	}
	static boolean sePuede(int llevo,int a){
		return (llevo&a)==0;
	}
}
