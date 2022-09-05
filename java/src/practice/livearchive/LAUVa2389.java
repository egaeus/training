package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2389
 * @problemName Palindrom Numbers
 * @judge http://livearchive.onlinejudge.org/
 * @category numbers, chars
 * @level easy
 * @date 09/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2389 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			String n;int arr[]=new int[17],c=0;
			for(int i=2;i<=16;i++)
				if((n=Integer.toString(N, i)).equals(new String(new StringBuffer(n).reverse())))
					arr[c++]=i;
			sb.append("Number "+N+" is ");
			if(c>0){
				sb.append("palindrom in basis");
				for(int i=0;i<c;i++)sb.append(" "+arr[i]);
			}
			else sb.append("not palindrom");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
