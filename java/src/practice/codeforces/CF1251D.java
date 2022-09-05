package practice.codeforces;

/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @url <https://codeforces.com/problemset/problem/1251/D>
 * @category binary search
 * @date 24/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1251D {
    static long[][] arr;
    static long S;
    static int N;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q = parseInt(in.readLine()), q = 0; q++ < Q; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = parseInt(st.nextToken());
            S = Long.parseLong(st.nextToken());
            arr = new long[N][];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                arr[i] = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
            }
            Arrays.sort(arr, (a, b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : 0);
            long max = binaria(arr[N/2][0],arr[N/2][1]);
            Arrays.sort(arr, (a, b) -> a[1] > b[1] ? 1 : a[1] < b[1] ? -1 : a[0] < b[0] ? 1 : a[0] > b[0] ? -1 : 0);
            max = Math.max(max,binaria(arr[N/2][0],arr[N/2][1]));
            System.out.println(max);
        }
    }

    static long binaria(long k,long s){
        if(k==s)return k;
        int p=(int)Math.ceil((k+s)/2.);
        if(check(p))return binaria(p,s);
        return binaria(k,p-1);
    }


    static boolean check(long M) {
        int n = N / 2;
        long s = 0;
        for (int i = 0; i < n; i++)
            if (arr[i][0] <= M)
                s += arr[i][0];
            else
                return false;
        if (arr[n][0] <= M && arr[n][1] >= M)
            s += M;
        else
            return false;
        for (int i = n + 1; i < N; i++)
            if (arr[i][1] >= M)
                s += Math.max(M, arr[i][0]);
        else return false;
        return s <= S;
    }

}
