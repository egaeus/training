package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 117
 * @problemName The Postal Worker Rings Once
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 29/02/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
public class UVa117{
	static TreeSet<Integer> lAdy[];
	static long mAdy[][];
	static int N=26;
	static long[][] floydWarshall(){
		long[][] res=new long[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++)
				res[i][j]=mAdy[i][j];
			res[i][i]=0;
		}
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					res[i][j]=min(res[i][j],res[i][k]+res[k][j]);
		return res;
	}
	static void inicializar(){
		mAdy=new long[N][N];
		lAdy=new TreeSet[N];
		for(int i=0;i<N;i++){
			lAdy[i]=new TreeSet<Integer>();
			for(int j=0;j<N;j++)
				mAdy[i][j]=MAX_VALUE;
			mAdy[i][i]=0;
		}
	}
	static boolean esCicloEuleriano(){
		for(int i=0;i<N;i++)
			if(lAdy[i].size()%2!=0) return false;
		return true;
	}
	static long f(){
		int[] nodosImpares=new int[2];
		for(int i=0,j=0;i<N;i++)
			if(lAdy[i].size()%2!=0) nodosImpares[j++]=i;
		long[][] floyd=floydWarshall();
		return floyd[nodosImpares[0]][nodosImpares[1]];
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		inicializar();
		for(String ln;(ln=in.readLine())!=null;){
			if(ln.trim().equals("deadend")){
				int suma=0;
				for(int i=0;i<N;i++)
					for(int j=0;j<N;j++)
						if(mAdy[i][j]<MAX_VALUE) suma+=mAdy[i][j];
				if(esCicloEuleriano())
					System.out.println(suma/2);
				else System.out.println(suma/2+f());
				inicializar();
			}else{
				char[] s=ln.trim().toCharArray();
				mAdy[s[0]-'a'][s[s.length-1]-'a']=mAdy[s[s.length-1]-'a'][s[0]-'a']=min(mAdy[s[0]-'a'][s[s.length-1]-'a'],s.length);
				lAdy[s[0]-'a'].add(s[s.length-1]-'a');
				lAdy[s[s.length-1]-'a'].add(s[0]-'a');
			}
		}
	}
}