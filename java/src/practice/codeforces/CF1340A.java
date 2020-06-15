package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1340/A>
 * @category implementation
 * @date 8/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1340A {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] arr = new int[N];
            long[] stree = new long[N];
            int[] q = new int[N];
            TreeSet<Integer> set = new TreeSet<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[parseInt(st.nextToken()) - 1] = i;
                stree[i] = 1;
                set.add(i);
                q[i] = 1;
            }
            SegmentTree segmentTree = new SegmentTree(stree);
            boolean ws = true;
            for (int i = 0; i < N && ws; i++) {
                if (set.contains(arr[i])) {
                    int v = arr[i];
                    int val = q[v];
                    if (val == segmentTree.getValor(0, N)) {
                        set.remove(v);
                        segmentTree.setValor(v, 0);
                        Integer next = set.ceiling(v);
                        if (next != null) {
                            q[next] += val;
                            segmentTree.setValor(next, q[next]);
                        }
                    } else ws = false;
                } else ws = false;
            }
            sb.append(ws ? "Yes" : "No").append("\n");
        }
        System.out.print(new String(sb));
    }

    static class SegmentTree {
        private long[] valores;
        private int izq[], der[], cotas[][], c;
        private int[] cuentas;
        private int N;
        private long[] valoresIniciales;

        public SegmentTree(long[] valoresIniciales) {
            this.valoresIniciales = valoresIniciales;
            N = valoresIniciales.length;
            int n = N * 2;
            valores = new long[n];
            c = 0;
            cotas = new int[n][2];
            izq = new int[n];
            der = new int[n];
            cuentas = new int[N + 1];
            initTree(0, N);
        }

        private int initTree(int desde, int hasta) {
            int C = c++;
            cotas[C][0] = desde;
            cotas[C][1] = hasta;
            if (hasta - desde > 1) {
                int p = (hasta + desde) / 2;
                izq[C] = initTree(desde, p);
                der[C] = initTree(p, hasta);
                valores[C] = Math.max(valores[izq[C]], valores[der[C]]);
            } else
                valores[C] = valoresIniciales[desde];
            return C;
        }

        public void setValor(int index, long val) {
            int C = 0, i = 0;
            cuentas[C++] = i;
            for (; cotas[i][1] - cotas[i][0] > 1; )
                if (cotas[izq[i]][0] <= index && cotas[izq[i]][1] > index) cuentas[C++] = (i = izq[i]);
                else cuentas[C++] = (i = der[i]);
            valores[i] = val;
            for (C = C - 2; C >= 0; C--) {
                i = cuentas[C];
                long l = valores[izq[i]], r = valores[der[i]];
                valores[i] = Math.max(l, r);
            }
        }

        public long getValor(int desde, int hasta) {
            return getValor(0, desde, hasta);
        }

        public long getValor(int i, int desde, int hasta) {
            if (cotas[i][0] == desde && cotas[i][1] == hasta) return valores[i];
            if (desde >= cotas[izq[i]][0] && hasta <= cotas[izq[i]][1]) return getValor(izq[i], desde, hasta);
            if (desde >= cotas[der[i]][0] && hasta <= cotas[der[i]][1]) return getValor(der[i], desde, hasta);
            return Math.max(getValor(izq[i], desde, cotas[izq[i]][1]), getValor(der[i], cotas[der[i]][0], hasta));
        }

        public String toString() {
            String res = "";
            for (int i = 0; i < cotas.length; i++) res += Arrays.toString(cotas[i]) + ":" + valores[i];
            return res;
        }
    }

}
