package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/C>
 * @category math
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> even = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++) {
                int a = parseInt(st.nextToken());
                if(a%2==0)even.add(a);
                else odd.add(a);
            }
            Collections.sort(odd);
            Collections.sort(even);
            if(odd.size()%2==0&&even.size()%2==0)
                System.out.println("YES");
            else if(odd.size()%2==1&&even.size()%2==1) {
                boolean ws = false;
                for(int a:odd)
                    if(Collections.binarySearch(even, a-1)>=0||
                            Collections.binarySearch(even, a+1)>=0)
                        ws = true;
                System.out.println(ws?"YES":"NO");
            }
            else
                System.out.println("NO");
        }
    }
}
