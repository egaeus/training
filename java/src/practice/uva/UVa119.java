package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 119
 * @problemName Greedy Gift Givers
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 19/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa119 {
	static int pos(String[] arr, String str){
		for(int i=0;i<arr.length;i++)if(arr[i].equals(str))return i;
		return -1;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean primero=true;
		for (String ln;(ln=in.readLine())!=null;) {
			if(!primero)System.out.println();
			primero=false;
			int N=parseInt(ln.trim());
			String[] arr=new String[N];
			int monto[]=new int[N];
			StringTokenizer st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)arr[i]=st.nextToken();
			for(int i=0,p;i<N;i++){
				st=new StringTokenizer(in.readLine());
				p=pos(arr,st.nextToken());
				int V=parseInt(st.nextToken()),M=parseInt(st.nextToken());
				if(M>0){
					monto[p]-=(V/M)*M;
					for(int j=0;j<M;j++)monto[pos(arr,st.nextToken())]+=V/M;
				}
			}
			for(int i=0;i<N;i++)System.out.println(arr[i]+" "+monto[i]);
		}
	}
}
