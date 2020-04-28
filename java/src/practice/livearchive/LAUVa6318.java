package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6318
 * @problemName The New President
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Sep 17, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class LAUVa6318 {
	static int pos(int[] arr, int v) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == v)
				return i;
		return -1;
	}

	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0, T = parseInt(in.readLine().trim()); t++ < T;) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int C = parseInt(st.nextToken()), V = parseInt(st.nextToken());
			int[][] votes = new int[V][C];
			int[][] candidates = new int[C][2];
			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < C; j++)
					votes[i][j] = parseInt(st.nextToken());
				candidates[votes[i][0] - 1][0]++;
				candidates[votes[i][0] - 1][1] = votes[i][0] - 1;
			}
			Arrays.sort(candidates, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
				}
			});
			if (candidates[0][0] > votes.length / 2)
				sb.append(candidates[0][1] + 1).append(" 1");
			else {
				candidates[0][0] = 0;
				candidates[1][0] = 0;
				for (int i = 0; i < V; i++)
					if (pos(votes[i], candidates[0][1] + 1) < pos(votes[i],
							candidates[1][1] + 1))
						candidates[0][0]++;
					else
						candidates[1][0]++;
				sb.append(
						candidates[0][0] > candidates[1][0] ? candidates[0][1] + 1
								: candidates[1][1] + 1).append(" 2");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
