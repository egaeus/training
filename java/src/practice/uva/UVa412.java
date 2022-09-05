package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 412
 * @problemName Pi
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 15/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa412 {
	static int mcd(int a, int b){
		if(a%b==0)return b;
		return mcd(b, a%b);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int arr[] = new int[N], cant = 0;
			for(int i=0;i<N;i++)arr[i]=parseInt(in.readLine().trim());
			for(int i=0;i<N;i++)for(int j=i+1;j<N;j++)if(mcd(arr[i],arr[j])==1)cant++;
			System.out.printf(Locale.US, cant==0?"No estimate for this data set.%n":"%f%n",Math.sqrt(6./(1.*cant/((N*(N-1))/2))));
		}
	}
}
