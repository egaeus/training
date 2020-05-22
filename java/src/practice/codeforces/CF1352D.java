package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1352/D
 * @category two pointers
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1352D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                list.add(parseInt(st.nextToken()));
            int last = 0, alice = 0, bob = 0, i = 0, turn = 1;
            for (; list.size() > 0; i++) {
                if (i % 2 == 0) {
                    int sum = 0;
                    for (; list.size() > 0 && sum <= last; sum += list.removeFirst()) ;
                    alice += sum;
                    last = sum;
                } else {
                    int sum = 0;
                    for (; list.size() > 0 && sum <= last; sum += list.removeLast()) ;
                    bob += sum;
                    turn++;
                    last = sum;
                }
            }
            System.out.println(i + " " + alice + " " + bob);
        }
    }
}
