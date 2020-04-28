package practice.tju; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict R.E.
 * @problemId 1350
 * @problemName Primary Arithmetic
 * @judge http://acm.tju.edu.cn/
 * @category adhoc
 * @level easy
 * @date 26/07/2012
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TJU1350{
	public static void main(String args[]) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;!(ln=in.readLine().trim()).equals("0 0");){
			String []a=ln.split(" +");
			char[] A=a[0].toCharArray(),B=a[1].toCharArray();
			int carry=0,s=0;
			for(int i=0;i<A.length&&i<B.length;i++){
				carry=(carry+(A[A.length-1-i]-'0')+(B[B.length-1-i]-'0'))/10;
				s+=carry;
			}
			System.out.println(s==0?"No carry operation.":s==1?"1 carry operation.":s+" carry operations.");
		}
	}
}
