package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url https://codeforces.com/problemset/problem/534/F
 * @category bitwise, dp
 * @date 28/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class CF534F {
    static int N, M, rows[], cols[];

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            mem = new HashMap<>();
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            rows = new int[N];
            cols = new int[M];
            st = new StringTokenizer(in.readLine());
            int quantity = 0;
            for (int i = 0; i < N; i++) {
                rows[i] = parseInt(st.nextToken());
                quantity |= rows[i] << (i * 4);
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++)
                cols[i] = parseInt(st.nextToken());
            f(0, quantity, 0);
            long initial = quantity << 5;
            long[] solution = new long[M];
            for (int i = 0; i < M; i++) {
                initial = mem.get(initial);
                solution[i] = initial & ((1 << 5) - 1);
            }
            char[][] matrix = new char[N][M];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if ((solution[j] & (1 << i)) == 0)
                        matrix[i][j] = '.';
                    else matrix[i][j] = '*';
            for (char[] a : matrix)
                sb.append(new String(a)).append("\n");
        }
        System.out.print(new String(sb));
    }

    static HashMap<Long, Integer> mem;

    static boolean f(int column, int quantity, long last) {
        if (column == M)
            return quantity == 0;
        Integer response = mem.get((column << 25) | (quantity << 5) | last);
        if (response != null)
            return response >= 0;
        int[] Q = new int[N];
        boolean can = true;
        for (int i = 0, q = quantity; i < N; i++) {
            Q[i] = q & ((1 << 4) - 1);
            q = q >> 4;
            if(M - column < 2*(Q[i]-1))
                can = false;
        }
        for (int i = 0; i < (1 << N) && can; i++) {
            boolean canPut = true;
            int quantityColumn = 0;
            int newQuantity = 0;
            for (int j = 0; j < N && quantityColumn <= cols[column]; j++) {
                if ((i & (1 << j)) != 0) {
                    if (j == 0) quantityColumn++;
                    else if ((i & (1 << (j - 1))) == 0)
                        quantityColumn++;
                    if ((last & (1 << j)) == 0 && Q[j] == 0) {
                        canPut = false;
                        newQuantity |= ((Q[j]) << (4 * j));
                    } else if ((last & (1 << j)) == 0)
                        newQuantity |= ((Q[j] - 1) << (4 * j));
                    else newQuantity |= ((Q[j]) << (4 * j));
                } else
                    newQuantity |= ((Q[j]) << (4 * j));
            }
            if (canPut && cols[column] == quantityColumn) {
                if (f(column + 1, newQuantity, i)) {
                    mem.put((column << 25) | (quantity << 5) | last, ((column + 1) << 25) | (newQuantity << 5) | i);
                    return true;
                }
            }
        }
        mem.put((column << 25) | (quantity << 5) | last, -1);
        return false;
    }
}
