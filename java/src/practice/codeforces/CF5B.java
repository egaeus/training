package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/5/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF5B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int max = 0;
        for (String ln; (ln = in.readLine()) != null; ) {
            list.add(ln);
            max = Math.max(max, ln.length());
        }
        char[][] result = new char[list.size() + 2][max + 2];
        int r = 0;
        for (char[] a : result)
            Arrays.fill(a, ' ');
        for (int i = 0; i < result.length; i++)
            result[i][0] = result[i][result[0].length - 1] = '*';
        for (int i = 0; i < result[0].length; i++)
            result[0][i] = result[result.length - 1][i] = '*';
        for (int i = 0; i < list.size(); i++) {
            char[] s = list.get(i).toCharArray();
            double v = (result[i].length - s.length) / 2.;
            int spaces = (int) (r % 2 == 1 ? Math.ceil(v) : Math.floor(v));
            if ((result[i].length - s.length) % 2 != 0)
                r++;
            for (int j = 0; j < s.length; j++)
                result[i + 1][j + spaces] = s[j];
        }
        StringBuilder sb = new StringBuilder();
        for (char[] a : result)
            sb.append(new String(a)).append("\n");
        System.out.print(new String(sb));
    }
}
