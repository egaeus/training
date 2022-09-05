package practice.codeforces;

/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1157/B>
 * @category greedy
 * @date Marzo, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class CF1157B {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(String ln;(ln=in.readLine())!=null;) {
            int N=parseInt(ln);
            char[] num=in.readLine().toCharArray();
            int[] change=new int[9];
            StringTokenizer st=new StringTokenizer(in.readLine());
            for(int i=0;i<9;i++)change[i]=parseInt(st.nextToken());
            int firstChange = -1;
            for(int i=0;i<N;i++) {
                if (num[i] - '0' < change[num[i] - '0' - 1]) {
                    firstChange = i;
                    break;
                }
            }
            if(firstChange!=-1) {
                for(int i=firstChange;i<N;i++) {
                    if (num[i] - '0' <= change[num[i] - '0' - 1]) {
                        num[i]=(char)(change[num[i] - '0' - 1]+'0');
                    }
                    else break;
                }
            }
            System.out.println(new String(num));
        }
    }
}
