package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url
 * @category
 * @date
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1343A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t=0;t<T;t++) {
            long N = parseInt(in.readLine());
            for(int i=2;i<40;i++)
                if(N%((1L<<i)-1) == 0) {
                    System.out.println(N/((1L<<i)-1));
                    break;
                }
        }
    }
}
