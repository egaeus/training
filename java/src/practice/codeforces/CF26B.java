package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/26/B
 * @category strings
 * @date 23/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF26B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            char[] a = ln.toCharArray();
            int sum = a[0]==')'?-1:1;
            int min = sum;
            for(int i=1;i<a.length;i++) {
                sum += a[i]==')'?-1:1;
                min = Math.min(min, sum);
            }
            System.out.println(a.length-Math.abs(min)-sum+min);
        }
    }
}
