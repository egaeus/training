package practice.codeforces;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1348/F
 * @category adhoc
 * @date 01/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1348F {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int[][] arr = new int[N][];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                arr[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken()), i, 0};
            }
            Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int[] firstSolution = new int[N];
            int[] secondSolution = new int[N];
            MultiSet<Integer> multiSet = new MultiSet<>();
            for (int i = 0, j = 0; j < N; j++) {
                for(; i < arr.length && arr[i][0] <= j + 1; i++)
                    multiSet.add(arr[i][1], i);
                int position = multiSet.getFirst();
                secondSolution[arr[position][2]] = firstSolution[arr[position][2]] = j + 1;
                arr[position][3] = j + 1;
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a[3]));
            TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
            boolean ws = false;
            for (int i = 0; i < N; i++) {
                int[] get = set.ceiling(new int[]{i+1, i});
                if (get != null && arr[i][0] <= get[1] + 1 && i + 1 <= get[0]) {
                    int t = secondSolution[arr[i][2]];
                    secondSolution[arr[i][2]] = secondSolution[arr[get[1]][2]];
                    secondSolution[arr[get[1]][2]] = t;
                    ws = true;
                    break;
                }
                int[] add = new int[]{arr[i][1], i};
                if(set.contains(add))
                    set.remove(add);
                set.add(add);
            }
            System.out.println(!ws?"YES":"NO");
            System.out.println(IntStream.of(firstSolution).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
            if(ws)
                System.out.println(IntStream.of(secondSolution).mapToObj(a -> a + "").collect(Collectors.joining(" ")));

            int[] A = new int[N];
            int[] B = new int[N];
            TreeMap<Integer, int[]> BA = new TreeMap<>();
            for(int j = 0; j < N; j++) {
                Integer b = BA.ceilingKey(A[j]);
                if(b == null) {
                    ////Aun no se puede swapper
                } else {
                    int[] a = BA.get(b);
                    if(a[0] <= j && a[1] <= B[j]) {
                        //Si se puede swapper
                    }
                    else {
                        //Aun no se puede swapper
                    }
                }
                BA.put(B[j], new int[]{A[j], j});
            }

        }
    }

    static class MultiSet<T extends Comparable> {
        private TreeMap<T, List<Integer>> map;

        public MultiSet() {
            map = new TreeMap<>();
        }

        public void add(T t, int index) {
            List<Integer> list = map.get(t);
            if(list == null)
                list = new LinkedList<>();
            list.add(index);
            map.put(t, list);
        }

        public int getFirst() {
            T key = map.firstKey();
            int index = map.get(key).remove(0);
            if(map.get(key).size() == 0)
                map.remove(key);
            return index;
        }
    }
}
