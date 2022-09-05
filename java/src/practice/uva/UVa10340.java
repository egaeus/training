package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10340
 * @probleName All in all 
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa10340 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = in.readLine();
			if(s==null)break;
			String arr[] = s.trim().split(" +");
			String casa = arr[1];
			int i=0;
			for (i = 0; i < arr[0].length(); i++){
				int j=0;
				String temp = casa;
				for (j = 0; j < casa.length(); j++)
					if(casa.charAt(j)==arr[0].charAt(i)){
						casa = casa.substring(j + 1);
						break;
					}
				if(j==temp.length()){
					System.out.println("No");
					break;
				}
			}	
			if(i==arr[0].length())System.out.println("Yes");
		}
	}	
}
