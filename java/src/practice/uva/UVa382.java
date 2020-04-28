package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 382
 * @problemName Perfection
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa382 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[]=in.readLine().trim().split(" +");
		System.out.println("PERFECTION OUTPUT");
		for (int i = 0; i < s.length; i++) {
			if(Integer.parseInt(s[i])==0)break;
			int val = sacarNumero(Integer.parseInt(s[i]));
			for (int j = 0; j < 5-s[i].length(); j++)System.out.print(" ");
			System.out.println(s[i] + "  " + (val>Integer.parseInt(s[i])?"ABUNDANT":(val<Integer.parseInt(s[i])?"DEFICIENT":"PERFECT")));
			if(i==s.length-1){
				s=in.readLine().trim().split(" +");
				i=-1;
			}
		}	
		System.out.println("END OF OUTPUT");
	}
	public static int sacarNumero(int x){
		int sum=0;
		for(int i = 1; i <= Math.ceil(x/2); i++)if(x%i==0)sum+=i;
		//System.out.println(sum);
		return sum;
	}
}
