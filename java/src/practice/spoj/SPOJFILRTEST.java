package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId FILRTEST
 * @problemName File Recovery Testing
 * @judge http://www.spoj.pl
 * @category Stringology
 * @level medium
 * @date 21/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJFILRTEST {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = parseInt(st.nextToken());
			char[] W = st.nextToken().trim().toCharArray();
			if(N==-1 && new String(W).equals("*"))break;
			if(N < W.length)System.out.println(0);
			else{
				int[] arr = getBorderArray(W);
				int may = arr[W.length];
				System.out.println((int)Math.floor(1.*(N-may)/(W.length - may)));
			}			
		}
	}
	static int[] getBorderArray(char[] W) {
		int[] T=new int[W.length+1]; T[0]=-1; T[1]=0;
		for (int i=2,j=0; i<=W.length; )
		{if (W[i-1]==W[j]) T[i++]=++j; else if (j>0) j=T[j]; else T[i++]=0;}
		return T;
	}
}
