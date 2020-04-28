package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3055
 * @problemName Symmetric Order
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 26/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa3055{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++){
			String[] arr=new String[N],res=new String[N];
			for(int i=0;i<N;i++)
				arr[i]=in.readLine();
			for(int i=0;i<N/2;i++){
				res[i]=arr[2*i];
				res[arr.length-1-i]=arr[2*i+1];
			}
			if(N%2==1)res[N/2]=arr[N-1];
			sb.append("SET "+c+"\n");
			for(String s:res)
				sb.append(s+"\n");
		}
		System.out.print(new String(sb));
	}
}
