package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ACODE
 * @problemName Last Digit
 * @judge http://www.spoj.pl
 * @category dp
 * @level easy
 * @date 21/02/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJACODE {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; !(ln = in.readLine().trim()).equals("0");){
			char[] arr = ln.toCharArray();
			long mem[] = new long[arr.length + 1];
			mem[arr.length - 1] = arr[arr.length-1]!='0'?1:0;
			mem[arr.length] = 1;
			for(int i = arr.length - 2; i >= 0; i--)
				if(arr[i]!='0'){
					mem[i]+=mem[i+1];
					if((arr[i]-'0')*10+arr[i+1]-'0'<=26)mem[i]+=mem[i+2];
				}
			System.out.println(mem[0]);
		}
	}
}
