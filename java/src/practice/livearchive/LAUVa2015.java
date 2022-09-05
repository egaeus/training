package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2015
 * @problemName Bob's Bingo Bonanza
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/07/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2015 {
	static boolean esEquivalente(char[][] R,int[][] t0,int[][] t1){
		TreeSet<Integer> T0=new TreeSet<Integer>(),T1=new TreeSet<Integer>();
		for(int i=0;i<R.length;i++)
			for(int j=0;j<R.length;j++)
				if(R[i][j]=='X'){T0.add(t0[i][j]);T1.add(t1[i][j]);}
		return T0.equals(T1);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=1;;c++){
			char[][] R=new char[5][];
			for(int i=0;i<R.length;i++)R[i]=in.readLine().trim().toCharArray();
			int N=parseInt(in.readLine().trim());
			if(N==0)break;
			if(c>1)System.out.println();
			int[][][] arr=new int[N][5][5];
			for(int i=0;i<N;i++)
				for(int j=0;j<5;j++){
					StringTokenizer st = new StringTokenizer(in.readLine());
					for(int h=0;h<5;h++)arr[i][j][h]=parseInt(st.nextToken());
				}
			System.out.println("Game " + c);
			for(int i=0;i<N;i++)
				for(int j=0;j<i;j++)
					if(esEquivalente(R, arr[i], arr[j])){
						System.out.println("Card "+(i+1)+" is equivalent to card "+(j+1));
						break;
					}
		}
	}
}
