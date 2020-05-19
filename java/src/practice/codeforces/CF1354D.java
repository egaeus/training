package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1354/D
 * @category bit
 * @date 18/05/2020
 **/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1354D {

    static int BUFFER_SIZE = 1 << 16;
    static DataInputStream din;
    static byte[] buffer;
    static int bufferPointer, bytesRead;

    public static void main(String args[]) throws Throwable {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;

        int N = nextInt(), Q = nextInt(), v, q, a, b, search, i;
        MaxVal = N + 1;
        tree = new int[N + 2];
        for (i = 0; i < N; i++)
            update(nextInt(), 1);
        for (q = 0; q < Q; q++) {
            v = nextInt();
            if (v > 0)
                update(v, 1);
            else {
                a = 0;
                b = N;
                search = -v;
                while (a < b) {
                    int p = (a + b) / 2 + (a + b) % 2;
                    if (read(p) >= search)
                        b = p - 1;
                    else
                        a = p;
                }
                update(a + 1, -1);
            }
        }
        boolean ws = false;
        for (i = 0; i <= N && !ws; i++)
            if (read(i) > 0) {
                System.out.println(i);
                ws = true;
            }
        if (!ws)
            System.out.println(0);
    }

    static int MaxVal = 1000001;
    static int[] tree = new int[1000002];// la pos 0 no se usa!!!!!

    static int read(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    static void update(int idx, int val) {
        while (idx <= MaxVal) {
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }

    static int nextInt() throws Throwable {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    static byte read() throws Throwable {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    static void fillBuffer() throws Throwable {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

}
