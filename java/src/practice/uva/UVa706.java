package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 708
 * @problemName LCD Display
 * @judge http://uva.onlinejudge.org/
 * @category characters, simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa706 {
	public static StringBuffer res = new StringBuffer();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] arr = in.readLine().trim().split(" +");
			if (arr[0].equals("0") && arr[1].equals("0"))
				break;
			int n = Integer.parseInt(arr[0]);
			for (int i = 0; i < 2 * n + 3; i++) {
				dibujar("" + Integer.parseInt(arr[1]), i, n);
				res.append("\n");
			}
			res.append("\n");
		}
		System.out.print(res);
	}
	public static void dibujar(String str, int fila, int h) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				if (fila == 0 || fila == 2 * (h + 1)) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
									
				} else if (fila == h + 1)
					for (int j = 0; j < h + 2; j++)
						res.append(" ");
				else {
					res.append("|");
					for (int j = 0; j < h; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '1') {
				if (fila == 0 || fila == h + 1 || fila == 2 * (h + 1))
					for (int j = 0; j < h + 2; j++)
						res.append(" ");
				else {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '2') {
				if (fila == 0 || fila == h + 1 || fila == 2 * (h + 1)) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else if (fila < h + 1) {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				} else {
					res.append("|");
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
				}
			}
			if (str.charAt(i) == '3') {
				if (fila == 0 || fila == h + 1 || fila == 2 * (h + 1)) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '4') {
				if (fila == 0 || fila == 2 * (h + 1))
					for (int j = 0; j < h + 2; j++)
						res.append(" ");
				else if (fila == h + 1) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else if (fila < h + 1) {
					res.append("|");
					for (int j = 0; j < h; j++)
						res.append(" ");
					res.append("|");
				} else {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '5') {
				if (fila == 0 || fila == h + 1 || fila == 2 * (h + 1)) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else if (fila < h + 1) {
					res.append("|");
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
				} else {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '6') {
				if (fila == 0 || fila == h + 1 || fila == 2 * (h + 1)) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else if (fila < h + 1) {
					res.append("|");
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
				} else {
					res.append("|");
					for (int j = 0; j < h; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '7') {
				if (fila == 0) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else if (fila == h + 1 || fila == 2 * (h + 1))
					for (int j = 0; j < h + 2; j++)
						res.append(" ");
				else {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '8') {
				if (fila == 0 || fila == 2 * (h + 1) || fila == h + 1) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else {
					res.append("|");
					for (int j = 0; j < h; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if (str.charAt(i) == '9') {
				if (fila == 0 || fila == h + 1 || fila == 2 * (h + 1)) {
					res.append(" ");
					for (int j = 0; j < h; j++)
						res.append("-");
					res.append(" ");
				} else if (fila < h + 1) {
					res.append("|");
					for (int j = 0; j < h; j++)
						res.append(" ");
					res.append("|");
				} else {
					for (int j = 0; j < h + 1; j++)
						res.append(" ");
					res.append("|");
				}
			}
			if(i < str.length() - 1)res.append(" ");
		}
	}
}
