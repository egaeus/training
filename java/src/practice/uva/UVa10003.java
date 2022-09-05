package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10003
 * @problemName Cutting Sticks
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10003 {
    static int[][] mat;
    static int[] arr ;
    static int function(int pos1, int pos2){
        if(pos2-pos1<=1)return 0;
        if(mat[pos1][pos2]>0)return mat[pos1][pos2];
        int min = MAX_VALUE;
        for (int i = pos1 + 1; i < pos2; i++)
            min = Math.min(min, function(pos1, i) + function(i, pos2) + arr[pos2] - arr[pos1]);
        return mat[pos1][pos2] = min;
    }
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int L; (L = parseInt(in.readLine().trim())) != 0; ) {
            int n = parseInt(in.readLine().trim());
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            arr = new int[n + 2];
            for (int i = 1; i <= n; i++) arr[i] = parseInt(st.nextToken());
            arr[n + 1] = L;
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            mat = new int[arr.length][arr.length];
            System.out.println("The minimum cutting is " + function(0, arr.length - 1) + ".");
        }
    }
}