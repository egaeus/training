package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId NY10D
 * @problemName Show Me The Fax
 * @judge http://www.spoj.pl
 * @category adhoc
 * @level easy
 * @date 23/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJNY10D {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C; ){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int t = parseInt(st.nextToken()), N = parseInt(st.nextToken());
			int[] arr = new int[N];
			for(int i = 0; i < N;){
				char[] ln = in.readLine().trim().toCharArray();
				for(int j = 0; i < N && j < ln.length; j+=2)
					arr[i++]=parseInt(ln[j]+""+ln[j+1], 16);
			}
			String res = "";
			for(int i = 0; i < arr.length; i++){
				if((arr[i++]>>7)%2==1)
					for(int j = 0; j < (arr[i-1]&127)+3; j++)
						res+=(arr[i]<16?"0":"")+Integer.toString(arr[i], 16).toUpperCase();
				else{
					for(int j = 0, R = (arr[i-1]&127)+1; j < R; j++, i++)
						res+=(arr[i]<16?"0":"")+Integer.toString(arr[i], 16).toUpperCase();	
					i--;
				}
			}
			System.out.println(t + " " + res.length()/2);
			for(;res.length()>=80; res=res.substring(80))
				System.out.println(res.substring(0, 80));
			if(res.length()>0)System.out.println(res);
		}
	}
}
