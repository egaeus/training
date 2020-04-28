package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5505
 * @problemName Deck
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 22/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;
public class LAUVa5505 {
	public static void main(String[] args) throws Throwable{
		double[] arr=new double[100000];
		for(int i=1;i<100000;i++)arr[i]=arr[i-1]+(1./(2*i));
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		sb.append("# Cards Overhang\n");
		for(String ln;(ln=in.readLine())!=null;){
			int N=parseInt(ln.trim());
			for(int i=(N+"").length();i<5;i++)sb.append(" ");
			sb.append(N);
			NumberFormat nf=NumberFormat.getInstance(Locale.US);
			nf.setMinimumIntegerDigits(1);
			nf.setMaximumFractionDigits(3);
			nf.setMinimumFractionDigits(3);
			String s=nf.format(arr[N]);
			for(int i=s.length();i<10;i++)sb.append(" ");
			sb.append(s+"\n");
		}
		System.out.print(new String(sb));	
	}
}
