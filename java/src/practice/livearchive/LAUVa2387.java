package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2387
 * @problemName Gene Assembly
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 10/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVa2387 {
	static int arr[][], mem[][];
	static Comparator<int[]> comp=new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return o1[0]!=o2[0]?o1[0]-o2[0]:(o1[1]-o2[1]);
		}
	};
	static int function(int i){
		if(i==arr.length)return 0;
		if(mem[i]!=null)return mem[i][0];
		int res=function(i+1),bs=Arrays.binarySearch(arr,new int[]{arr[i][1]+1,0},comp);
		mem[i]=new int[]{res,i+1};
		if(bs<0)bs=-bs-1;
		if(function(bs)+1>res){
			res=function(bs)+1;
			mem[i]=new int[]{res,bs};
		}
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			arr=new int[N][];mem=new int[N][];
			TreeMap<int[],Integer> set=new TreeMap<int[], Integer>(comp);
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
				set.put(arr[i], i+1);
			}
			Arrays.sort(arr,comp);int s=0,n=function(0),r=n;
			for(;mem[s][0]!=1;s=mem[s][1])
				if(mem[mem[s][1]][0]<n)sb.append((n--<r?" ":"")+set.get(arr[s]));
			sb.append((n<r?" ":""+"")+set.get(arr[s])+"\n");
		}
		System.out.print(new String(sb));
	}
}
