package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 386
 * @problemName Perfect Cubes
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/12/2011
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
public class UVa386 {
	static boolean equals(int[] a,int[] b){
		for(int i=0;i<a.length;i++)if(a[i]!=b[i])return false;
		return true;
	}
	public static void main(String args[]) throws Throwable {
		long[] arr=new long[199];
		TreeMap<Long,ArrayList<int[]>> mapa=new TreeMap<Long,ArrayList<int[]>>();
		for(int i=2;i<=200;i++)arr[i-2]=i*i*i;
		for(int i=0;i<arr.length;i++)
			for(int j=i;j<arr.length;j++){
				ArrayList<int[]> s=mapa.get(arr[i]+arr[j]);
				if(s==null)s=new ArrayList<int[]>();
				s.add(new int[]{i+2,j+2});
				mapa.put(arr[i]+arr[j],s);
			}
		int res[][]=new int[10000][],c=1;res[0]=new int[]{0,0,0,0};
		for(int i=0;i<arr.length;i++)
			for(int j=i;j<arr.length;j++){
				ArrayList<int[]> s=mapa.get(arr[j]-arr[i]);
				if(s!=null)
					for(int[] S:s){
						res[c++]=new int[]{j+2,i+2,S[0],S[1]};
						Arrays.sort(res[c-1]);
					}
			}
		Arrays.sort(res,0,c,new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[3]!=o2[3])return o1[3]-o2[3];
				if(o1[0]!=o2[0])return o1[0]-o2[0];
				if(o1[1]!=o2[1])return o1[1]-o2[1];
				return o1[2]-o2[2];
			}
		});
		StringBuilder sb=new StringBuilder();
		for(int i=1,r[];i<c;i++)
			if(!equals(res[i],res[i-1]))sb.append("Cube = "+(r=res[i])[3]+", Triple = ("+r[0]+","+r[1]+","+r[2]+")\n");
		System.out.print(new String(sb));
	}
}
