package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url https://codeforces.com/problemset/problem/1344/D
 * @category
 * @date
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class CF1344D {
    public static void main(String args[]) throws Throwable {
        String[] palabras = new String[]{"LAPINTA", "LASANTAMARIA", "AMERICA", "INDIGENA", "INDIA",
                "AMERICOVESPUCIO", "CONDIMENTOS", "CIENMILLONES", "CAUCA", "LANIÑA"};
        int N = 20;
        char[][] matrix = new char[N][N];
        Random random = new Random();
        for (String p : palabras) {
            char[] w = p.toCharArray();
            boolean ws = true;
            do {
                int P[] = new int[]{random.nextInt(matrix.length), random.nextInt(matrix.length)};
                int[] v = new int[]{random.nextInt(2), random.nextInt(2)};
                ws = P[0] + w.length * v[0] < N && P[1] + w.length * v[1] < N && (v[0] != 0 || v[1] != 0);
                for (int i = 0; i < w.length && ws; i++) {
                    char ch = matrix[P[0] + i * v[0]][P[1] + i * v[1]];
                    if (ch == '\0' ||
                            ch == w[i])
                        ws = true;
                    else ws = false;
                }
                if (ws) {
                    System.out.println(new String(w)+" "+Arrays.toString(P));
                    for (int i = 0; i < w.length && ws; i++)
                        matrix[P[0] + i * v[0]][P[1] + i * v[1]] = w[i];
                }
            } while (!ws);
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (matrix[i][j] == '\0')
                    matrix[i][j] = (char) (random.nextInt(26) + 'A');
        for (char[] a : matrix) {
            for (char b : a)
                System.out.print(b + " ");
            System.out.println();
        }

    }
}
