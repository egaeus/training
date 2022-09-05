package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1248/B>
 * @category sort
 * @date 20/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1248B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++)
                arr[i]=parseInt(st.nextToken());
            Arrays.sort(arr);
            long A=0,B=0;
            for(int i=0;i<N/2;i++) {
                A+=arr[i];
                B+=arr[N-1-i];
            }
            if(N%2==1)B+=arr[N/2];
            System.out.println(A*A+B*B);
        }
    }
}
