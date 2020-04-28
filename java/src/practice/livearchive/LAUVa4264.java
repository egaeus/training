package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4264
 * @problemName Message
 * @judge http://livearchive.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 21/11/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa4264 {
	static int cambios(char[][] a, char[][] b){
		int s=0;for(int i=0;i<10;i++)for(int j=0;j<10;j++)if(a[i][j]!=b[i][j])s++;return s;
	}
	static char[][] rotar(char[][] a){
		char[][] res=new char[10][10];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				res[i][j]=a[9-j][i];
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int N=parseInt(in.readLine().trim());
		char[] letras=new char[N];
		char[][][] img=new char[N][][];
		for(int i=0;i<N;i++){
			letras[i]=in.readLine().trim().charAt(0);
			img[i]=new char[10][];
			for(int j=0;j<10;j++)img[i][j]=in.readLine().trim().toCharArray();
		}
		int M=parseInt(in.readLine().trim());
		for(int i=0;i<M;i++){
			char[][] letra=new char[10][];
			for(int j=0;j<10;j++)letra[j]=in.readLine().trim().toCharArray();
			int min=MAX_VALUE,p=-1;
			for(int j=0;j<N;j++){
				int m=cambios(letra,img[j]);
				letra=rotar(letra);
				m=Math.min(m,cambios(letra,img[j]));
				letra=rotar(letra);
				m=Math.min(m,cambios(letra,img[j]));
				letra=rotar(letra);
				m=Math.min(m,cambios(letra,img[j]));
				letra=rotar(letra);
				if(m<min){min=m;p=j;}
			}
			System.out.print(letras[p]);
		}
		System.out.println();
	}
}
