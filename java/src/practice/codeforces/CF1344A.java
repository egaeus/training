package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1344/A
 * @category math
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1344A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] arr = new int[N];
            TreeSet<Integer> visited = new TreeSet<>();
            boolean ws = true;
            for(int i = 0; i< N && ws; i++) {
                arr[i] = parseInt(st.nextToken());
                int r = i+(arr[i]>=0?arr[i]%N:(N+arr[i]%N));
                if(visited.contains(r%N))
                    ws=false;
                visited.add(r%N);
            }
            System.out.println(ws?"YES":"NO");

        }
    }
}
