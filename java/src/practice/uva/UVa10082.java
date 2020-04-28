package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10082
 * @probleName WERTYU
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa10082 {
	public static void main(String[] args) throws IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String r = "`1234567890-=QWERTYUIOP[]"+(char)92+"ASDFGHJKL;'ZXCVBNM,./";
		char c[]= r.toCharArray();		
		while(true){
			String s = in.readLine();
			if(s==null)break;
			char []result = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < c.length; j++) {
					if(s.charAt(i)==' ')result[i]=' ';
					else if(s.charAt(i)==c[j]){
						result[i]=c[j-1];
						break;
					}
				}
			}
			System.out.println(result);
		}	
	}	
}
