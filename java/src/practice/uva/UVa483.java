package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 483
 * @problemName Word Scramble 
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa483 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean caso=true;
		while(true){
			String n=in.readLine();
			if(n==null)break;
			String arr[] = n.trim().split(" +");
			for (int i = 0; i < arr.length; i++) System.out.print(new StringBuffer(arr[i]).reverse().toString() + (arr.length-1==i?"":" "));
			System.out.println();
		}
	}
}
