package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1328/C>
 * @category implementation
 * @date 13/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1328C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int X = parseInt(in.readLine());
            char[] str = in.readLine().toCharArray();
            boolean max = false;
            char[][] solution = new char[2][X];
            solution[0][0] = solution[1][0] = '1';
            for (int i = 1; i < X; i++)
                if (str[i] == '0')
                    solution[0][i] = solution[1][i] = '0';
                else if (str[i] == '1')
                    if (max) {
                        solution[0][i] = '0';
                        solution[1][i] = '1';
                    } else {
                        solution[0][i] = '1';
                        solution[1][i] = '0';
                        max = true;
                    }
                else if (!max) {
                    solution[0][i] = solution[1][i] = '1';
                } else {
                    solution[0][i] = '0';
                    solution[1][i] = '2';
                }
            sb.append(new String(solution[0])).append("\n");
            sb.append(new String(solution[1])).append("\n");
        }
        System.out.print(new String(sb));
    }
}
