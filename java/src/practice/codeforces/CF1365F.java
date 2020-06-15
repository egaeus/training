package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1365/F>
 * @category implementation
 * @date 7/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1365F {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] A = new int[N];
            int[] B = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                A[i] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                B[i] = parseInt(st.nextToken());
            TreeMap<int[], Integer> map = new TreeMap<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            if (N % 2 == 0 || (N % 2 == 1 && A[N / 2] == B[N / 2])) {
                for (int i = 0; i < N / 2; i++) {
                    int[] s = new int[]{Math.min(A[i], A[N - i - 1]), Math.max(A[i], A[N - i - 1])};
                    Integer a = map.get(s);
                    if (a == null)
                        a = 0;
                    a++;
                    map.put(s, a);
                }
                boolean ws = true;
                for (int i = 0; i < N / 2 && ws; i++) {
                    int[] s = new int[]{Math.min(B[i], B[N - i - 1]), Math.max(B[i], B[N - i - 1])};
                    if (!map.containsKey(s))
                        ws = false;
                    else {
                        int a = map.get(s);
                        if (a == 1)
                            map.remove(s);
                        else
                            map.put(s, a - 1);
                    }
                }
                System.out.println(ws?"Yes":"No");
            } else System.out.println("No");
        }
    }
}
