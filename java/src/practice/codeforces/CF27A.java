package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/27/A>
 * @category implementation
 * @date 28/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF27A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            boolean[] arr = new boolean[3001];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++)
                arr[parseInt(st.nextToken())-1]=true;
            int s = -1;
            for(int i=0;i<3001&&s==-1;i++)
                if(!arr[i])
                    s=i;
            System.out.println(s+1);
        }
    }
}
