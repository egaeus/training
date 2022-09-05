package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 941
 * @problemName Permutations
 * @judge http://uva.onlinejudge.org/
 * @category permutations
 * @level medium
 * @date 09/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa941 {
	static char[] kPermutation(char[] arr,long k){
		long f=1;int n=arr.length;
		char[] b=arr.clone(),sol=new char[n];Arrays.sort(b);
		for(int i=1;i<n;i++)f*=i;
		//System.out.println(k+" "+f+" "+k/f);
		for(int i=0,j=n-1;i<n-1;i++,j--) {
			sol[i]=b[(int)(k/f)];
			for(int h=(int)(k/f);h<j;h++)b[h]=b[h+1];
			k=(k%f);f/=j;
		}
		sol[n-1]=b[0];
		return sol;
	}
	/*static long positionPermutation(char[] arr) {
		int n=arr.length;long sol=0,f=1;
		char[] b=arr.clone();
		Arrays.sort(b);
		for(int i=1;i<n;i++)f*=i;
		for(int i=0,j=n-1,bs;i<n-1;i++,j--){
			bs=Arrays.binarySearch(b,0,j+1,arr[i]);
			sol+=f*bs;f/=j;
			for(int h=bs;h<j;h++)b[h]=b[h+1];
		}
		return sol;
	}*/
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			char str[]=in.readLine().trim().toCharArray();
			long n=Long.parseLong(in.readLine().trim());
			sb.append(new String(kPermutation(str,n))+"\n");
		}
		System.out.print(new String(sb));
	}
}
