package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 5739
 * @problemName User Names
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Aug 21, 2013
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa5739 {
	public static String append(String n,int c,int max) {
		if(c==0)return n;
		String s=n;
		if(c<10) {
			if(n.length()==max)
				s=n.substring(0, max-1);
		}
		else {
			if(n.length()>=max-1)
				s=n.substring(0, max-2);
		}
		return s+c;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso=1;
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++) {
			int N=parseInt(st.nextToken()),max=parseInt(st.nextToken());
			if(N==0&&max==0)break;
			sb.append("Case ").append(caso).append("\n");
			TreeSet<String> set=new TreeSet<String>();
			for(int i=0;i<N;i++) {
				String name=in.readLine().trim().replaceAll("['-]", "").toLowerCase();
				String[] arr=name.split(" +");
				String n=arr[0].charAt(0)+"";
				n+=arr[arr.length-1].substring(0,min(arr[arr.length-1].length(),max-1));
				for(int j=0;;j++) {
					String sol=append(n, j, max);
					if(!set.contains(sol)) {
						n=sol;
						set.add(sol);
						break;
					}
				}
				sb.append(n).append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
