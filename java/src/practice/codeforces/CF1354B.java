package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1354/B>
 * @category implementation
 * @date 17/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1354B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            char[] arr = in.readLine().toCharArray();
            int[][] numbers = new int[arr.length][3];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 3; j++)
                    numbers[i][j] = i > 0 ? numbers[i - 1][j] : 0;
                numbers[i][arr[i] - '1']++;
            }
            if(numbers[arr.length - 1][0] > 0 && numbers[arr.length - 1][1] > 0 && numbers[arr.length - 1][2] > 0) {
                int a = 0, b = arr.length;
                while (a < b) {
                    int p = (a + b) / 2;
                    if (check(numbers, p))
                        b = p;
                    else a = p + 1;
                }
                System.out.println(a);
            }
            else System.out.println(0);
        }
    }

    static boolean check(int[][] numbers, int A) {
        for (int i = A - 1; i < numbers.length; i++) {
            boolean ws = true;
            for (int j = 0; j < 3; j++) {
                int from = i, to = i - A + 1;
                if (numbers[from][j] - (to > 0 ? numbers[to - 1][j] : 0) < 1)
                    ws = false;
            }
            if (ws) return true;
        }
        return false;
    }
}
