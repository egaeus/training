package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Not sended
 * @url
 * @category
 * @date 6/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF1119E {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] arr = new int[N];
            int quantity = 0;
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++) {
                int v = parseInt(st.nextToken());
                quantity += v/3;
                arr[i] = v % 3;
            }
            for (int i=N-1;i>0;i--) {

            }
            System.out.println(quantity);
            System.out.println(Arrays.toString(arr));
        }
    }
}
