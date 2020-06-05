package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @url <https://codeforces.com/problemset/problem/1359/F>
 * @category geom
 * @date 28/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class CF1359F {

    static double eps = 1e-10;

    static void generateCase() {
        int N = 25000;
        StringBuilder sb = new StringBuilder();
        sb.append(N).append("\n");
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            sb.append(random.nextInt(2001) - 1000).append(" ");
            sb.append(random.nextInt(2001) - 1000).append(" ");
            sb.append(random.nextInt(2001) - 1000).append(" ");
            sb.append(random.nextInt(2001) - 1000).append(" ");
            sb.append(random.nextInt(1001)).append("\n");
        }
        System.out.print(new String(sb));
    }

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            long time = System.currentTimeMillis();
            int N = parseInt(ln);
            double[][] lines = new double[N][];
            double[] velocity = new double[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                lines[i] = new double[]{parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()), 0};
                lines[i][4] = lines[i][3] / lines[i][2];
                lines[i][2] += lines[i][0];
                lines[i][3] += lines[i][1];
                velocity[i] = parseInt(st.nextToken());
            }
            double solution = Double.POSITIVE_INFINITY;
            for (int i = 0; i < N; i++)
                for (int j = i + 1; j < N; j++) {
                    if ((abs(lines[i][4]) == Double.POSITIVE_INFINITY && abs(lines[j][4]) == Double.POSITIVE_INFINITY)
                            || abs(lines[i][4] - lines[j][4]) < eps) {
                        solution = Math.min(solution, time(lines[i][0],
                                lines[i][1], lines[i][2], lines[i][3],
                                lines[j][0], lines[j][1], lines[j][2], lines[j][3],
                                velocity[i], velocity[j]));
                    } else {
                        double[] intersect = intLineas(lines[i][0],
                                lines[i][1], lines[i][2], lines[i][3],
                                lines[j][0], lines[j][1], lines[j][2], lines[j][3]);
                        if (intersect != null &&
                                f(lines[i][0], lines[i][1], lines[i][2],
                                        lines[i][3], intersect[0], intersect[1]) &&
                                f(lines[j][0], lines[j][1], lines[j][2], lines[j][3],
                                        intersect[0], intersect[1])) {
                            double distanceA = Math.sqrt(distance(lines[i][0], lines[i][1],
                                    intersect[0], intersect[1]));
                            double distanceB = Math.sqrt(distance(lines[j][0], lines[j][1],
                                    intersect[0], intersect[1]));
                            solution = Math.min(solution, Math.max(distanceA / velocity[i], distanceB / velocity[j]));
                        }
                    }
                }
            if (solution != Double.POSITIVE_INFINITY)
                System.out.println(solution);
            else
                System.out.println("No show :(");
            System.out.println(System.currentTimeMillis() - time);
        }
    }

    static boolean f(double x1, double y1, double x2, double y2, double px, double py) {
        if (distPS(x1, y1, x2, y2, px, py) <= eps)
            return true;
        if (distPS(x1, y1, px, py, x2, y2) <= eps)
            return true;
        return false;
    }

    static double distance(double x1, double y1, double x2, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    static double time(double x1, double y1, double x2, double y2,
                       double x3, double y3, double x4, double y4,
                       double v1, double v2) {
        if (distPL(x1, y1, x2, y2, x3, y3) <= eps ||
                distPL(x3, y3, x4, y4, x1, y1) <= eps) {
            double x = (x1 + x3) / 2, y = (y1 + y3) / 2;
            if (f(x1, y1, x2, y2, x, y) &&
                    f(x3, y3, x4, y4, x, y)) {
                return Math.sqrt(distance(x1, y1, x3, y3)) / (v1 + v2);
            } else if (f(x1, y1, x2, y2, x, y))
                return Math.sqrt(distance(x1, y1, x3, y3)) / v1;
            return Math.sqrt(distance(x1, y1, x3, y3)) / v2;
        }
        return Double.POSITIVE_INFINITY;
    }

    static double[] intLineas(double x1, double y1, double x2, double y2,
                              double x3, double y3, double x4, double y4) {
        double xa = x2 - x1, xb = x4 - x3, xc = x1 - x3, ya = y2 - y1, yb = y4 - y3, yc = y1 - y3, d = yb * xa - xb * ya, n = xb * yc - yb * xc;
        return Math.abs(d) < 1e-11 ? null : new double[]{x1 + xa * n / d, y1 + ya * n / d};
    }

    static double distPL(double x1, double y1, double x2, double y2, double px, double py) {
        return Math.abs((x2 - x1) * (y1 - py) - (y2 - y1) * (x1 - px)) / Math.sqrt(distance(x1, y1, x2, y2));
    }

    static double distPS(double x1, double y1, double x2, double y2, double px, double py) {
        double dP = distance(x1, y1, x2, y2), d1 = distance(x1, y1, px, py),
                d2 = distance(x2, y2, px, py);
        return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPL(x1, y1, x2, y2, px, py);
    }
}
