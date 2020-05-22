package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1342/B>
 * @category strings
 * @date 27/04/2012
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1342B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t++<T;) {
            String str = in.readLine();
            if(str.contains("0")&&str.contains("1")) {
                for(char a: str.toCharArray())
                    if(a == '0')
                        sb.append("1"+a);
                    else
                        sb.append(a+"0");
            }
            else
                sb.append(str);
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
