package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2390
 * @problemName Robotic Jigsaw
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level medium
 * @date 11/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVa2390 {
	static class Pieza{
		int valor;
		Pieza[] piezas;
		Pieza(int valor){
			this.valor=valor;
			piezas=new Pieza[4];
		}
		void setPieza(Pieza p, int pos, int pos1){
			piezas[pos]=p;
			p.piezas[pos1]=this;
			//System.out.println(valor + " " + pos + " " + p.valor + " " + pos1);
			if(piezas[(pos+1)%4]!=null){
				int i=0;
				for(;i<4;i++)if(piezas[(pos+1)%4].piezas[i]==this)break;
				if(piezas[(pos+1)%4].piezas[(i+1)%4]!=null){
					int j=0;
					for(;j<4;j++)if(piezas[(pos+1)%4].piezas[(i+1)%4].piezas[j]==piezas[(pos+1)%4])break;
		//			System.out.println("\t1.");
					if(piezas[(pos+1)%4].piezas[(i+1)%4].piezas[(j+1)%4]==null)
						p.setPieza(piezas[(pos+1)%4].piezas[(i+1)%4],(pos1+3)%4,(j+1)%4);
				}			
			}
		//	System.out.println(valor + " " + pos + " " + p.valor + " " + pos1);
			if(piezas[(pos+3)%4]!=null){
				int i=0;
				for(;i<4;i++)if(piezas[(pos+3)%4].piezas[i]==this)break;
				if(piezas[(pos+3)%4].piezas[(i+3)%4]!=null){
					int j=0;
					for(;j<4;j++)if(piezas[(pos+3)%4].piezas[(i+3)%4].piezas[j]==piezas[(pos+3)%4])break;
		//			System.out.println("\t2."+i+" "+j+" "+practice.livearchive.LAUVa2390.toString(piezas[(pos+3)%4].piezas[(i+3)%4]));
					if(piezas[(pos+3)%4].piezas[(i+3)%4].piezas[(j+3)%4]==null)
						p.setPieza(piezas[(pos+3)%4].piezas[(i+3)%4],(pos1+1)%4,(j+3)%4);
				}				
			}
		//	System.out.println(valor + " " + pos + " " + p.valor + " " + pos1);
			/**/
			if(p.piezas[(pos1+1)%4]!=null){
				int i=0;
				for(;i<4;i++)if(p.piezas[(pos1+1)%4].piezas[i]==p)break;
				if(p.piezas[(pos1+1)%4].piezas[(i+1)%4]!=null){
					int j=0;
					for(;j<4;j++)if(p.piezas[(pos1+1)%4].piezas[(i+1)%4].piezas[j]==p.piezas[(pos1+1)%4])break;
	//				System.out.println("\t3."+i+" "+j+" "+p.piezas[(pos1+1)%4].valor);
					if(p.piezas[(pos1+1)%4].piezas[(i+1)%4].piezas[(j+1)%4]==null)
						setPieza(p.piezas[(pos1+1)%4].piezas[(i+1)%4],(pos+3)%4,(j+1)%4);
				}			
			}
	//		System.out.println(valor + " " + pos + " " + p.valor + " " + pos1);
			if(p.piezas[(pos1+3)%4]!=null){
				int i=0;
				for(;i<4;i++)if(p.piezas[(pos1+3)%4].piezas[i]==p)break;
				if(p.piezas[(pos1+3)%4].piezas[(i+3)%4]!=null){
					int j=0;
					for(;j<4;j++)if(p.piezas[(pos1+3)%4].piezas[(i+3)%4].piezas[j]==p.piezas[(pos1+3)%4])break;
	//				System.out.println("\t4.");
					if(p.piezas[(pos1+3)%4].piezas[(i+3)%4].piezas[(j+3)%4]==null)
						setPieza(p.piezas[(pos1+3)%4].piezas[(i+3)%4],(pos+1)%4,(j+3)%4);
				}			
			}
	//		System.out.println(valor + " " + pos + " " + p.valor + " " + pos1);
			if(piezas[(pos+1)%4]!=null&&p.piezas[(pos1+3)%4]!=null){
				int i=0,j=0;
				for(;i<4;i++)if(piezas[(pos+1)%4].piezas[i]==this)break;
				for(;j<4;j++)if(p.piezas[(pos1+3)%4].piezas[j]==p)break;
		//		System.out.println("\t5."+pos+ " "+pos1+" "+i + " " + j + " " + valor + " " + p.valor);
				if(piezas[(pos+1)%4].piezas[(i+1)%4]==null&&p.piezas[(pos1+3)%4].piezas[(j+3)%4]==null)
					piezas[(pos+1)%4].setPieza(p.piezas[(pos1+3)%4],(i+1)%4,(j+3)%4);
			}
	//		System.out.println(valor + " " + pos + " " + p.valor + " " + pos1);
			if(piezas[(pos+3)%4]!=null&&p.piezas[(pos1+1)%4]!=null){
				int i=0,j=0;
				for(;i<4;i++)if(piezas[(pos+3)%4].piezas[i]==this)break;
				for(;j<4;j++)if(p.piezas[(pos1+1)%4].piezas[j]==p)break;
//				System.out.println("\t6."+pos+ " "+pos1+" "+i + " " + j + " " + valor + " " + p.valor);
				if(piezas[(pos+3)%4].piezas[(i+3)%4]==null&&p.piezas[(pos1+1)%4].piezas[(j+1)%4]==null)
					piezas[(pos+3)%4].setPieza(p.piezas[(pos1+1)%4],(i+3)%4,(j+1)%4);
			}
		}
	}
	static String toString(Pieza p){
		if(p==null)return "null";
		return p.valor+"";
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int N=parseInt(st.nextToken());
			if(N==0)break;
			int K=parseInt(st.nextToken());
			Pieza[] piezas=new Pieza[N];
			for(int i=0;i<N;i++)piezas[i]=new Pieza(i);
			for(int h=0;h<K;h++){
				st=new StringTokenizer(in.readLine());
				int s=parseInt(st.nextToken()),ns=parseInt(st.nextToken()),d=parseInt(st.nextToken()),ds=parseInt(st.nextToken());
				piezas[s].setPieza(piezas[d], ns, ds);
			}
			LinkedList<LinkedList<int[]>> res=new LinkedList<LinkedList<int[]>>();
			int abajo=0,v=0;
			for(Pieza p=piezas[0];p!=null;p=p.piezas[abajo]){
				res.add(new LinkedList<int[]>());
				llenar(res.getLast(),p,v);
				int i=0;
				if(p.piezas[v]!=null)for(;i<4;i++)if(p.piezas[v].piezas[i]==p)break;
				abajo=v;
				v=(i+2)%4;
			}
			abajo=0;v=0;
			for(Pieza p=piezas[0];p!=null;p=p.piezas[(abajo+2)%4]){
				if(p!=piezas[0]){res.addFirst(new LinkedList<int[]>());llenar(res.getFirst(),p,v);}
				int i=0;
				if(p.piezas[(v+2)%4]!=null)for(;i<4;i++)if(p.piezas[(v+2)%4].piezas[i]==p)break;
				abajo=v;
				v=i;
			}
			TreeMap<String,String> map=new TreeMap<String, String>();
			int i=0,j=0;
			for(LinkedList<int[]> Q:res){
				j=0;
				for(int[] P:Q){
					String s="",s1="";
					for(int h=(i+"").length();h<5;h++)s+=" ";
					s+=i;
					for(int h=(j+"").length();h<5;h++)s+=" ";
					s+=j;
					for(int h=(P[0]+"").length();h<6;h++)s1+=" ";
					s1+=P[0]+" "+P[1];
					j++;
					map.put(i+" "+j,s+s1);
				}
				i++;
			}
			sb.append("Instance "+caso+":\n");
			for(Entry<String,String> entry:map.entrySet())sb.append(entry.getValue()+"\n");
		}
		System.out.print(new String(sb));
	}
	static void llenar(LinkedList<int[]> r, Pieza p, int vAbajo){
		int v=vAbajo,x=vAbajo;
		for(Pieza m=p;m!=null;m=m.piezas[(x+1)%4]){
			r.add(new int[]{m.valor,v});
			int i=0;
			if(m.piezas[(v+1)%4]!=null)for(;i<4;i++)if(m.piezas[(v+1)%4].piezas[i]==m)break;
			x=v;
			v=(i+1)%4;
		}
		v=vAbajo;x=vAbajo;
		for(Pieza m=p;m!=null;m=m.piezas[(x+3)%4]){
			if(m!=p)r.addFirst(new int[]{m.valor,v});
			int i=0;
			if(m.piezas[(v+3)%4]!=null)for(;i<4;i++)if(m.piezas[(v+3)%4].piezas[i]==m)break;
			x=v;
			v=(i+3)%4;
		}
	}
}
