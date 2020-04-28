package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId AE5B2
 * @problemName Permutacja
 * @judge http://www.spoj.pl
 * @category Segment Tree
 * @level medium
 * @date 04/02/2013
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJAE5B2{
	static int[] cant;
	static class SegmentTree{
		private int[][] valores;
		private int izq[], der[], cotas[][],c;
		private int index,val;
		int[] cuentas;
		public SegmentTree(int N) {
			int n=N*2;valores=new int[n][2];
			c=0;
			cotas=new int[n][2];
			izq=new int[n];
			der=new int[n];
			cuentas=new int[N+1];
			initTree(1,N+1);
		}
		private int initTree(int desde, int hasta){
			int C=c++;
			cotas[C][0]=desde;cotas[C][1]=hasta;
			if(hasta-desde>1){
				int p=(hasta+desde)/2;
				izq[C]=initTree(desde,p);
				der[C]=initTree(p,hasta);
				int fi=valores[izq[C]][0],fd=valores[der[C]][0],si=valores[izq[C]][1],sd=valores[der[C]][1];
				int restar=min(fi,sd);
				fi-=restar;
				sd-=restar;
				valores[C][1]=sd+si;
				valores[C][0]=fd+fi;
			}
			else {
				if(cant[desde]>0) {
					valores[C][1]=cant[desde]-1;
					valores[C][0]=0;
				}
				else {
					valores[C][1]=0;
					valores[C][0]=1;
				}
			}
			return C;
		}
		public void setValor(int index,int val){
			this.index=index;
			this.val=val;
			setValor(0);
		}
		private void setValor(int i){
			int c=0;
			cuentas[c++]=i;
			for(;cotas[i][1]-cotas[i][0]>1;)
				if(cotas[izq[i]][0]<=index&&cotas[izq[i]][1]>index)cuentas[c++]=(i=izq[i]);
				else cuentas[c++]=(i=der[i]);
			if(val==-1) 
				if(valores[i][1]==0)valores[i][0]++;
				else valores[i][1]--;
			else
				if(valores[i][0]==0)valores[i][1]++;
				else valores[i][0]--;
			for(c=c-2;c>=0;c--) {
				i=cuentas[c];
				int fi=valores[izq[i]][0],fd=valores[der[i]][0],si=valores[izq[i]][1],sd=valores[der[i]][1];
				int restar=min(fi,sd);
				fi-=restar;
				sd-=restar;
				valores[i][1]=sd+si;
				valores[i][0]=fd+fi;
			}
		}
		public String toString(){
			String res="";
			for(int i=0;i<cotas.length;i++)res+=Arrays.toString(cotas[i]);
			String s="";
			for(int i=0;i<valores.length;i++)s+=Arrays.toString(valores[i]);
			return s+"\n"+Arrays.toString(izq)+"\n"+Arrays.toString(der)+"\n"+res;
		}
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=parseInt(in.readLine().trim());
		cant=new int[N+1];
		int[] arr=new int[N];
		StringTokenizer stk=new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			int a=parseInt(stk.nextToken());
			arr[i]=a;
			cant[a]++;
		}
		SegmentTree st=new SegmentTree(N);
		//System.out.println(st);
		sb.append(st.valores[0][0]==0&&st.valores[0][1]==0?"TAK":"NIE");
		sb.append("\n");
		int M=parseInt(in.readLine().trim());
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(in.readLine());
			int a=parseInt(stk.nextToken())-1,v=parseInt(stk.nextToken());
			st.setValor(arr[a],-1);
			st.setValor(v,1);
			arr[a]=v;
			sb.append(st.valores[0][0]==0&&st.valores[0][1]==0?"TAK":"NIE");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}

/*

#include <stdio.h>

int cant[200001];
int valores[400000][2];
int izq[400000], der[400000], cotas[400000][2],c;
int cuentas[100];
int initTree(int desde, int hasta){
  int C=c++,p,fi,fd,si,sd,restar;
  cotas[C][0]=desde;cotas[C][1]=hasta;
  if(hasta-desde>1){
	p=(hasta+desde)/2;
	izq[C]=initTree(desde,p);
	der[C]=initTree(p,hasta);
    fi=valores[izq[C]][0];
    fd=valores[der[C]][0];
    si=valores[izq[C]][1];
    sd=valores[der[C]][1];
	restar=min(fi,sd);
	fi-=restar;
	sd-=restar;
	valores[C][1]=sd+si;
	valores[C][0]=fd+fi;
  }
  else {
    if(cant[desde]>0) {
	  valores[C][1]=cant[desde]-1;
	  valores[C][0]=0;
	}
	else {
	  valores[C][1]=0;
	  valores[C][0]=1;
	}
  }
  return C;
}

void segmentTree(int N) {
  int n=N*2,i;
  for(i=0;i<n;i++){
    valores[i][0]=0;
    valores[i][1]=0;
  }
  c=0;
  initTree(1,N+1);
}

int min(int a,int b){
  if(a<b)return a;
  return b;
}

void setValor(int index,int val){
  int i=0;
  c=0;
  cuentas[c++]=i;
  for(;cotas[i][1]-cotas[i][0]>1;)
	if(cotas[izq[i]][0]<=index&&cotas[izq[i]][1]>index)cuentas[c++]=(i=izq[i]);
 	else cuentas[c++]=(i=der[i]);
  if(val==-1) 
	if(valores[i][1]==0)valores[i][0]++;
	else valores[i][1]--;
  else
	if(valores[i][0]==0)valores[i][1]++;
	else valores[i][0]--;
  for(c=c-2;c>=0;c--) {
	i=cuentas[c];
	int fi=valores[izq[i]][0],fd=valores[der[i]][0],si=valores[izq[i]][1],sd=valores[der[i]][1];
	int restar=min(fi,sd);
	fi-=restar;
	sd-=restar;
	valores[i][1]=sd+si;
	valores[i][0]=fd+fi;
  }
}

int main() {
	int N,i,arr[200000],M,a,v;
	scanf("%d",&N);
	for(i=0;i<200001;i++)cant[i]=0;
	for(i=0;i<N;i++) {
      scanf("%d",&arr[i]);
      cant[arr[i]]++;
    }
    segmentTree(N);
    if(valores[0][0]==0&&valores[0][1]==0)printf("TAK\n");
    else printf("NIE\n");
	scanf("%d",&M);
	for(i=0;i<M;i++) {
      scanf("%d",&a);
      scanf("%d",&v);
      a--;
   	  setValor(arr[a],-1);
	  setValor(v,1);
	  arr[a]=v;
      if(valores[0][0]==0&&valores[0][1]==0)printf("TAK\n");
      else printf("NIE\n");
  }
    return 0;
}



*/