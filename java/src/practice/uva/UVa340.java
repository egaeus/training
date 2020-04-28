package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 340
 * @problemName Master-Mind Hints
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 21/03/2012
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa340{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N,caso=1;(N=parseInt(in.readLine().trim()))!=0;caso++){
			int[] arr=new int[N];
			int[] cant=new int[10];
			StringTokenizer st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)cant[(arr[i]=parseInt(st.nextToken()))]++;
			sb.append("Game "+caso+":\n");
			for(int sum=12837;sum!=0;){
				sum=0;int fijos[]=new int[10],cantGuess[]=new int[10];
				st=new StringTokenizer(in.readLine());
				for(int i=0,n;i<N;i++){
					n=parseInt(st.nextToken());
					if(arr[i]==n)fijos[n]++;
					else cantGuess[n]++;
					sum+=n;
				}
				if(sum!=0){
					int f=0,p=0;
					for(int i=1;i<10;i++){
						f+=fijos[i];
						p+=min(cantGuess[i],cant[i]-fijos[i]);
					}
					sb.append("    ("+f+","+p+")\n");
				}
			}
		}
		System.out.print(new String(sb));
	}
}
