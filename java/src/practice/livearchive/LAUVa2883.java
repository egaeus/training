package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2883
 * @problemName 2883
 * @judge http://livearchive.onlinejudge.org/
 * @category memorization
 * @level easy
 * @date 23/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class LAUVa2883 {
	static Comparator<int[]> comp=new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return o1[0]!=o2[0]?o1[0]-o2[0]:(o1[1]-o2[1]);
		}
	};
	static class Nodo implements Comparable<Nodo> {
		int[] posH;int c;
		TreeSet<int[]> posP;
		Nodo(int[] posH,TreeSet<int[]> posP, int c){
			this.posH=posH.clone();
			this.posP=new TreeSet<int[]>(comp);
			for(int[] p:posP)this.posP.add(p.clone());
			this.c=c;
		}
		public String toString(){
			String res="H: "+Arrays.toString(posH)+" P:";
			for(int[] p:posP)res+=" "+Arrays.toString(p);
			return res+=" Pasos: "+c;
		}
		public int compareTo(Nodo o2) {
			Nodo o1=this;
			if(o1.posH[0]!=o2.posH[0])return o1.posH[0]-o2.posH[0];
			if(o1.posH[1]!=o2.posH[1])return o1.posH[1]-o2.posH[1];
			if(o1.posP.size()!=o2.posP.size())return o1.posP.size()-o2.posP.size();
			Object[] ob1=o1.posP.toArray(),ob2=o2.posP.toArray();
			for(int i=0;i<ob1.length;i++){
				int a1[]=(int[])ob1[i],a2[]=(int[])ob2[i];
				if(a1[0]!=a2[0])return a1[0]-a2[0];
				if(a1[1]!=a2[1])return a1[1]-a2[1];
			}
			return 0;
		}
	}
	static TreeMap<Nodo,Integer> vis;
	static int[][] mov=new int[][]{{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}};
	static ArrayList<Nodo> getMovimientos(Nodo p){
		ArrayList<Nodo> res=new ArrayList<Nodo>(8);
		for(int i=0;i<mov.length;i++)
			if(p.posH[0]+mov[i][0]>=0&&p.posH[0]+mov[i][0]<8&&p.posH[1]+mov[i][1]>=0&&p.posH[1]+mov[i][1]<8){
				boolean ws=p.posP.contains(new int[]{p.posH[0]+mov[i][0],p.posH[1]+mov[i][1]}),ws1=true;
				p.posP.remove(new int[]{p.posH[0]+mov[i][0],p.posH[1]+mov[i][1]});
				for(int h[]:p.posP){
					h[0]++;
					if(h[0]>8)ws1=false;
				}
				if(ws1)res.add(new Nodo(new int[]{p.posH[0]+mov[i][0],p.posH[1]+mov[i][1]}, p.posP, p.c+1));
				for(int h[]:p.posP)h[0]--;
				if(ws)p.posP.add(new int[]{p.posH[0]+mov[i][0],p.posH[1]+mov[i][1]});
			}
		return res;
	}
	static int min(Nodo p){
		if(vis.containsKey(p))return vis.get(p);
		if(p.posP.size()==0)return 0;
		ArrayList<Nodo> m=getMovimientos(p);
		int min=MAX_VALUE-1000000;
		for(int i=0,n=m.size();i<n;i++)
			min=Math.min(min,min(m.get(i))+1);
		vis.put(p,min);
		return min;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		vis=new TreeMap<Nodo,Integer>();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int P=parseInt(st.nextToken()),H;
			if(P==0)break;
			TreeSet<int[]> posP=new TreeSet<int[]>(comp);
			for(int i=0,h;i<P;i++)posP.add(new int[]{(h=parseInt(st.nextToken())-1)/8,h%8});
			Nodo ini=new Nodo(new int[]{(H=parseInt(st.nextToken())-1)/8,H%8}, posP, 0);
			System.out.println(min(ini)<MAX_VALUE-1000000?min(ini):"impossible");
		}
	}
}

