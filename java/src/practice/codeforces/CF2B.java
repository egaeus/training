package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/2/B
 * @category dp
 * @date 22/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF2B {

    public static void main(String args[]) throws Throwable {
        int N;
        short[][] d5;
        short[][] d2;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            N = parseInt(ln);
            d5 = new short[N][N];
            d2 = new short[N][N];
            int[] zero = null;
            short[][][] mem = new short[N][N][6];
            short[][][] mem1 = new short[N][N][6];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    int a = parseInt(st.nextToken());
                    if (a == 0) zero = new int[]{i, j};
                    d5[i][j] = get(a, 5);
                    d2[i][j] = get(a, 2);
                }
            }
            mem[0][0][0] = mem[0][0][2] = d2[0][0];
            mem[0][0][1] = mem[0][0][3] = d5[0][0];
            mem1[N - 1][N - 1][0] = mem1[N - 1][N - 1][2] = d2[N - 1][N - 1];
            mem1[N - 1][N - 1][1] = mem1[N - 1][N - 1][3] = d5[N - 1][N - 1];
            for (int i = 1, I = N - 2; i < N; i++, I--) {
                mem[i][0][0] = mem[i][0][2] = (short) (d2[i][0] + mem[i - 1][0][0]);
                mem[i][0][1] = mem[i][0][3] = (short) (d5[i][0] + mem[i - 1][0][1]);
                mem[i][0][4] = mem[i][0][5] = 0;

                mem[0][i][0] = mem[0][i][2] = (short) (d2[0][i] + mem[0][i - 1][0]);
                mem[0][i][1] = mem[0][i][3] = (short) (d5[0][i] + mem[0][i - 1][1]);
                mem[0][i][4] = mem[0][i][5] = 1;

                mem1[I][N - 1][0] = mem1[I][N - 1][2] = (short) (d2[I][N - 1] + mem1[I + 1][N - 1][0]);
                mem1[I][N - 1][1] = mem1[I][N - 1][3] = (short) (d5[I][N - 1] + mem1[I + 1][N - 1][1]);
                mem1[I][N - 1][4] = mem1[I][N - 1][5] = 0;

                mem1[N - 1][I][0] = mem1[N - 1][I][2] = (short) (d2[N - 1][I] + mem1[N - 1][I + 1][0]);
                mem1[N - 1][I][1] = mem1[N - 1][I][3] = (short) (d5[N - 1][I] + mem1[N - 1][I + 1][1]);
                mem1[N - 1][I][4] = mem1[N - 1][I][5] = 1;
            }

            for (int i = 1, I = N - 2; i < N; i++, I--) {
                for (int j = 1, J = N - 2; j < N; j++, J--) {
                    if (mem[i - 1][j][0] < mem[i][j - 1][0] || (mem[i - 1][j][0] == mem[i][j - 1][0] && mem[i - 1][j][1] > mem[i][j - 1][1])) {
                        mem[i][j][0] = (short) (mem[i - 1][j][0] + d2[i][j]);
                        mem[i][j][1] = (short) (mem[i - 1][j][1] + d5[i][j]);
                        mem[i][j][4] = 0;
                    } else {
                        mem[i][j][0] = (short) (mem[i][j - 1][0] + d2[i][j]);
                        mem[i][j][1] = (short) (mem[i][j - 1][1] + d5[i][j]);
                        mem[i][j][4] = 1;
                    }

                    if (mem[i - 1][j][3] < mem[i][j - 1][3] || (mem[i - 1][j][3] == mem[i][j - 1][3] && mem[i - 1][j][2] > mem[i][j - 1][2])) {
                        mem[i][j][2] = (short) (mem[i - 1][j][2] + d2[i][j]);
                        mem[i][j][3] = (short) (mem[i - 1][j][3] + d5[i][j]);
                        mem[i][j][5] = 0;
                    } else {
                        mem[i][j][2] = (short) (mem[i][j - 1][2] + d2[i][j]);
                        mem[i][j][3] = (short) (mem[i][j - 1][3] + d5[i][j]);
                        mem[i][j][5] = 1;
                    }
                    if (mem1[I + 1][J][0] < mem1[I][J + 1][0] || (mem1[I + 1][J][0] == mem1[I][J + 1][0] && mem1[I + 1][J][1] > mem1[I][J + 1][1])) {
                        mem1[I][J][0] = (short) (mem1[I + 1][J][0] + d2[I][J]);
                        mem1[I][J][1] = (short) (mem1[I + 1][J][1] + d5[I][J]);
                        mem1[I][J][4] = 0;
                    } else {
                        mem1[I][J][0] = (short) (mem1[I][J + 1][0] + d2[I][J]);
                        mem1[I][J][1] = (short) (mem1[I][J + 1][1] + d5[I][J]);
                        mem1[I][J][4] = 1;
                    }

                    if (mem1[I + 1][J][3] < mem1[I][J + 1][3] || (mem1[I + 1][J][3] == mem1[I][J + 1][3] && mem1[I + 1][J][2] > mem1[I][J + 1][2])) {
                        mem1[I][J][2] = (short) (mem1[I + 1][J][2] + d2[I][J]);
                        mem1[I][J][3] = (short) (mem1[I + 1][J][3] + d5[I][J]);
                        mem1[I][J][5] = 0;
                    } else {
                        mem1[I][J][2] = (short) (mem1[I][J + 1][2] + d2[I][J]);
                        mem1[I][J][3] = (short) (mem1[I][J + 1][3] + d5[I][J]);
                        mem1[I][J][5] = 1;
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            int solI = -1, solJ = -1, solO = -1;

            if (zero != null) {
                min = 1;
                solI = zero[0];
                solJ = zero[1];
                solO = 0;
            }
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    int a = Math.min(mem[i][j][0] + mem1[i][j][2] - d2[i][j], mem[i][j][1] + mem1[i][j][3] - d5[i][j]);
                    int b = Math.min(mem[i][j][2] + mem1[i][j][0] - d2[i][j], mem[i][j][3] + mem1[i][j][1] - d5[i][j]);
                    if (min > a || min > b) {
                        solI = i;
                        solJ = j;
                        if (min > a) {
                            min = a;
                            solO = 0;
                        }
                        if (min > b) {
                            min = b;
                            solO = 1;
                        }
                    }
                }
            System.out.println(min);

            StringBuilder back = new StringBuilder();
            for (int i = solI, j = solJ, pi = solO == 0 ? 4 : 5; i > 0 || j > 0; ) {
                if (mem[i][j][pi] == 0) {
                    i--;
                    back.append("D");
                } else {
                    j--;
                    back.append("R");
                }
            }

            System.out.print(new String(back.reverse()));

            back = new StringBuilder();
            for (int i = solI, j = solJ, pi = solO == 0 ? 5 : 4; i < N - 1 || j < N - 1; ) {
                if (mem1[i][j][pi] == 0) {
                    i++;
                    back.append("D");
                } else {
                    j++;
                    back.append("R");
                }
            }


            System.out.println(new String(back));
        }
    }

    static short get(int A, int div) {
        short s = 0;
        for (; A > 0 && A % div == 0; s++, A /= div) ;
        return s;
    }
}