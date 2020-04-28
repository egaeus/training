package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 2191
 * @problemName Potentiometers
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level ???
 * @date 17/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa2191 {
	static class SegmentTree{
		private long[] valores;
		private int izq[], der[], cotas[][],c;
		public SegmentTree(long[] datosIniciales) {
			int n=datosIniciales.length*2;valores=new long[n];
			c=0;
			cotas=new int[n][2];
			izq=new int[n];
			der=new int[n];
			initTree(datosIniciales,0,datosIniciales.length);
		}
		private int initTree(long datos[], int desde, int hasta){
			int C=c++;
			cotas[C][0]=desde;cotas[C][1]=hasta;
			if(hasta-desde>1){
				int p=(hasta+desde)/2;
				izq[C]=initTree(datos,desde,p);
				der[C]=initTree(datos,p,hasta);
				valores[C]=valores[izq[C]]+valores[der[C]];
			}
			else valores[C]=datos[desde];
			return C;
		}
		public void setValor(int index,long val){
			setValor(0,index,val);
		}
		private long setValor(int i,int index,long val){
			if(cotas[i][1]-cotas[i][0]>1){
				long v;
				if(cotas[izq[i]][0]<=index&&cotas[izq[i]][1]>index)v=setValor(izq[i],index,val);
				else v=setValor(der[i],index,val);
				valores[i]+=v;return v;
			}
			long v=val-valores[i];
			valores[i]=val;
			return v;
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
			for(int i=0;i<cotas.length;i++)res+=Arrays.toString(cotas[i]);
			return Arrays.toString(valores)+"\n"+Arrays.toString(izq)+"\n"+Arrays.toString(der)+"\n"+res;
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		long[] arr=new long[200000];
		SegmentTree st=new SegmentTree(arr);
		StringBuilder sb=new StringBuilder();
		for(int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++){
			if(c>1)sb.append("\n");
			sb.append("Case "+c+":\n");
			for(int i=0;i<N;i++)st.setValor(i,parseInt(in.readLine().trim()));			
			for(String ln;!(ln=in.readLine().trim()).equals("END");){
				StringTokenizer stk=new StringTokenizer(ln);
				char C=stk.nextToken().charAt(0);
				int a=parseInt(stk.nextToken()), b=parseInt(stk.nextToken());
				if(C=='S')st.setValor(a-1,b);
				else sb.append(st.getValor(Math.min(a,b)-1,Math.max(a,b))+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
