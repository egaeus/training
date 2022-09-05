package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 601
 * @problemName The Path
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa601 {
    static char[][] arr;
    static int[][] mem;
    static boolean visitado[][];
    static boolean function(int i, int j, boolean ws){
        if(ws){
            if(j == arr.length - 1 && arr[i][j] == 'W')return true;
            visitado[i][j] = true;
            if(mem[i][j]!=0)return mem[i][j] == 1;
            mem[i][j] = arr[i][j]=='W'&&((i>0&&!visitado[i-1][j]?function(i-1, j, ws):false)||(i<arr.length - 1&&!visitado[i+1][j]?function(i+1,j, ws):false)||(j>0&&!visitado[i][j-1]?function(i, j-1, ws):false)||(j<arr.length - 1&&!visitado[i][j+1]?function(i, j+1, ws):false))?1:-1;
            return mem[i][j] == 1;
        }
        else{
            if(i == arr.length - 1 && arr[i][j] == 'B')return true;
            visitado[i][j] = true;
            if(mem[i][j]!=0)return mem[i][j] == 1;
            mem[i][j] = arr[i][j]=='B'&&((i>0&&!visitado[i-1][j]?function(i-1, j, ws):false)||(i<arr.length - 1&&!visitado[i+1][j]?function(i+1,j, ws):false)||(j>0&&!visitado[i][j-1]?function(i, j-1, ws):false)||(j<arr.length - 1&&!visitado[i][j+1]?function(i, j+1, ws):false))?1:-1;
            return mem[i][j] == 1;
        }
    }
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int N; (N = Integer.parseInt(in.readLine().trim())) != 0; ) {
            in.readLine();
            arr = new char[N][];
            for (int i = 0; i < arr.length; i++)arr[i] = in.readLine().trim().toCharArray();
            boolean ws = false;
            mem = new int[N][N];
            visitado = new boolean[N][N];
            for (int i = 0; i < arr.length && !ws; i++)if(arr[i][0]=='W')ws = ws || function(i, 0, true);
            if(ws)System.out.println("White has a winning path.");
            else{
                mem = new int[N][N];
                visitado = new boolean[N][N];
                for (int i = 0; i < arr.length && !ws; i++)if(arr[0][i]=='B')ws = ws || function(0, i, false);
                if(ws)System.out.println("Black has a winning path.");
                else{
                    for (int i = 0; i < arr.length && !ws; i++)
                        for (int j = 0; j < arr.length && !ws; j++)
                            if(arr[i][j]=='U'){
                                arr[i][j]='W';
                                mem = new int[N][N];
                                visitado = new boolean[N][N];
                                for (int K = 0; K < arr.length; K++)if(arr[K][0]=='W')ws = ws || function(K, 0, true);
                                if(ws)
                                    break;
                                arr[i][j]='U';
                            }
                    if(ws)System.out.println("White can win in one move.");
                    else{
                        for (int i = 0; i < arr.length && !ws; i++)
                            for (int j = 0; j < arr.length && !ws; j++)
                                if(arr[i][j]=='U'){
                                    arr[i][j]='B';
                                    mem = new int[N][N];
                                    visitado = new boolean[N][N];
                                    for (int K = 0; K < arr.length; K++)if(arr[0][K]=='B')ws = ws || function(0, K, false);
                                    if(ws)
                                        break;
                                    arr[i][j]='U';
                                }
                        if(ws)System.out.println("Black can win in one move.");
                        else System.out.println("There is no winning path.");
                    }
                }
            }
            in.readLine();
        }
    }
}