package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/CF1364C>
 * @category ?
 * @date 13/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1364C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            boolean ws = true;
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                if (arr[i] > i + 1)
                    ws = false;
            }
            if (ws) {
                TreeSet<Integer> set = new TreeSet<>();
                for (int i = 0; i < arr[N - 1]; i++)
                    set.add(i);
                int[] solution = new int[N];
                Arrays.fill(solution, -1);
                for (int i = 1; i < N; i++)
                    if (arr[i - 1] != arr[i]) {
                        solution[i] = arr[i - 1];
                        set.remove(arr[i - 1]);
                    }
                //System.out.println(Arrays.toString(solution));
                for (int i = 0; i < N; i++)
                    if (solution[i] == -1 && set.size() > 0 && set.first() != arr[i]) {
                        solution[i] = set.first();
                        set.remove(set.first());
                    } else if (solution[i] == -1) {
                        if (i > 0)
                            solution[i] = solution[i - 1];
                        else
                            solution[i] = arr[N - 1] + 1;
                    }
                //System.out.println(set);
                System.out.println(IntStream.of(solution).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
            } else {
                System.out.println(-1);
            }
        }
    }
}
