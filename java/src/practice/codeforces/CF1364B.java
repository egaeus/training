package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1364/B>
 * @category implementation
 * @date 13/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1364B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            int s = 0;
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            int last = arr[0];
            list.add(last);
            for (int i = 1; i < N - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
                    list.add(arr[i]);
                else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                    list.add(arr[i]);
            }
            list.add(arr[N - 1]);
            System.out.println(list.size());
            System.out.println(list.stream().map(a -> a + "").collect(Collectors.joining(" ")));
        }
    }
}
