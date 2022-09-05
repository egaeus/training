package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 4245
 * @problemName Su-Su-Sudoku
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 03/09/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa4245{
	static int pos[][],c;
	/*static char[][] f(int p,char[][] m){
		
	}*/
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			if(t==1)sb.append("\n");
			char[][] mat=new char[9][];
			for(int i=0;i<9;i++)mat[i]=in.readLine().trim().toCharArray();
			pos=new int[5][];c=0;
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					if(mat[i][j]=='0')pos[c++]=new int[]{i,j};
		}
		System.out.print(new String(sb));
	}
}
