package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1354/C2>
 * @category geom
 * @date 17/05/2020
 **/

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1354C2 {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double[] angle = new double[200];
        double v = Math.PI/12;
        for(int t=3;t<200;t+=2) {
            angle[t] = v;
            v = (v / (t + 2)) * t;
        }
        int T = parseInt(in.readLine());
        //System.out.println(3.196226611-3.2360679774997902);
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int polygon = 2 * N;
            int h = N / 2 - 1;
            //System.out.println(2*N-2);
            double radius = 1 / Math.sin(Math.PI / polygon),
                    apothem = 0.5 / Math.tan(Math.PI / polygon);
            System.out.println(radius*Math.sin(Math.PI/2-angle[N]));
        }
    }
}
