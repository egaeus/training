package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3003
 * @problemName Jelly
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 06/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3003 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int[] arr=new int[N];
			String nombres[]=new String[N];
			int p=-1,p1=-1;
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				nombres[i]=st.nextToken();
				arr[i]=parseInt(st.nextToken())*parseInt(st.nextToken())*parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					for(int h=0;h<N;h++)
						if(arr[j]!=arr[h]&&arr[i]!=arr[j]&&arr[i]!=arr[h]&&arr[j]+arr[h]==2*arr[i]){p=j;p1=h;break;}
			if(p==-1)System.out.println("No child has lost jelly.");
			else System.out.println((arr[p]<arr[p1]?nombres[p]:nombres[p1])+" has lost jelly to "+(arr[p]>arr[p1]?nombres[p]:nombres[p1])+".");
		}
	}
}
