package practice.tju; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 1868
 * @problemName Count the factors
 * @judge http://acm.tju.edu.cn/
 * @category math
 * @level easy
 * @date 30/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TJU1868{
	public static void main(String args[]) throws Throwable{
		int[] arr=new int[1000001];
		arr[0]=arr[1]=0;
		for(int i=2;i<arr.length;i++)
			if(arr[i]==0)
				for(int j=i;j<arr.length;j+=i)arr[j]++;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int n;(n=parseInt(in.readLine().trim()))!=0;){
			sb.append(n);
			sb.append(" : ");
			sb.append(arr[n]);
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
