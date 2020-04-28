package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @problemId 2113
 * @problemName It's time for change
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class LAUVa2113 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int[] sol=new int[201];
		int[] monedas=new int[]{1,5,10,25,50};
		sol[0]=1;
		for(int i=0;i<monedas.length;i++)
			for(int j=0;j<sol.length-monedas[i];j++)
				sol[j+monedas[i]]+=sol[j];
		for(double d;(d=parseDouble(in.readLine().trim()))!=0;)
			System.out.printf(Locale.US,"There are "+sol[(int)(d*100)]+" ways to make $%.2f\n",d);
		System.out.printf("End of Output");
	}
}
