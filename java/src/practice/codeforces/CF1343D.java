package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url
 * @category
 * @date
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1343D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        /*int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
        }*/
        System.out.println(Arrays.toString(f(15, new int[][]{{5, 12}, {3, 10}, {7, 13}, {4, 11}, {5, 10}, {1, 10}, {5, 12}})));
    }

    static int[] f(int N, int[][] ranges) {
        int[] beginRange = new int[N];
        int[] endRange = new int[N];
        int[] result = new int[N];
        for (int[] range : ranges) {
            beginRange[range[0]]++;
            endRange[range[1]]++;
        }
        for (int i = 0; i < N; i++) {
            if (i > 0)
                result[i] = result[i - 1] + beginRange[i] - endRange[i];
            else
                result[i] = beginRange[i] - endRange[i];
        }
        return result;
    }
}
