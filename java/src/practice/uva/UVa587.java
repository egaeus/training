package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 587
 * @problemName There's treasure everywhere!
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 11/6/2015
 **/
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
public class UVa587 {
	
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, int[]> moves=new TreeMap<String, int[]>();
		moves.put("N", new int[]{0,1});
		moves.put("S", new int[]{0,-1});
		moves.put("E", new int[]{1,0});
		moves.put("W", new int[]{-1,0});
		moves.put("NW", new int[]{-1,1});
		moves.put("NE", new int[]{1,1});
		moves.put("SE", new int[]{1,-1});
		moves.put("SW", new int[]{-1,-1});
		NumberFormat nf=NumberFormat.getInstance(Locale.US);
		nf.setMaximumFractionDigits(3);
		nf.setMinimumFractionDigits(3);
		nf.setGroupingUsed(false);
		StringBuilder sb = new StringBuilder();
		int c=1;
		for (String ln;!(ln=in.readLine()).equals("END");c++) {
			ln=ln.substring(0, ln.length()-1);
			StringTokenizer st=new StringTokenizer(ln, ",");
			double[] pt=new double[]{0,0};
			for(;st.hasMoreTokens();) {
				ln=st.nextToken();
				char[] arr=ln.toCharArray();
				int i=0;
				for(;i<arr.length;i++)
					if(!Character.isDigit(arr[i]))
						break;
				double steps=parseInt(ln.substring(0, i));
				if(arr.length-i==2)
					steps=sqrt((steps*steps)/2);
				int[] get=moves.get(ln.substring(i));
				pt[0]+=get[0]*steps;
				pt[1]+=get[1]*steps;
			}
			sb.append("Map #").append(c).append("\n");
			sb.append("The treasure is located at (").append(nf.format(pt[0])).append(",").append(nf.format(pt[1])).append(").\n");
			sb.append("The distance to the treasure is ").append(nf.format(sqrt(pt[0]*pt[0]+pt[1]*pt[1]))).append(".\n\n");
		}
		System.out.print(new String(sb));
	}
}
