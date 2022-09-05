package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10100
 * @problemName Longest Match
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 16/03/2011
 **/
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10100 {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		for(String str1; (str1=in.readLine())!=null; caso++){
			sb.append((caso<10?" ":"") + caso + ". ");
			String str2 = in.readLine();
			if(str1.length()==0||str2.length()==0)
				sb.append("Blank!\n");
			else{
				String[] arr1 = str1.trim().replaceAll("[^a-zA-z0-9]", " ").split(" +");
				String[] arr2 = str2.trim().replaceAll("[^a-zA-z0-9]", " ").split(" +");
				int[][] dp = new int[arr1.length+1][arr2.length+1];
				for(int i = arr1.length-1; i>=0; i--)
					for(int j = arr2.length-1; j>=0; j--){
						dp[i][j] = max(dp[i+1][j], dp[i][j+1]);
						if(!arr1[i].equals("")&&!arr2[j].equals("")&&arr1[i].equals(arr2[j]))dp[i][j]=max(dp[i][j],dp[i+1][j+1]+1);
					}
				sb.append("Length of longest match: " + dp[0][0] + "\n");
			}
		}
		System.out.print(new String(sb));
	}
}
