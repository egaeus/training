package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 116
 * @problemName Unidirectional TSP
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level medium
 * @date 27/04/2010
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class UVa116 {
	public static void main(String[] args){
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String arg0, String arg1) {
				if(arg0.length()<arg1.length())return -1;
				else if(arg0.length()>arg1.length())return 1;
				return arg0.compareTo(arg1);
			}
		};
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		for (; sc.hasNextInt(); ) {
			int R = sc.nextInt(), C = sc.nextInt();
			long[][] mat = new long[R][C];
			for (int i = 0; i < R; i++) 
				for (int j = 0; j < C; j++)
					mat[i][j]=sc.nextInt();
			long[][][] res = new long[R][C][2];
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++) 
					Arrays.fill(res[i][j], Long.MAX_VALUE);
			for (int i = 0; i < R; i++){ 
				res[i][C-1][0]=mat[i][C-1];
				res[i][C-1][1]=0;
			}
			for (int i = C - 2; i >= 0; i--)
				for (int j = 0; j < R; j++) {
					int[] valores = new int[]{j-1<0?R-1:j-1, j, (j+1)%R};
					Arrays.sort(valores);
					for (int k = 0; k < valores.length; k++) 
						if(res[j][i+1][0]+mat[valores[k]][i]<res[valores[k]][i][0]||(res[j][i+1][0]+mat[valores[k]][i]==res[valores[k]][i][0]&&(comp.compare(j+"", res[valores[k]][i][1]+"")<0))){
							res[valores[k]][i][0]=res[j][i+1][0]+mat[valores[k]][i];
							res[valores[k]][i][1]=j;
						}
				}
			int ant = 0;
			for (int i = 0; i < res.length; i++) 
				if(res[i][0][0]<res[ant][0][0])ant = i;
			ArrayList<Integer> mmm = new ArrayList<Integer>();
			mmm.add(ant + 1);
			long val = res[(int)ant][0][0];
			ant = (int)res[(int)ant][0][1];
			for (int i = 1; i < C; i++) {
				mmm.add(ant + 1);
				ant = (int)res[(int)ant][i][1];
			}
			for (int i = 0; i < mmm.size(); i++)
				sb.append(mmm.get(i) + (i<mmm.size()-1?" ":""));
			sb.append("\n" + val + "\n");
		}		
		System.out.print(new String(sb));
	}
}
