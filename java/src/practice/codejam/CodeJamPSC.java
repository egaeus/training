package practice.codejam;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codingcompetitions.withgoogle.com/codejam/round/0000000000000130/0000000000000524
 * @category implementation
 * @date March, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CodeJamPSC {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(": ");
            StringTokenizer st = new StringTokenizer(in.readLine());
            int D=parseInt(st.nextToken()), K=parseInt(st.nextToken());
            double max = 0;
            for(int i=0;i<K;i++) {
                st=new StringTokenizer(in.readLine());
                double v=1.*(D-parseInt(st.nextToken()))/parseInt(st.nextToken());
                max=Math.max(max, v);
            }
            NumberFormat decimalFormat=DecimalFormat.getInstance(Locale.US);
            decimalFormat.setMaximumFractionDigits(10);
            decimalFormat.setMinimumFractionDigits(10);
            decimalFormat.setGroupingUsed(false);
            sb.append(decimalFormat.format(D/max));
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
