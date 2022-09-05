package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId TRIPINV
 * @problemName Mega Inversions
 * @judge http://www.spoj.pl
 * @category Segment Tree
 * @level easy
 * @date 14/02/2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJTRIPINV{
	static class SegmentTree{
		private long[] valores;
		private int izq[], der[], cotas[][],c;
		private int[] cuentas;
		private int N;
		private long[] valoresIniciales;
		public SegmentTree(long[] valoresIniciales) {
			this.valoresIniciales=valoresIniciales;
			N=valoresIniciales.length;
			int n=N*2;valores=new long[n];
			c=0;
			cotas=new int[n][2];
			izq=new int[n];
			der=new int[n];
			cuentas=new int[N+1];
			initTree(0,N);
		}
		private int initTree(int desde, int hasta){
			int C=c++;
			cotas[C][0]=desde;cotas[C][1]=hasta;
			if(hasta-desde>1){
				int p=(hasta+desde)/2;
				izq[C]=initTree(desde,p);
				der[C]=initTree(p,hasta);
				valores[C]=valores[izq[C]]+valores[der[C]];
			}
			valores[C]=valoresIniciales[desde];
			return C;
		}
		public void setValor(int index){
			int C=0,i=0;
			cuentas[C++]=i;
			for(;cotas[i][1]-cotas[i][0]>1;)
				if(cotas[izq[i]][0]<=index&&cotas[izq[i]][1]>index)cuentas[C++]=(i=izq[i]);
				else cuentas[C++]=(i=der[i]);
			valores[i]++;
			for(C=C-2;C>=0;C--) {
				i=cuentas[C];
				long l=valores[izq[i]],r=valores[der[i]];
				valores[i]=l+r;
			}
		}
		public long getValor(int desde,int hasta){
			return getValor(0,desde,hasta);
		}
		public long getValor(int i,int desde,int hasta){
			if(cotas[i][0]==desde&&cotas[i][1]==hasta)return valores[i];
			if(desde>=cotas[izq[i]][0]&&hasta<=cotas[izq[i]][1])return getValor(izq[i],desde,hasta);
			if(desde>=cotas[der[i]][0]&&hasta<=cotas[der[i]][1])return getValor(der[i],desde,hasta);
			return getValor(izq[i],desde,cotas[izq[i]][1])+getValor(der[i],cotas[der[i]][0],hasta);
		}
		public String toString(){
			String res="";
			for(int i=0;i<cotas.length;i++)res+=Arrays.toString(cotas[i])+":"+valores[i];
			return res;
		}
		public void clear(){
			Arrays.fill(valores,0);
		}
	}	
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int N=parseInt(in.readLine().trim());
		int[] arr=new int[N];
		SegmentTree tree=new SegmentTree(new long[N+2]);
		long[] s=new long[N];
		StringTokenizer st=new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=parseInt(st.nextToken());
			tree.setValor(arr[i]);
			s[i]=tree.getValor(arr[i]+1,N+2);
		}
		tree.clear();
		long sol=0;
		for(int i=N-1;i>=0;i--) {
			tree.setValor(arr[i]);
			sol+=s[i]*tree.getValor(0,arr[i]);
		}
		System.out.println(sol);
	}
}
