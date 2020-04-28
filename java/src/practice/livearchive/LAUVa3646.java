package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @problemId 3646
 * @problemName Transcript
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 30/11/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
public class LAUVa3646 {
	static int dist[][],TOP;
	static char[] pal,dig;
	static long mem[][];
	static TreeMap<Character,Integer> mapa;
	static long f(int i,int j){
		if(j==dig.length)return -(TOP+1)*(pal.length-i);
		if(i==pal.length)return (TOP+1)*(dig.length-j);;
		if(mem[i][j]!=MIN_VALUE)return mem[i][j];
		return mem[i][j]=max(f(i+1,j)-(TOP+1),f(i+1,j+1)+TOP+1-dist[mapa.get(pal[i])][mapa.get(dig[j])]);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln=in.readLine())!=null;){
			int N=parseInt(ln.trim());
			char[][] mat=new char[N][];
			mapa=new TreeMap<Character, Integer>();
			for(int i=0;i<mat.length;i++){
				mat[i]=in.readLine().toLowerCase().toCharArray();
				for(int j=0;j<mat[i].length;j++)if(!mapa.containsKey(mat[i][j]))mapa.put(mat[i][j],mapa.size());
			}
			dist=new int[mapa.size()][mapa.size()];
			for(int[] m:dist)Arrays.fill(m,MAX_VALUE);
			TOP=0;
			for(int i=0;i<N;i++)
				for(int j=0;j<mat[i].length;j++)
					for(int k=0;k<N;k++)
						for(int h=0;h<mat[k].length;h++){
							int a=mapa.get(mat[i][j]),b=mapa.get(mat[k][h]);
							TOP=Math.max(TOP,dist[a][b]=min(dist[a][b],Math.max(abs(k-i),abs(h-j))));
						}
			for(int i=0;i<N;i++)for(int j=0;j<mat[i].length;j++)dist[i][j]=Math.min(dist[i][j],TOP+1);
			pal=in.readLine().toLowerCase().toCharArray();
			dig=in.readLine().toLowerCase().toCharArray();
			mem=new long[pal.length][dig.length];
			for(long[] m:mem)Arrays.fill(m,MIN_VALUE);
			System.out.println(f(0,0));
		}
	}
}
