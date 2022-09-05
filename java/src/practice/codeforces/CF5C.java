package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/5/C>
 * @category strings
 * @date 29/10/2019
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CF5C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            char[] s = ln.toCharArray();
            int[] arr = new int[s.length + 1];
            arr[0] = 0;
            int min = 0;
            int max = 0;
            for (int i = 0; i < s.length; i++) {
                arr[i + 1] = arr[i] + (s[i] == ')' ? -1 : 1);
                if (min > arr[i + 1])
                    min = arr[i + 1];
                if (max < arr[i + 1])
                    max = arr[i + 1];
            }
            if (min < 0) max -= min;
            List<Integer> lists[] = new Vector[max + 1];
            for (int i = 0; i < arr.length; i++) {
                if (min < 0)
                    arr[i] -= min;
                if (lists[arr[i]] == null) lists[arr[i]] = new Vector<>();
                lists[arr[i]].add(i);
            }
            SegmentTree segmentTree = new SegmentTree(arr);
            max = 0;
            int c = 0, last, v, v1;
            List<Integer> list;
            for (int k = 0; k < lists.length; k++) {
                list = lists[k];
                last = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    v = list.get(i);
                    v1 = list.get(i - 1);
                    if (segmentTree.getValor(v1 + 1, v) < k) {
                        if (max == v1 - last)
                            c++;
                        else if (max < v1 - last) {
                            max = v1 - last;
                            c = 1;
                        }
                        last = v;
                    }
                }
                v = list.get(list.size() - 1);
                if (max == v - last)
                    c++;
                else if (max < v - last) {
                    c = 1;
                    max = v - last;
                }
            }
            if (max > 0)
                System.out.println(max + " " + c);
            else
                System.out.println("0 1");
        }
    }

    static class SegmentTree {
        private int[] valores;
        private int izq[], der[], cotas[][], c;
        private int N;
        private int[] valoresIniciales;

        public SegmentTree(int[] valoresIniciales) {
            this.valoresIniciales = valoresIniciales;
            N = valoresIniciales.length;
            int n = N * 2;
            valores = new int[n];
            c = 0;
            cotas = new int[2][n];
            izq = new int[n];
            der = new int[n];
            initTree(0, N);
        }

        private int initTree(int desde, int hasta) {
            int C = c++;
            cotas[0][C] = desde;
            cotas[1][C] = hasta;
            if (hasta - desde > 1) {
                int p = (hasta + desde) / 2;
                izq[C] = initTree(desde, p);
                der[C] = initTree(p, hasta);
                if (valores[izq[C]] < valores[der[C]])
                    valores[C] = valores[izq[C]];
                else
                    valores[C] = valores[der[C]];
            } else
                valores[C] = valoresIniciales[desde];
            return C;
        }

        public int getValor(int desde, int hasta) {
            return getValor(0, desde, hasta);
        }

        public int getValor(int i, int desde, int hasta) {
            if (cotas[0][i] == desde && cotas[1][i] == hasta) return valores[i];
            if (desde >= cotas[0][izq[i]] && hasta <= cotas[1][izq[i]]) return getValor(izq[i], desde, hasta);
            if (desde >= cotas[0][der[i]] && hasta <= cotas[1][der[i]]) return getValor(der[i], desde, hasta);
            int l = getValor(izq[i], desde, cotas[1][izq[i]]), r = getValor(der[i], cotas[0][der[i]], hasta);
            if (l < r)
                return l;
            return r;
        }
    }

}