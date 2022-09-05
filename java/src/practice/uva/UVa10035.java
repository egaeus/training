package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10035
 * @problemName Primary Arithmetic
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa10035 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String st = in.readLine();
			if(st==null)break;
			String s[] = st.trim().split(" +");
			if(s[0].equals("0")&&s[1].equals("0"))break;
			int llevo = 0;
			int cont = 0;
			for (int i = Math.max(s[0].length() - 1, s[1].length() - 1); i >= 0; i--) {
				int pos1 = i - (s[1].length()-s[0].length()<0?0:s[1].length()-s[0].length());
				int pos2 = i - (s[0].length()-s[1].length()<0?0:s[0].length()-s[1].length());
				llevo = ((pos1>=0?(s[0].charAt(pos1)-'0'):0)+(pos2>=0?(s[1].charAt(pos2)-'0'):0) + llevo)/10;				
				if (llevo > 0)
					cont++;
			}
			System.out.println(cont==0?"No carry operation.":(cont==1?cont + " carry operation.":cont + " carry operations."));
		}
	}
}
