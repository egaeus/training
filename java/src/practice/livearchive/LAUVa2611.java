package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2611
 * @problemName Grandpa's Rubik Cube
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 12/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2611 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N=parseInt(in.readLine().trim()),c=0;c++<N;){
			int[][][] caras=new int[7][3][3];
			for(int j=0;j<3;j++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int i=0;i<3;i++)caras[5][i][j]=st.nextToken().charAt(0);
			}
			for(int j=0;j<3;j++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int h=1;h<5;h++)
					for(int i=0;i<3;i++)caras[h][i][j]=st.nextToken().charAt(0);
			}
			for(int j=0;j<3;j++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int i=0;i<3;i++)caras[6][i][j]=st.nextToken().charAt(0);
			}
			for(StringTokenizer st=new StringTokenizer(in.readLine());st.hasMoreTokens();){
				String ch=st.nextToken();int n;
				if(ch.charAt(0)=='+')n=parseInt(ch.substring(1));
				else n=parseInt(ch);
				if(n==0)break;
				f(caras, n);
			}
			boolean ws=true;
			for(int i=1;i<7&&ws;i++)
				for(int j=0;j<3&&ws;j++)
					for(int h=0;h<3&&ws;h++)
						if(j>0)ws=caras[i][j][h]==caras[i][j-1][h];
						else if(h>0)ws=caras[i][j][h]==caras[i][j][h-1];
			System.out.println(ws?"Yes, grandpa!":"No, you are wrong!");
		}
	}
	static void f(int[][][] caras, int m){
		int[][][] res=new int[7][3][3];
		for(int i=0;i<res.length;i++)
			for(int j=0;j<res[0].length;j++)
				for(int h=0;h<res[0].length;h++)
					res[i][j][h]=caras[i][j][h];
		if(m<0)
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					caras[-m][j][2-i]=res[-m][i][j];
		else
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					caras[m][2-j][i]=res[m][i][j];
		if(m==1)
			for(int i=0;i<3;i++){
				caras[2][0][i]=res[5][0][i];
				caras[5][0][2-i]=res[4][2][i];
				caras[4][2][2-i]=res[6][0][i];
				caras[6][0][i]=res[2][0][i];
			}
		if(m==-1)
			for(int i=0;i<3;i++){
				caras[5][0][i]=res[2][0][i];
				caras[4][2][i]=res[5][0][2-i];
				caras[6][0][i]=res[4][2][2-i];
				caras[2][0][i]=res[6][0][i];
			}
		if(m==2)
			for(int i=0;i<3;i++){
				caras[3][0][i]=res[5][i][2];
				caras[6][i][0]=res[3][0][2-i];
				caras[1][2][i]=res[6][i][0];
				caras[5][i][2]=res[1][2][2-i];
			}
		if(m==-2)
			for(int i=0;i<3;i++){
				caras[5][i][2]=res[3][0][i];
				caras[3][0][2-i]=res[6][i][0];
				caras[6][i][0]=res[1][2][i];
				caras[1][2][2-i]=res[5][i][2];
			}
		if(m==3)
			for(int i=0;i<3;i++){
				caras[5][2][i]=res[2][2][i];
				caras[4][0][i]=res[5][2][2-i];
				caras[6][2][i]=res[4][0][2-i];
				caras[2][2][i]=res[6][2][i];
			}
		if(m==-3)
			for(int i=0;i<3;i++){
				caras[2][2][i]=res[5][2][i];
				caras[5][2][2-i]=res[4][0][i];
				caras[4][0][2-i]=res[6][2][i];
				caras[6][2][i]=res[2][2][i];
			}
		if(m==4)
			for(int i=0;i<3;i++){
				caras[5][i][0]=res[3][2][i];
				caras[1][0][i]=res[5][2-i][0];
				caras[6][i][2]=res[1][0][i];
				caras[3][2][i]=res[6][2-i][2];
			}
		if(m==-4)
			for(int i=0;i<3;i++){
				caras[3][2][i]=res[5][i][0];
				caras[5][2-i][0]=res[1][0][i];
				caras[1][0][i]=res[6][i][2];
				caras[6][2-i][2]=res[3][2][i];
			}
		if(m==5)
			for(int i=0;i<3;i++){
				caras[2][i][0]=res[3][i][0];
				caras[1][i][0]=res[2][i][0];
				caras[4][i][0]=res[1][i][0];
				caras[3][i][0]=res[4][i][0];
			}
		if(m==-5)
			for(int i=0;i<3;i++){
				caras[3][i][0]=res[2][i][0];
				caras[2][i][0]=res[1][i][0];
				caras[1][i][0]=res[4][i][0];
				caras[4][i][0]=res[3][i][0];
			}
		if(m==-6)
			for(int i=0;i<3;i++){
				caras[2][i][2]=res[3][i][2];
				caras[1][i][2]=res[2][i][2];
				caras[4][i][2]=res[1][i][2];
				caras[3][i][2]=res[4][i][2];
			}
		if(m==6)
			for(int i=0;i<3;i++){
				caras[3][i][2]=res[2][i][2];
				caras[2][i][2]=res[1][i][2];
				caras[1][i][2]=res[4][i][2];
				caras[4][i][2]=res[3][i][2];
			}
	}
}
