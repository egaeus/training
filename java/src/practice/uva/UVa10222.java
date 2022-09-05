package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10222
 * @problemName Decode the Mad man
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 13/12/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10222 {
	public static void main(String[] args) throws Throwable{
		char[][] mat=new char[][]{
				/*"1234567890-=".toCharArray(),*/
				"qwertyuiop[]\\".toCharArray(),
				"asdfghjkl;'".toCharArray(),
				"zxcvbnm,./".toCharArray()
		};
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			char[] str=ln.toLowerCase().toCharArray();
			for(int i=0;i<str.length;i++){
				boolean ws=false;
				for(int j=0;j<mat.length&&!ws;j++)
					for(int h=0;h<mat[j].length&&!ws;h++)
						if(ws=mat[j][h]==str[i])sb.append(mat[j][h-2]);
				if(!ws)sb.append(str[i]);	
			}
			sb.append("\n");
		}
		System.out.print(new String(sb)); 
	}
}
