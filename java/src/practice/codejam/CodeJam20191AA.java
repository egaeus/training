package practice.codejam; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @url <https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e05
 * @category adhoc, implementation
 * @date March, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CodeJam20191AA {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(": ");
            StringTokenizer st = new StringTokenizer(in.readLine());
            int R=parseInt(st.nextToken()),C=parseInt(st.nextToken());
            int[][] r=f(R,C);
            if(r!=null) {
                sb.append("POSSIBLE\n");
                TreeMap<Integer, int[]> map = new TreeMap<>();
                for(int i=0;i<R;i++)
                    for(int j=0;j<C;j++)
                        map.put(r[i][j], new int[]{i+1,j+1});
                for(int[] a:map.values())
                    sb.append(a[0]+" "+a[1]+"\n");
            }
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.print(new String(sb));
    }

    static int[][] f(int R, int C) {
        if(R>C) {
            int[][] r = f(C,R);
            if(r!=null) {
                int[][] result = new int[R][C];
                for (int i = 0; i < R; i++)
                    for (int j = 0; j < C; j++)
                        result[i][j] = r[j][i];
                return result;
            }
        }
        for(int k=0;k<=C;k++) {
            int[][] r = new int[R][C];
            for (int i = 0; i < R; i++)
                for (int j = 0; j < C; j++)
                    r[i][(j + (i * k)) % C] = (j * R + i);
            if(f(r))return r;
        }
        return null;
    }

    static boolean f(int[][] r) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for(int i=0;i<r.length;i++)
            for(int j=0;j<r[i].length;j++)
                map.put(r[i][j], new int[]{i+1,j+1});
        int[] c=null;
        for(int[] a:map.values()) {
            if (c != null && (c[0] == a[0] || c[1] == a[1] || c[0] - c[1] == a[0] - a[1] || c[0] + c[1] == a[0] + a[1]))
                return false;
            c=a;
        }
        return true;
    }
}
