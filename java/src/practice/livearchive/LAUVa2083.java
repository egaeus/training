package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2083
 * @problemName u Calculate e
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 16/11/2011
 **/
import java.text.NumberFormat;
import java.util.Locale;
public class LAUVa2083 {
	public static void main(String[] args) {
		int fact[]=new int[10];
		fact[0]=1;
		for(int i=1;i<10;i++)fact[i]=fact[i-1]*i;
		System.out.println("n e");
		System.out.println("- -----------");
		for(int n=0;n<10;n++){
			double sum=0;
			for(int i=0;i<=n;i++)sum+=1.0/fact[i];
			NumberFormat df=NumberFormat.getInstance(Locale.US);
			df.setMaximumFractionDigits(9);
			System.out.println(n+" "+df.format(sum));;
		}
	}
}
