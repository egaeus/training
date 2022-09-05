/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 1678B1
 * @problemName Tokitsukaze and Good 01-String (easy version)
 * @judge http://codeforces.com/
 * @category adhoc
 * @level easy
 * @date Thu May 12 2022
 */
package practice.codeforces;

import java.io.*;
import static java.lang.Integer.*;
import java.util.*;

public class CF1678B1 {

  static ArrayList<Integer> list;

  public static void main(String args[]) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = parseInt(in.readLine());
    for(int t = 0; t < T; t++ ) {
      int N = parseInt(in.readLine());
      char[] arr = in.readLine().toCharArray();
      list = new ArrayList<>();
      int last = 0;
      for(int i=1;i<arr.length;i++) {
        if(arr[i]!=arr[i-1]) {
          list.add(i-last);
          last = i;
        }
      }
      list.add(N-last);
      
      System.out.println(f(0,0));
    }
    System.out.print(new String(sb));
  }

  static int f(int p, int add) {
    if(p==list.size())return 0;
    if((list.get(p)+add)%2==1) {
      return f(p+1, 1) + 1;
    }
    return f(p+1, 0);
  }
}