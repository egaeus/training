/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Not sended
 * @problemId 1678C
 * @problemName Tokitsukaze and Strange Inequality
 * @judge http://codeforces.com/
 * @category array
 * @level easy
 * @date Thu May 12 2022
 */
package practice.codeforces;

import java.io.*;
import static java.lang.Integer.*;
import java.util.*;

public class CF1678C {
  public static void main(String args[]) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = parseInt(in.readLine());
    for(int t=0;t++<T; ) {
      int N = parseInt(in.readLine());
      int[] arr = new int[N];
      StringTokenizer st = new StringTokenizer(in.readLine());
      for(int i=0;i<N;i++)arr[i]=parseInt(st.nextToken());
      int[][] mins = new int[N][N+1];
      int[][] maxs = new int[N][N+1];
      
      /*long solution = 0;
      for(int b=0;b<N;b++)
        for(int c=b+1;c<N;c++) {
          System.out.println("----->"+b+" "+c+" "+mins[b][arr[c]]+" "+maxs[c][arr[b]]);
          //solution += mins[c][arr[b]] * maxs[b][arr[c]];
        }
      System.out.println(solution);*/
    }
    System.out.print(new String(sb));
  }
}