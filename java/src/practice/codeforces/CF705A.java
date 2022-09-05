package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/705/A
 * @category adhoc
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF705A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            System.out.println(IntStream.range(0, N).mapToObj(a->(a%2==0?"I hate ":"I love ")+(a<N-1?"that":"it")).collect(Collectors.joining(" ")));
        }
    }
}
