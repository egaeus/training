package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10050
 * @problemName Hartals
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10050 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < t; i++) {			
			int n = Integer.parseInt(in.readLine().trim());
			int casos = Integer.parseInt(in.readLine().trim());
			boolean[] arr = new boolean[n+1];			
			for (int j = 0; j < casos; j++) {
				int num = Integer.parseInt(in.readLine().trim());
				if(num<=n&&!arr[num])for (int k = 1; num*k <= n; k++) arr[num*k]=true;
				
			}
			int sum=0;
			for (int j = 0; j <= n; j++)if(arr[j]&&(j+1)%7!=0&&j%7!=0)sum++;
			System.out.println(sum);
		}
	}	
}
