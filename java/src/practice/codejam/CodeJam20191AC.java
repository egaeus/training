package practice.codejam;

/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e05
 * @category implementation
 * @date March, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CodeJam20191AC {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(": ");
            int N=parseInt(in.readLine());
            char[][] A = new char[N][];
            String[] strings=new String[N];
            for(int i=0;i<N;i++)
                A[i]=(strings[i]=in.readLine()).toCharArray();
            TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
            for(int i=0;i<N;i++)
                for(int j=i+1;j<N;j++) {
                    int k=0;
                    for (; k < A[i].length && k < A[j].length; k++)
                        if(A[i][A[i].length-1-k]!=A[j][A[j].length-1-k])
                            break;
                        else {
                            ArrayList<int[]> list = map.get(k+1);
                            if (list == null) list = new ArrayList<>();
                            list.add(new int[]{i, j});
                            map.put(k+1, list);
                        }
                }
            TreeSet<Integer> used=new TreeSet<>();
            TreeSet<String> strUsed=new TreeSet<>();
            int res=0;
            for(int k:map.descendingKeySet()) {
                ArrayList<int[]> list = map.get(k);
                for(int[] a:list) {
                    String s=strings[a[0]].substring(A[a[0]].length-k);
                    if (!used.contains(a[0]) && !used.contains(a[1])&& !strUsed.contains(s)) {
                        res++;
                        used.add(a[0]);
                        used.add(a[1]);
                        strUsed.add(s);
                    }
                }
            }
            sb.append(res*2+"\n");
        }
        System.out.print(new String(sb));
    }
}
