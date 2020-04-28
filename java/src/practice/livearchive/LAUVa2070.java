package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2070
 * @problemName Simple Encryption
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 02/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2070 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			char[] str=in.readLine().trim().toCharArray();
			int M=str.length/N;
			char[] res=new char[str.length];
			for(int h=0,c=0;c<M*N;h++)for(int j=Math.min(N-1, h),i=Math.max(h-N+1, 0);j>=0&&i<M;j--,i++)res[c++]=str[i*N+j];
			sb.append(new String(res)+"\n");
		}
		System.out.print(new String(sb));
	}
}
