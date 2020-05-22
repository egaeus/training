package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1249/B2>
 * @category math
 * @date 22/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1249B2 {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int Q=parseInt(in.readLine()), q = 0; q++<Q; ) {
            int N = parseInt(in.readLine());
            int[] arr = new int[N];
            int[] res = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<arr.length;i++)
                arr[i]=parseInt(st.nextToken())-1;
            boolean[] vis = new boolean[N];
            for(int i=0;i<N;i++) {
                if(!vis[i]) {
                    LinkedList<Integer> cola = new LinkedList<>();
                    TreeSet<Integer> nums = new TreeSet<>();
                    nums.add(i);
                    cola.add(i);
                    vis[i]=true;
                    for(;!cola.isEmpty();) {
                        int v = cola.poll();
                        if(!vis[arr[v]]) {
                            nums.add(arr[v]);
                            vis[arr[v]]=true;
                            cola.add(arr[v]);
                        }
                    }
                    for(int k:nums)
                        res[k]=nums.size();
                }
            }
            sb.append(IntStream.of(res).mapToObj(a -> a+" ").collect(Collectors.joining(" "))).append("\n");
        }
        System.out.print(new String(sb));
    }
}
