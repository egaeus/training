package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1355/D
 * @category math, implementation
 * @date 16/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1355D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), S = parseInt(st.nextToken()), O = S;
            int[] result = new int[N];
            int i = 0;
            boolean ws = true;
            for (; i < N - 1 && O / (N - i) > 2; i++) {
                result[i] = 2;
                O -= 2;
            }
            for (; i < N - 1; i++) {
                result[i] = O / (N - i);
                O -= result[i];
                if (result[i] == 1) ws = false;
            }
            result[i] = O;
            if(result[i]==1)ws = false;
            sb.append(ws?"yes":"no").append("\n");
            if(ws){
                sb.append(IntStream.of(result).mapToObj(a -> a+"").collect(Collectors.joining(" "))).append("\n");
                sb.append(1).append("\n");
            }
        }
        System.out.print(new String(sb));
    }
}
