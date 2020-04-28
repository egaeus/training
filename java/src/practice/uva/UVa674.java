package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 674
 * @problemName Coin Change
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa674 {
    public static void main(String[] args) throws Throwable{
        int[] valores = new int[]{50, 25, 10, 5, 1};
        long res[] = new long[30001];
        res[0] = 1;
        for (int i = 0; i < valores.length; i++)
            for (int j = valores[i]; j < res.length; j++)
                res[j] += res[j - valores[i]];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine())!=null; )
            System.out.println(res[Integer.parseInt(ln.trim())]);
    }
}