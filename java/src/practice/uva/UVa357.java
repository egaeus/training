package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 357
 * @problemName Let Me Count The Ways
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 19/04/2010
 **/
import java.util.Scanner;
public class UVa357 {
    public static void main(String[] args) {
        int[] valores = new int[]{1, 5, 10, 25, 50};
        long arr[] = new long[30001];
        arr[0] = 1;
        for (int i = 0; i < valores.length; i++) {
            arr[valores[i]]++;
            for (int j = valores[i] + 1; j < arr.length; j++)
                if(arr[j - valores[i]] > 0)
                    arr[j] += arr[j - valores[i]];
        }
        Scanner sc = new Scanner(System.in);
        for (; sc.hasNextInt();) {
            int n = sc.nextInt();
            System.out.println(arr[n]>1?"There are " + arr[n] + " ways to produce " + n + " cents change.":"There is only 1 way to produce " + n + " cents change.");
        }
    }
}