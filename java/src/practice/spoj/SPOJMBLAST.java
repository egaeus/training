package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId MBLAST
 * @problemName BLAST
 * @judge http://www.spoj.pl
 * @category dp
 * @level easy
 * @date 30/07/2012
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJMBLAST{
	static char[] a,b;
	static int mem[],c;
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		a=in.readLine().trim().toCharArray();
		b=in.readLine().trim().toCharArray();
		c=parseInt(in.readLine().trim());
		mem=new int[b.length+1];
		for(int i=0;i<b.length;i++)mem[i]=(b.length-i)*c;
		for(int i=a.length-1,s=0,h=0;i>=0;i--) {
			mem[b.length]=(a.length-i)*c;
			h=(a.length-i-1)*c;
			for(int j=b.length-1;j>=0;j--){
				s=mem[j];
				mem[j]=min(abs(a[i]-b[j])+h,min(mem[j],mem[j+1])+c);
				h=s;
			}
		}
		System.out.println(mem[0]);
	}
}
