package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 576
 * @problemName Haiku Review
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 21/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa576 {
	static int getSilabas(String str){
		if(str.trim().length() == 0)return 0;
		return getSilabas(str.replaceFirst("[^aeiouy]*[aeiouy]+[^aeiouy]*", "").trim()) + 1;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; ){
			String[] arr = ln.split("/");
			if(arr[0].equals("e")&&arr[1].equals("o")&&arr[2].equals("i"))break;
			if(getSilabas(arr[0]) != 5)System.out.println(1);
			else if(getSilabas(arr[1]) != 7)System.out.println(2);
			else if(getSilabas(arr[2]) != 5)System.out.println(3);
			else System.out.println("Y");
		}
	}
}
