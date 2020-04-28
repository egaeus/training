package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 152
 * @problemName Tree's a Crowd
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 14/01/2013
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa152{
	static int dist(int[] a,int []b) {
		return (int)floor(sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1])+(a[2]-b[2])*(a[2]-b[2])));
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<int[]> arr=new ArrayList<int[]>(5000);
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int a=parseInt(st.nextToken()),b=parseInt(st.nextToken()),c=parseInt(st.nextToken());
			if(a==0&&b==0&&c==0)break;
			arr.add(new int[]{a,b,c});
		}
		int sol[]=new int[10];
		for(int[] a:arr) {
			int min=12;
			for(int[] b:arr)
				if(a!=b) 
					min=min(min,dist(a,b));
			if(min<10)sol[min]++;
		}
		for(int a:sol) {
			for(int i=(a+"").length();i<4;i++)
				sb.append(" ");
			sb.append(a);
		}
		System.out.println(new String(sb));
	}
}
