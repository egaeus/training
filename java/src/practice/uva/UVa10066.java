package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10066
 * @problemName The Twin Towers
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10066 {
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int caso = 1;
        for (; ; ) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            if(N==0 && M==0)break;
            st = new StringTokenizer(in.readLine().trim());
            int[] arr1 = new int[N], arr2 = new int[M];
            for (int i = 0; i < N; i++) arr1[i] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine().trim());
            for (int i = 0; i < M; i++) arr2[i] = parseInt(st.nextToken());
            int[][] arr = new int[N + 1][M + 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                for (int j = arr[0].length - (arr.length - i); j >= 0; j--)
                    arr[i][j]=Math.max(arr1[i]==arr2[j]?arr[i+1][j+1] + 1:0, Math.max(arr[i+1][j], arr[i][j+1]));
                for (int j = i - 1; j >= 0 && arr[0].length - (arr.length - i)>=0; j--)
                    arr[j][arr[0].length - (arr.length - i)]=Math.max(arr1[j]==arr2[arr[0].length - (arr.length - i)]?arr[j+1][arr[0].length - (arr.length - i)+1] + 1:0, Math.max(arr[j+1][arr[0].length - (arr.length - i)], arr[j][arr[0].length - (arr.length - i)+1]));
            }
            //for (int i = 0; i < arr.length; i++) System.out.println(Arrays.toString(arr[i]));
            System.out.println("Twin Towers #" + caso++ + "\nNumber of Tiles : " + arr[0][0] + "\n");
        }
    }
}