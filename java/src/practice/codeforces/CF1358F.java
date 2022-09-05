package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1358/F>
 * @category implementation
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1358F {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            int N = parseInt(ln);
            long[] A = new long[N];
            long[] B = new long[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
                B[i] = Long.parseLong(st1.nextToken());
            }
            if (N == 1) {
                sb.append(A[0] == B[0] ? "SMALL" : "IMPOSSIBLE").append("\n");
                if (A[0] == B[0])
                    sb.append(0).append("\n").append("\n");
            } else if (N == 2) {
                ArrayList<Long> list = new ArrayList<>();
                boolean reverseA = A[0] > A[1];
                boolean reverseB = B[0] > B[1];
                long c = 0;
                boolean possible = true;
                Arrays.sort(A);
                Arrays.sort(B);
                while (possible) {
                    if (A[0] == B[0])
                        if ((B[1] - A[1]) % A[0] != 0)
                            possible = false;
                        else {
                            list.add((B[1] - A[1]) / A[0]);
                            c += (B[1] - A[1]) / A[0];
                            break;
                        }
                    if (B[0] > 0) {
                        list.add(B[1] / B[0]);
                        c += B[1] / B[0];
                        B = new long[]{B[0], B[1] % B[0]};
                        B = new long[]{B[1] % B[0], B[0]};
                    } else possible = false;
                }
                if (possible) {
                    if (c <= 200000) {
                        sb.append("SMALL\n");
                        c += (reverseA ? 1 : 0) + (reverseB ? 1 : 0) + list.size() - 1;
                        sb.append(c).append("\n");
                        if (reverseA)
                            sb.append("R");
                        for (int i = list.size() - 1; i >= 0; i--) {
                            sb.append(LongStream.range(0, list.get(i)).mapToObj(a -> "P").collect(Collectors.joining()));
                            if (i > 0)
                                sb.append("R");
                        }
                        if (reverseB)
                            sb.append("R");
                        sb.append("\n");
                    } else {
                        sb.append("BIG\n");
                        sb.append(c).append("\n");
                    }
                } else
                    sb.append("IMPOSSIBLE\n");
            } else {
                StringBuilder sb1 = new StringBuilder();
                int c = 0;
                boolean possible = true;
                while (possible) {
                    boolean ws = true;
                    boolean wsReverse = true;
                    for (int i = 0; i < N && (ws || wsReverse); i++) {
                        if (A[i] != B[i]) ws = false;
                        if (A[i] != B[N - i - 1]) wsReverse = false;
                    }
                    if (ws) {
                        possible = true;
                        break;
                    } else if (wsReverse) {
                        sb1.append("R");
                        possible = true;
                        break;
                    }
                    boolean increasing = true, decreasing = true;
                    for (int i = 1; i < N; i++) {
                        if (B[i - 1] >= B[i]) increasing = false;
                        if (B[i - 1] <= B[i]) decreasing = false;
                    }
                    if (increasing) {
                        sb1.append("P");
                        c++;
                        for (int i = N - 1; i > 0; i--)
                            B[i] -= B[i - 1];
                    } else if (decreasing) {
                        sb1.append("R");
                        for (int i = 0; i < N / 2; i++) {
                            long t = B[i];
                            B[i] = B[N - i - 1];
                            B[N - i - 1] = t;
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    if (c <= 200000) {
                        sb.append("SMALL\n");
                        sb.append(sb1.length()).append("\n");
                        sb.append(new String(sb1.reverse())).append("\n");
                    } else {
                        sb.append("BIG\n");
                        sb.append(c).append("\n");
                    }
                } else
                    sb.append("IMPOSSIBLE\n");
            }
            System.out.print(new String(sb));
        }
    }
}

