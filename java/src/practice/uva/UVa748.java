package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 748
 * @problemName Exponentiation
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date Aug 26, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa748 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat nf=(DecimalFormat)DecimalFormat.getInstance(Locale.US);
		nf.setMinimumIntegerDigits(0);
		nf.setMinimumFractionDigits(0);
		nf.setMaximumFractionDigits(10000);
		nf.setMaximumIntegerDigits(10000);
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			BigDecimal n=new BigDecimal(st.nextToken()).pow(parseInt(st.nextToken()));
			sb.append(nf.format(n).replaceAll(",", "")).append("\n");
		}
		System.out.print(new String(sb));
	}
}
