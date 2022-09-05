package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1030/B>
 * @category geometry
 * @date 5/06/2020
 **/

import java.awt.*;
import java.awt.geom.Path2D;
import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1030B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), D = parseInt(st.nextToken());
            double[][] rect = new double[][]{{D, 0}, {0, D}, {N - D, N}, {N, N - D}};
            Shape shape = getShape(rect);
            int M = parseInt(in.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                double a = parseInt(st.nextToken()), b = parseInt(st.nextToken());
                boolean ws = shape.contains(a, b);
                if (!ws) {
                    for (int j = 0; j < 4 && !ws; j++)
                        ws = distPS(rect[j], rect[(j + 1) % 4], new double[]{a, b}) <= 1e-10;
                }
                System.out.println(ws ? "YES" : "NO");
            }
        }
    }

    static Path2D.Double getShape(double[][] pt) {
        Path2D.Double r = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        r.moveTo(pt[0][0], pt[0][1]);
        for (int i = 1; i < pt.length; i++) r.lineTo(pt[i][0], pt[i][1]);
        r.closePath();
        return r;
    }

    static double ds(double[] a, double[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }

    static double distPL(double[] p1, double[] p2, double[] p) {
        return Math.abs((p2[0] - p1[0]) * (p1[1] - p[1]) - (p2[1] - p1[1]) * (p1[0] - p[0])) / Math.sqrt(ds(p1, p2));
    }

    static double distPS(double[] p1, double[] p2, double[] p) {
        double dP = ds(p1, p2), d1 = ds(p1, p), d2 = ds(p2, p);
        return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPL(p1, p2, p);
    }
}
