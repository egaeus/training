package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 594
 * @problemName One Little, Two Little, Three Little Endians
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 13/06/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa594 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null; ){
			int N = parseInt(ln.trim());
			char[] s = Integer.toString(N, 2).toCharArray();
			boolean[] n = new boolean[32], n2 = new boolean[32];
			for(int i = 31, j = s.length-1; j >= (N<0?1:0); i--, j--)
				n[i]=s[j]=='1';
			if(N<0){
				n[0]=true;
				for(int i = 1; i < n.length; i++)n[i]=!n[i];
				boolean llevo = true;
				for(int i = n.length-1; i >= 1&&llevo; i--){
					boolean tmp = llevo;
					if(llevo&&n[i])llevo=true;
					else llevo = false;
					n[i]^=tmp;
				}
			}
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 8; j++)
					n2[i*8+j]=n[(3-i)*8+j];
			if(n2[0]){
				for(int i = 1; i < n2.length; i++)n2[i]=!n2[i];
				boolean llevo = true;
				for(int i = n2.length-1; i >= 1&&llevo; i--){
					boolean tmp = llevo;
					if(llevo&&n2[i])llevo=true;
					else llevo = false;
					n2[i]^=tmp;
				}
			}
			String sr = "";
			for(int i = 1; i<n2.length; i++)
				sr+=n2[i]?"1":"0";
			int res = parseInt(sr, 2);
			System.out.println(ln.trim() + " converts to " + (n2[0]?"-":"") + (n2[0]&&res==0?MAX_VALUE+1:res));
		}
	}
}
