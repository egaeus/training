package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 787
 * @problemName Maximum Sub-sequence Product
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Jun 6, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa787 {
	static class Escaner {
		BufferedReader in;
		StringTokenizer st;
		public Escaner() {
			 in = new BufferedReader(new InputStreamReader(System.in));
			 st=new StringTokenizer("");
		}
		public int nextInt() throws Throwable {
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return nextInt();
		}
		public boolean hasNext() throws Throwable{
			if(st.hasMoreTokens())return true;
			String ln=in.readLine();
			if(ln==null)return false;
			st=new StringTokenizer(ln);
			return hasNext();
		}
	}
	public static void main(String args[]) throws Throwable {
		Escaner sc=new Escaner();
		StringBuilder sb=new StringBuilder();
		for (;sc.hasNext();) {
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int n;(n=sc.nextInt())!=-999999;)
				list.add(n);
			BigInteger[] res=new BigInteger[list.size()+1];
			res[0]=BigInteger.ONE;
			BigInteger max=BigInteger.ZERO;
			boolean[][] zero=new boolean[list.size()][list.size()];
			for(int i=0;i<list.size();i++)
				for(int j=i;j<list.size();j++) {
					boolean ws=false;
					for(int k=i;k<=j&&!ws;k++)ws=list.get(k)==0;
					zero[i][j]=ws;
				}
			for(int i=0;i<list.size();i++) {
				if(list.get(i)==0)list.set(i, 1);
				res[i+1]=res[i].multiply(BigInteger.valueOf(list.get(i)));
				if(max.compareTo(BigInteger.valueOf(list.get(i)))>-1)
					max=BigInteger.valueOf(list.get(i));
			}
			for(int i=1;i<list.size()+1;i++)
				for(int j=i;j<list.size()+1;j++) {
					BigInteger val=!zero[i-1][j-1]?res[j].divide(res[i-1]):BigInteger.ZERO;
					if(val.compareTo(max)>0)max=val;
				}
			sb.append(max+"\n");
		}
		System.out.print(new String(sb));
	}
}
