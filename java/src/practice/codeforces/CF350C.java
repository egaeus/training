package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 350C
 * @problemName Bombs
 * @judge http://www.codeforces.com
 * @category adhoc
 * @level easy
 * @date Oct 1, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class CF350C {
	static ArrayList<int[]> solution=new ArrayList<int[]>();
	static void f(int x, int y, int xp, int yp) {
		if(x==xp) {
			if(y<yp)
				solution.add(new int[]{1, abs(y-yp), 'U'});
			else
				solution.add(new int[]{1, abs(y-yp), 'D'});
		}
		else if(y==yp) {
			if(x<xp)
				solution.add(new int[]{1, abs(x-xp), 'R'});
			else
				solution.add(new int[]{1, abs(x-xp), 'L'});
		}
		else {
			f(x,y,x,yp);
			f(x,yp,xp,yp);
		}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=parseInt(in.readLine().trim());
		int[][] arr=new int[N][];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int a=parseInt(st.nextToken()),b=parseInt(st.nextToken());
			arr[i]=new int[]{a,b};	
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(abs(o1[0])+abs(o1[1])<abs(o2[0])+abs(o2[1]))
					return -1;
				if(abs(o1[0])+abs(o1[1])<abs(o2[0])+abs(o2[1]))
					return 1;
				if(o1[0]<o2[0])
					return -1;
				if(o1[0]>o2[0])
					return 1;
				return o1[1]<o2[1]?-1:1;
			}
		});
		for(int i=0;i<N;i++) {
			f(0,0,arr[i][0],arr[i][1]);
			solution.add(new int[]{'2'});
			f(arr[i][0],arr[i][1],0,0);
			solution.add(new int[]{'3'});
		}
		sb.append(solution.size()).append("\n");
		for(int[] a:solution) {
			for(int i=0;i<a.length-1;i++)
				sb.append(a[i]).append(" ");
			sb.append((char)a[a.length-1]).append("\n");
		}
		System.out.print(new String(sb));
	}
}
