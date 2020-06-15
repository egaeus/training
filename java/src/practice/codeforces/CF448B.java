package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/448/B>
 * @category strings
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF448B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] S = ln.toCharArray();
            char[] T = in.readLine().toCharArray();
            int[] qs = new int[26];
            int[] qt = new int[26];
            for (char a : S)
                qs[a - 'a']++;
            for (char b : T)
                qt[b - 'a']++;
            boolean ws1 = false;
            for (int i = 0, j = 0; i < S.length && j < T.length; i++)
                if (S[i] == T[j]) {
                    j++;
                    if (j == T.length) ws1 = true;
                }
            boolean ws = true;
            for (int i = 0; i < 26; i++)
                if (qt[i] > qs[i])
                    ws = false;
            if (ws1)
                System.out.println("automaton");
            else if (ws && S.length == T.length)
                System.out.println("array");
            else if (ws)
                System.out.println("both");
            else
                System.out.println("need tree");
        }
    }
}
