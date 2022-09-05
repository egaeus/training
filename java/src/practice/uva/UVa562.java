package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 562
 * @problemName Dividing Coins
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa562 {
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int I = 0, N = parseInt(in.readLine().trim()); I < N; I++) {
            int M = parseInt(in.readLine().trim());
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int[] arr = new int[M];
            int sum = 0;
            for (int j = 0; j < arr.length; j++)sum += (arr[j] = parseInt(st.nextToken()));
            boolean sums[] = new boolean[sum+1];
            sums[0]=true;
            int min = MAX_VALUE;
            for (int j = 0; j < arr.length; j++){
                for (int j2 = sums.length - 1; j2 >= 0 ; j2--)
                    if(sums[j2])
                        sums[j2 + arr[j]]=true;
            }
            for (int j = 0; j < sums.length; j++) if(sums[j])min = Math.min(min, Math.abs(sum - 2*j));
            System.out.println(min);
        }
    }
}