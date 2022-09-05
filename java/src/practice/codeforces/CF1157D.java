package practice.codeforces;

/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict R.E.
 * @url <https://codeforces.com/problemset/problem/1157/D>
 * @category greedy, constructive algorithms
 * @date Marzo, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class CF1157D {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(String ln;(ln=in.readLine())!=null;) {
            int N=parseInt(ln);
            int[] A=new int[N], C=new int[N];
            TreeMap<Integer, Integer> map=new TreeMap<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++)A[i]=parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++){
                int a=parseInt(st.nextToken());
                if(map.containsKey(a))map.put(a, map.get(a)+1);
                else map.put(a,1);
            }
            for(int i=0;i<A.length;i++) {
                Integer a=map.ceilingKey(N-A[i]);
                if(a==null)
                    a=map.firstKey();
                C[i]=(a+A[i])%N;
                if(map.get(a)==1)map.remove(a);
                else map.put(a, map.get(a)-1);
            }
            for(int i=0;i<N;i++)
                System.out.print((i>0?" ":"")+C[i]);
            System.out.println();
        }
    }
}
