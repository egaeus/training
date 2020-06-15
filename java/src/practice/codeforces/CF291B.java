package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/291/B>
 * @category strings
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF291B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            char[] s = ln.toCharArray();
            boolean isString = false;
            StringBuilder lexeme = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '"' && isString) {
                    isString = false;
                    sb.append("<").append(new String(lexeme)).append(">\n");
                    lexeme = new StringBuilder();
                } else if (s[i] == '"') {
                    isString = true;
                } else if (s[i] == ' ' && !isString) {
                    if (lexeme.length() > 0) {
                        sb.append("<").append(new String(lexeme)).append(">\n");
                        lexeme = new StringBuilder();
                    }
                } else if (s[i] != ' ' || (s[i] == ' ' && isString))
                    lexeme.append(s[i]);
            }
            if(lexeme.length()>0)
                sb.append("<").append(new String(lexeme)).append(">\n");
            System.out.print(new String(sb));
        }
    }
}
