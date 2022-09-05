package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10363
 * @problemName Tic Tac Toe
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/08/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10363{
	static boolean gana(int[][] mat,int p){
		for(int i=0;i<3;i++)
			if(mat[i][0]==mat[i][1]&&mat[i][1]==mat[i][2]&&mat[i][1]==p)return true;
			else if(mat[0][i]==mat[1][i]&&mat[1][i]==mat[2][i]&&mat[1][i]==p)return true;
		if(mat[1][1]==p&&mat[0][0]==mat[1][1]&&mat[1][1]==mat[2][2])return true;
		if(mat[1][1]==p&&mat[0][2]==mat[1][1]&&mat[1][1]==mat[2][0])return true;
		return false;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int t=0,T=parseInt(in.readLine().trim());t<T;t++){
			if(t>0)in.readLine();
			int[][] matriz=new int[3][3];
			int X=0,O=0;
			for(int i=0;i<3;i++){
				char[] ln=in.readLine().trim().toCharArray();
				for(int j=0;j<3;j++)
					if(ln[j]=='X'){matriz[i][j]=1;X++;}
					else if(ln[j]=='O'){matriz[i][j]=2;O++;}
			}
			boolean ws=(!gana(matriz,1)||!gana(matriz,2))&&((gana(matriz,1)&&X==O+1)||(gana(matriz,2)&&X==O)||(!gana(matriz,1)&&!gana(matriz,2)&&X-O<=1&&X-O>=0));
			System.out.println(ws?"yes":"no");
		}
	}
}
