package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/339/A>
 * @category sorts
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF339A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln,"+");
            ArrayList<Integer> list = new ArrayList<>();
            for(;st.hasMoreTokens();)
                list.add(parseInt(st.nextToken()));
            Collections.sort(list);
            System.out.println(list.stream().map(a->a+"").collect(Collectors.joining("+")));
        }
    }
}
