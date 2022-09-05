package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 101
 * @problemmName The Blocks Problem
 * @judge http://uva.onlinejudge.org/
 * @category Simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class UVa101 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(in.readLine().trim());
		int[] arr = new int[s];
		Stack<Integer>[] arrPila = new Stack[s];
		for (int i = 0; i < arrPila.length; i++) {
			arr[i] = i;
			arrPila[i] = new Stack<Integer>();
			arrPila[i].push(i);
		}
		while (true) {
			String linea = in.readLine().trim();
			if (linea.equals("quit"))
				break;
			String a[] = linea.split(" +");
			if (a[0].equals("move")) {
				if (a[2].equals("onto")) {
					int bloqueA = Integer.parseInt(a[1]), bloqueB = Integer
							.parseInt(a[3]);
					if (bloqueA != bloqueB && arr[bloqueA] != arr[bloqueB]) {
						while (arrPila[arr[bloqueA]].peek() != bloqueA) {
							int temp = arrPila[arr[bloqueA]].peek();
							arr[temp] = temp;
							arrPila[arr[bloqueA]].pop();
							arrPila[temp].push(temp);
						}
						while (arrPila[arr[bloqueB]].peek() != bloqueB) {
							int temp = arrPila[arr[bloqueB]].peek();
							arr[temp] = temp;
							arrPila[arr[bloqueB]].pop();
							arrPila[temp].push(temp);
						}
						arrPila[arr[bloqueB]].push(bloqueA);
						arrPila[arr[bloqueA]].pop();
						arr[bloqueA] = arr[bloqueB];
					}
				} else {
					int bloqueA = Integer.parseInt(a[1]), bloqueB = Integer
							.parseInt(a[3]);
					if (bloqueA != bloqueB && arr[bloqueA] != arr[bloqueB]) {
						while (arrPila[arr[bloqueA]].peek() != bloqueA) {
							int temp = arrPila[arr[bloqueA]].peek();
							arr[temp] = temp;
							arrPila[arr[bloqueA]].pop();
							arrPila[temp].push(temp);
						}
						arrPila[arr[bloqueB]].push(bloqueA);
						arrPila[arr[bloqueA]].pop();
						arr[bloqueA] = arr[bloqueB];
					}
				}
			} else if (a[0].equals("pile")) {
				if (a[2].equals("onto")) {
					int bloqueA = Integer.parseInt(a[1]), bloqueB = Integer
							.parseInt(a[3]);
					if (bloqueA != bloqueB && arr[bloqueA] != arr[bloqueB]) {
						while (arrPila[arr[bloqueB]].peek() != bloqueB) {
							int temp = arrPila[arr[bloqueB]].peek();
							arr[temp] = temp;
							arrPila[arr[bloqueB]].pop();
							arrPila[temp].push(temp);
						}
						Stack<Integer> pilaTemp = new Stack<Integer>();
						while (arrPila[arr[bloqueA]].peek() != bloqueA) {
							arr[arrPila[arr[bloqueA]].peek()] = arr[bloqueB];
							pilaTemp.push(arrPila[arr[bloqueA]].pop());
						}
						arrPila[arr[bloqueB]].push(arrPila[arr[bloqueA]].pop());
						while (!pilaTemp.isEmpty())
							arrPila[arr[bloqueB]].push(pilaTemp.pop());
						arr[bloqueA] = arr[bloqueB];
					}
				} else {
					int bloqueA = Integer.parseInt(a[1]), bloqueB = Integer
							.parseInt(a[3]);
					if (bloqueA != bloqueB && arr[bloqueA] != arr[bloqueB]) {
						Stack<Integer> pilaTemp = new Stack<Integer>();
						while (arrPila[arr[bloqueA]].peek() != bloqueA) {
							arr[arrPila[arr[bloqueA]].peek()] = arr[bloqueB];
							pilaTemp.push(arrPila[arr[bloqueA]].pop());
						}
						arrPila[arr[bloqueB]].push(arrPila[arr[bloqueA]].pop());
						while (!pilaTemp.isEmpty())
							arrPila[arr[bloqueB]].push(pilaTemp.pop());
						arr[bloqueA] = arr[bloqueB];
					}
				}

			}
		}
		for (int i = 0; i < arrPila.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < arrPila[i].size(); j++)
				System.out.print(" " + arrPila[i].get(j));
			System.out.println();
		}
	}
}
