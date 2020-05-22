package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/547/B>
 * @category rmq
 * @date 24/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF547B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            int[] arr = new int[N];
            int[] arrI = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                arrI[N-i-1] = arr[i];
            }
            RMQ rmq = new RMQ(arr);
            RMQ rmqI = new RMQ(arrI);
            int[] A = new int[N];
            int[] B = new int[N];
            for(int i=0;i<N;i++) {
                A[i] = rmq.get(i);
                int p = rmqI.get(i);
                B[N-i-1] = p>-1?N-1-p:-1;
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i=0;i<N;i++) {
                int q = (A[i]==-1?N-i-1:A[i]-i-1)+(B[i]==-1?i:i-B[i]-1)+1;
                Integer v = map.get(arr[i]);
                if(v==null) v = q;
                map.put(arr[i], Math.max(v, q));
            }
            int[] R = new int[N];
            for(int t = 1;!map.isEmpty();) {
                Map.Entry<Integer, Integer> entry = map.pollLastEntry();
                for(;t<=entry.getValue();t++)
                    R[t-1] = entry.getKey();
            }
            System.out.println(Arrays.stream(R).mapToObj(a -> a+"").collect(Collectors.joining(" ")));
        }
    }

    static class RMQ {
        private int[] arr;
        private int[] mins;
        private int sqrt;
        private int N;

        RMQ(int[] arr) {
            this.arr = arr;
            N = arr.length;
            sqrt = (int)Math.sqrt(N);
            mins = new int[(int)Math.ceil(1.*N/sqrt)];
            Arrays.fill(mins, Integer.MAX_VALUE);
            for(int i=0;i<N;i++)
                mins[i/sqrt] = Math.min(mins[i/sqrt], arr[i]);
        }

        int get(int l) {
            int t = arr[l];
            l++;
            for(;l%sqrt!=0&&l<N;l++)
                if(arr[l]<t)
                    return l;
            for(;l<N;l+=sqrt)
                if(mins[l/sqrt]<t) {
                    for(;;l++)
                        if(arr[l]<t)
                            return l;
                }
            return -1;
        }
    }
}
