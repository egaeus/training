package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 5798
 * @problemName Jupiter Atacks!
 * @judge http://livearchive.onlinejudge.org/
 * @category Segment Tree
 * @level medium
 * @date 07/02/2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa5798{
	static long P;
	static long[] potencias;
	static class SegmentTree{
		private long[] valores;
		private int izq[], der[], cotas[][],c;
		private int[] cuentas;
		private int N;
		private long[] valoresIniciales;
		public SegmentTree(long[] valoresIniciales,long B) {
			this.valoresIniciales=valoresIniciales;
			N=valoresIniciales.length;
			potencias=new long[N];
			potencias[N-1]=1;
			for(int i=N-2;i>=0;i--)
				potencias[i]=((potencias[i+1]%P)*(B%P))%P;
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
		public void setValor(int index,long val){
			int C=0,i=0;
			cuentas[C++]=i;
			for(;cotas[i][1]-cotas[i][0]>1;)
				if(cotas[izq[i]][0]<=index&&cotas[izq[i]][1]>index)cuentas[C++]=(i=izq[i]);
				else cuentas[C++]=(i=der[i]);
			valores[i]=((potencias[index]%P)*(val%P))%P;
			for(C=C-2;C>=0;C--) {
				i=cuentas[C];
				long l=valores[izq[i]],r=valores[der[i]];
				valores[i]=((l%P)+(r%P))%P;
			}
		}
		public long getValor(int desde,int hasta){
			return getValor(0,desde,hasta);
		}
		public long getValor(int i,int desde,int hasta){
			if(cotas[i][0]==desde&&cotas[i][1]==hasta)return valores[i];
			if(desde>=cotas[izq[i]][0]&&hasta<=cotas[izq[i]][1])return getValor(izq[i],desde,hasta);
			if(desde>=cotas[der[i]][0]&&hasta<=cotas[der[i]][1])return getValor(der[i],desde,hasta);
			return (getValor(izq[i],desde,cotas[izq[i]][1])+getValor(der[i],cotas[der[i]][0],hasta))%P;
		}
		public String toString(){
			String res="";
			for(int i=0;i<cotas.length;i++)res+=Arrays.toString(cotas[i])+":"+valores[i];
			return res;
		}
	}	
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			long B=Long.parseLong(st.nextToken());
			P=Long.parseLong(st.nextToken());
			int L=parseInt(st.nextToken()),N=parseInt(st.nextToken());
			if(B==0&&P==0&&L==0&&N==0)break;
			long[] potMod=new long[L];
			long mod=BigInteger.valueOf(B).modInverse(BigInteger.valueOf(P)).longValue();
			potMod[L-1]=1;
			for(int i=L-2;i>=0;i--)potMod[i]=(potMod[i+1]*mod)%P;
			SegmentTree tree=new SegmentTree(new long[L],B);
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(in.readLine());
				char p=st.nextToken().charAt(0);
				if(p=='E')
					tree.setValor(parseInt(st.nextToken())-1,Long.parseLong(st.nextToken()));
				else if(p=='H'){
					int a=parseInt(st.nextToken())-1,b=parseInt(st.nextToken())-1;
					long val=tree.getValor(a,b+1);
					val=((val%P)*(potMod[b]%P))%P;
					sb.append(val);
					sb.append("\n");
				}
			}
			sb.append("-\n");
		}
		System.out.print(new String(sb));
	}
}
