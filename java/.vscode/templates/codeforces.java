/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @problemId ${fileBasenameNoExtension##find=^CF##replace=##}
 * @problemName ${input:Problem name:}
 * @judge http://codeforces.com/
 * @category ${input:Categoty:}
 * @level ${input:Level:}
 * @date ${date}
 */

import java.io.*;
import static java.lang.Integer.*;
import java.util.*;

public class ${fileBasenameNoExtension} {
  public static void main(String args[]) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for(String ln; (ln = in.readLine()) != null; ) {
      StringTokenizer st = new StringTokenizer(ln);
      int N = parseInt(st.nextToken());
    }
    System.out.print(new String(sb));
  }
}