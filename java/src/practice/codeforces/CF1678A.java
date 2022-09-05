/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 1678A
 * @problemName Tokitsukaze and All Zero Sequence
 * @judge http://codeforces.com/
 * @category adhoc
 * @level easy
 * @date Thu May 12 2022
 */
package practice.codeforces;

import java.io.*;
import static java.lang.Integer.*;
import java.util.*;

public class CF1678A {
  public static void main(String args[]) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = parseInt(in.readLine());
    for(int t = 0; t < T; t++) {
      int N = parseInt(in.readLine());
      int zeros = 0;
      boolean[] repeats = new boolean[101];
      boolean repeat = false;
      StringTokenizer st = new StringTokenizer(in.readLine());
      for(int i=0;i<N;i++) {
        int n = parseInt(st.nextToken());
        if(n==0)zeros++;
        if(repeats[n])repeat = true;
        repeats[n] = true;
      }
      if(zeros>0)System.out.println(N-zeros);
      else if(repeat) System.out.println(N);
      else System.out.println(N+1);
    }
    System.out.print(new String(sb));
  }
}