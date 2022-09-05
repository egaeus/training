package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10189
 * @probleName Minesweeper 
 * @judge http://uva.onlinejudge.org/
 * @category simulation, characters
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10189 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 0;
		while (true) {
			String s[] = in.readLine().trim().split(" +");
			int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
			caso++;
			if (n == 0 && m == 0)
				break;
			char[][] matriz = new char[n][m];
			for (int i = 0; i < n; i++)
				matriz[i] = in.readLine().trim().toCharArray();
			if(caso>1)System.out.println();
			System.out.println("Field #"+caso+":");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (matriz[i][j] == '*')
						System.out.print("*");
					else {
						int cont = 0;
						for (int h = -1; h < 2; h++)
							for (int k = -1; k < 2; k++)
								cont += h == 0 && k == 0 ? 0 : (i + h >= 0
										&& i + h < n && j + k >= 0 && j + k < m
										&& matriz[i + h][j + k] == '*' ? 1 : 0);
						System.out.print(cont);
					}
				}
				System.out.println();
			}
		}
	}
}
