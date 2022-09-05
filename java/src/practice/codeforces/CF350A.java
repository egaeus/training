package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 350A
 * @problemName TL
 * @judge http://www.codeforces.com
 * @category adhoc
 * @level easy
 * @date Oct 1, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class CF350A {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
		int[] acc=new int[N],wa=new int[M];
		st=new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++)
			acc[i]=parseInt(st.nextToken());
		st=new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++)
			wa[i]=parseInt(st.nextToken());
		Arrays.sort(acc);
		Arrays.sort(wa);
		int sol=-1;
		for(int i=acc[N-1];i<wa[0]&&sol==-1;i++)
			for(int j=0;j<N&&sol==-1;j++)
				if(2*acc[j]<=i)
					sol=i;
		System.out.println(sol);
	}
}
