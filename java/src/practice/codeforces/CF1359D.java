package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1359/D>
 * @category rmq
 * @date 28/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1359D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < arr.length; i++)
                arr[i] = parseInt(st.nextToken());
            int[] maxs = new int[N];
            int[] mins = new int[N];
            Arrays.fill(mins, -1);
            Arrays.fill(maxs, N);
            int[] values = new int[61];
            Arrays.fill(values, -1);
            values[arr[0] + 30] = 0;
            for (int i = 1; i < N; i++) {
                for (int j = arr[i] + 1; j <= 30; j++)
                    mins[i] = Math.max(mins[i], values[j + 30]);
                values[arr[i] + 30] = i;
            }
            Arrays.fill(values, N);
            values[arr[N - 1] + 30] = N - 1;
            for (int i = N - 2; i >= 0; i--) {
                for (int j = arr[i] + 1; j <= 30; j++)
                    maxs[i] = Math.min(maxs[i], values[j + 30]);
                values[arr[i] + 30] = i;
            }
            int[] arr1 = new int[N];
            arr1[N - 1] = arr[N - 1];
            for (int i = 1; i < N; i++)
                arr1[N - i - 1] = arr[N - i - 1] + arr1[N - i];
            for (int i = 1; i < N; i++)
                arr[i] += arr[i - 1];
            int s = MIN_VALUE;
            RMQ rmq = new RMQ(arr);
            RMQ rmq1 = new RMQ(arr1);
            for (int i = 0; i < N; i++) {
                int a = rmq.get(i, maxs[i]) - arr[i];
                int b = rmq1.get(mins[i] + 1, i+1) - arr1[i];
                s = Math.max(s, a+b);
            }
            System.out.println(s);
        }
    }

    static class RMQ {
        int N;
        int D;
        int[] arr;
        int[][] cotas;
        int[] vals;
        int max;

        public RMQ(int[] arr) {
            N = arr.length;
            D = (int) Math.ceil(Math.sqrt(N));
            this.arr = arr;
            cotas = new int[(int) Math.ceil(1. * N / D)][];
            vals = new int[(int) Math.ceil(1. * N / D)];
            //Change init
            Arrays.fill(vals, MIN_VALUE);
            for (int i = 0, j = 0; j < cotas.length; i += D, j++)
                cotas[j] = new int[]{i, Math.min(i + D, arr.length)};
            for (int i = 0; i < cotas.length; i++) {
                for (int j = cotas[i][0]; j < cotas[i][1]; j++) {
                    //Change function
                    vals[i] = Math.max(vals[i], arr[j]);
                }
            }


        }

        int get(int a, int b) {
            int desde = -1, hasta = -1;
            for (int i = 0; i < cotas.length; i++) {
                if (a >= cotas[i][0] && a < cotas[i][1]) {
                    desde = i;
                }
                if (b > cotas[i][0] && b <= cotas[i][1]) {
                    hasta = i;
                }
            }
            //Change init
            int min = MIN_VALUE;
            for (int i = desde + 1; i < hasta; i++)
                //Change function
                min = Math.max(min, vals[i]);
            int izq = getSegementIzq(desde, a, b);
            int der = (desde != hasta ? getSegementDer(hasta, a, b - 1) : MIN_VALUE);
            //Change function
            return Math.max(min, Math.max(izq, der));
        }

        int getSegementIzq(int i, int a, int b) {
            //Change init
            int min = MIN_VALUE;
            for (int j = a; j < Math.min(cotas[i][1], b); j++)
                //Change function
                min = Math.max(min, arr[j]);
            return min;
        }

        int getSegementDer(int i, int a, int b) {
            //Change init
            int min = MIN_VALUE;
            for (int j = b; j >= Math.max(a, cotas[i][0]); j--)
                //Change function
                min = Math.max(min, arr[j]);
            return min;
        }
    }
}
