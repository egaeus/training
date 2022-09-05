
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @problemId 
 * @problemName 
 * @judge http://codeforces.com/
 * @category 
 * @level
 * @date Mon Mar 28 2022
 */

import java.io.*;
import static java.lang.Integer.*;
import java.util.*;

public class A {
  public static void main(String args[]) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (String ln; (ln = in.readLine()) != null;) {
      StringTokenizer st = new StringTokenizer(ln);
      int N = parseInt(st.nextToken());
      for (int n = 0; n < N; n++) {
        int size = parseInt(in.readLine().trim());
        int two = 0;
        int one = 0;
        char[] s = in.readLine().trim().toCharArray();
        for (int i = 0; i < size; i++) {
          if (i > 0 && s[i] == '0' && s[i - 1] == '0')
            two++;
          if (i > 1 && s[i - 2] == '0' && s[i - 1] == '1' && s[i] == '0')
            one++;
        }
        sb.append(two * 2 + one).append("\n");
      }
    }
    System.out.print(new String(sb));
  }
}