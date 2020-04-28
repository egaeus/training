package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10093
 * @problemName An Easy Problem!
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 03/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
public class UVa10093 {
	static BigInteger cambiarBase(char[] a,int b){
		BigInteger p=BigInteger.ONE,res=BigInteger.ZERO;
		for(int i=a.length-1;i>=0;i--)if(Character.isLetterOrDigit(a[i]))res=res.add(p.multiply(BigInteger.valueOf(Arrays.binarySearch(arr,a[i]))));
		return res;
	}
	static char[] arr;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr=new char[62];int j=0;
		for(int i=0;i<10;i++)arr[j++]=(char)('0'+i);
		for(int i=0;i<26;i++)arr[j++]=(char)('A'+i);
		for(int i=0;i<26;i++)arr[j++]=(char)('a'+i);
		for (String ln;(ln=in.readLine())!=null;) {
			char[] ch = ln.trim().toCharArray();
			j=0;
			for (int i=0;i<ch.length;i++)
				if(Character.isLetterOrDigit(ch[i]))j=Math.max(j,Arrays.binarySearch(arr,ch[i]));;
			int max=-1;j=Math.max(j,1);
			for(;j<arr.length&&max==-1;j++)
				if(cambiarBase(ch,j+1).mod(BigInteger.valueOf(j)).equals(BigInteger.ZERO))max=j;					
			System.out.println(max>=0?max+1:"such number is impossible!");
		}
	}
}
