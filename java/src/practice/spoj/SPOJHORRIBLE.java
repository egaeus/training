package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId HORRIBLE
 * @problemName Horrible Queries
 * @judge http://www.spoj.pl
 * @category segment-tree
 * @level easy
 * @date Nov 6, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJHORRIBLE {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			long[] arr=new long[N];			
			SegmentTreeLazy stl=SegmentTreeLazy.init(arr);
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(in.readLine());
				int op=parseInt(st.nextToken()),A=parseInt(st.nextToken())-1,B=parseInt(st.nextToken());
				if(op==0) {
					stl.set(A, B, parseInt(st.nextToken()));
				} else
					sb.append(stl.get(A, B)).append("\n");
			}
		}
		System.out.print(new String(sb));
	}
	static class SegmentTreeLazy {
		private long setValue;
		private boolean flag;
		private long value;
		private int cotaDesde, cotaHasta;
		private SegmentTreeLazy izq,der;
		public SegmentTreeLazy() {
		}
		static int pasos=0;
		private static long[] vals;
		public static SegmentTreeLazy init(long[] vals) {
			SegmentTreeLazy.vals=vals;
			return init(0,vals.length);
		}
		private static SegmentTreeLazy init(int desde, int hasta) {
			if(hasta<=desde)
				return null;
			SegmentTreeLazy result=new SegmentTreeLazy();
			result.cotaDesde=desde;
			result.cotaHasta=hasta;
			if(hasta-desde==1)
				result.value=vals[desde];
			else {
				SegmentTreeLazy izq=init(desde,(hasta+desde)/2);
				SegmentTreeLazy der=init((hasta+desde)/2, hasta);
				result.izq=izq;
				result.der=der;
				//CHANGE FUNCTION
				result.value=(izq==null?0:izq.value)+(der==null?0:der.value);
			}
			return result;
		}
		public long set(int desde, int hasta, long newValue) {
			if(flag)
				propagar(setValue);
			if(desde==cotaDesde&&hasta==cotaHasta) {
				propagar(newValue);
			}
			else {
				if(izq!=null&&izq.cotaDesde<=desde&&izq.cotaHasta>=hasta) {
					//CHANGE FUNCTION
					value=izq.set(desde, hasta, newValue)+der.get(der.cotaDesde, der.cotaHasta);
				}
				else if(der!=null&&der.cotaDesde<=desde&&der.cotaHasta>=hasta) {
					//CHANGE FUNCTION
					value=der.set(desde, hasta, newValue)+izq.get(izq.cotaDesde, izq.cotaHasta);
				}
				else {
					//CHANGE FUNCTION
					value=izq.set(desde, izq.cotaHasta, newValue)+der.set(der.cotaDesde, hasta, newValue);
				}
			}
			return value;
		}
		public void propagar(long propValue) {
			flag=false;
			setValue=0;
			//CHANGE FUNCTION
			value=propValue*(cotaHasta-cotaDesde);
			if(izq!=null) {
				izq.flag=true;
				izq.setValue=propValue;
			}
			if(der!=null) {
				der.flag=true;
				der.setValue=propValue;
			}
		}
		public long get(int desde, int hasta) {
			pasos++;
			if(flag) 
				propagar(setValue);
			if(desde==cotaDesde&&hasta==cotaHasta) 
				return value;
			if(izq!=null&&izq.cotaDesde<=desde&&izq.cotaHasta>=hasta) 
				return izq.get(desde, hasta);
			else if(der!=null&&der.cotaDesde<=desde&&der.cotaHasta>=hasta)
				return der.get(desde, hasta);
			else {
				//CHANGE FUNCTION
				return izq.get(desde, izq.cotaHasta)+der.get(der.cotaDesde, hasta);
			}
		}
		
		@Override
		public String toString() {
			return toString(0);
		}
		
		private String toString(int level) {
			String str="";
			for(int i=0;i<level;i++)
				str+="\t";
			str+=cotaDesde+" - "+cotaHasta+": -- "+value+" -> "+flag+" - "+setValue+"\n";
			if(izq!=null) 
				str+=izq.toString(level+1);
			if(der!=null)
				str+=der.toString(level+1);
			return str;
		}
	}
}
