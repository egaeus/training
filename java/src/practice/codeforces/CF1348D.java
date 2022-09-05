package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1348/D>
 * @category math
 * @date 01/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.*;

public class CF1348D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] days = new int[toBinaryString(N).length()];
            int[] nights = new int[days.length - 1];
            days[0] = 1;
            N -= 1;
            for (int i = 1; i < days.length; i++) {
                days[i] = Math.min(days[i - 1] * 2, N / (days.length - i));
                N -= days[i];
                nights[i-1] = days[i] - days[i-1];
            }
            sb.append(nights.length).append("\n");
            sb.append(IntStream.of(nights).mapToObj(a -> a +"").collect(Collectors.joining(" "))).append("\n");
        }
        System.out.print(new String(sb));
    }
}
