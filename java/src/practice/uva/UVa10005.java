package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 10005
 * @problemName Packing polygons
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level ???
 * @date 09/11/2011
 **/
import static java.lang.Double.parseDouble;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10005 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=(int)parseDouble(in.readLine().trim()))!=0;){
			Point2D[] arr=new Point2D[N];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				arr[i]=new Point2D.Double(parseDouble(st.nextToken()), parseDouble(st.nextToken()));
			}
			double max=0;
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++)
					max=Math.max(arr[i].distance(arr[j]),max);
			double R=parseDouble(in.readLine().trim());
			System.out.println(2*R-max>-1e-5?"The polygon can be packed in the circle.":"There is no way of packing that polygon.");
		}
	}
}
