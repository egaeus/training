package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1249/A
 * @category implementation
 * @date 22/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1249A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q = parseInt(in.readLine()), q=0; q++<Q; ) {
            int N = parseInt(in.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++)
                arr[i]=parseInt(st.nextToken());
            Arrays.sort(arr);
            boolean ws = false;
            for(int i=1;i<N&&!ws;i++)
                if(arr[i]==arr[i-1]+1)
                    ws = true;
            System.out.println(ws?2:1);
        }
    }
}
