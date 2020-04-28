package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 825
 * @problemName Walking on the Safe Side
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa825 {
    static int[][] arr;
    static boolean camino[][];
    static boolean cambio[][];
    static int caminos(int pos1, int pos2){
        if(pos1 == 0 && pos2 == 0)return 1;
        int cont = 0;
        if(pos1 > 0 && arr[pos1-1][pos2]==arr[pos1][pos2]-1)cont += caminos(pos1-1, pos2);
        if(pos2 > 0 && arr[pos1][pos2-1]==arr[pos1][pos2]-1)cont += caminos(pos1, pos2-1);
        if(pos1 < arr.length - 1 && arr[pos1+1][pos2]==arr[pos1][pos2]-1)cont += caminos(pos1+1, pos2);
        if(pos2 < arr[0].length - 1&& arr[pos1][pos2+1]==arr[pos1][pos2]-1)cont += caminos(pos1, pos2+1);
        return cont;
    }
    static void hallarCamino(int pos1, int pos2){
        if((pos1 > arr.length && pos2 > arr[0].length) || cambio[pos1][pos2])return;
        cambio[pos1][pos2]=true;
        int min = arr[pos1][pos2];
       
        if(pos1>0&&!camino[pos1-1][pos2])min = Math.min(min, arr[pos1-1][pos2] + 1);
        if(pos1<arr.length-1&&!camino[pos1+1][pos2])min = Math.min(min, arr[pos1+1][pos2] + 1);
        if(pos2>0&&!camino[pos1][pos2-1])min = Math.min(min, arr[pos1][pos2-1] + 1);
        if(pos2<arr[0].length-1&&!camino[pos1][pos2+1])min = Math.min(min, arr[pos1][pos2+1] + 1);       
       
        if(min < arr[pos1][pos2]){
            arr[pos1][pos2]=min;
            //cambio[pos1][pos2]=false;
            if(pos1>0&&!camino[pos1-1][pos2])cambio[pos1-1][pos2] = false;
            if(pos1<arr.length-1&&!camino[pos1+1][pos2])cambio[pos1+1][pos2] = false;
            if(pos2>0&&!camino[pos1][pos2-1])cambio[pos1][pos2-1] = false;
            if(pos2<arr[0].length-1&&!camino[pos1][pos2])cambio[pos1][pos2+1] = false;   
        }
       
        if(pos1>0&&!camino[pos1-1][pos2])hallarCamino(pos1-1, pos2);
        if(pos1<arr.length-1&&!camino[pos1+1][pos2])hallarCamino(pos1+1, pos2);
        if(pos2>0&&!camino[pos1][pos2-1])hallarCamino(pos1, pos2 - 1);
        if(pos2<arr[0].length-1&&!camino[pos1][pos2+1])hallarCamino(pos1, pos2 + 1);
       
    }
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0, N = parseInt(in.readLine().trim()); i < N; i++) {
            in.readLine();
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            arr = new int[parseInt(st.nextToken())][parseInt(st.nextToken())];
            camino = new boolean[arr.length][arr[0].length];
            for (int j = 0; j < arr.length; j++) {
                st = new StringTokenizer(in.readLine().trim());
                int I = parseInt(st.nextToken());
                while(st.hasMoreTokens())
                    camino[I - 1][parseInt(st.nextToken()) - 1]=true;
            }
            for (int j = 0; j < arr.length; j++) Arrays.fill(arr[j], MAX_VALUE - 1);
            arr[0][0] = 0;
            if(!camino[0][1]){
                cambio = new boolean[arr.length][arr[0].length];
                cambio[0][0]=true;
                hallarCamino(0, 1);
            }
            else if(!camino[1][0]){
                cambio = new boolean[arr.length][arr[0].length];
                cambio[0][0]=true;
                hallarCamino(1, 0);
            }
            if(arr[arr.length-1][arr[0].length - 1]==MAX_VALUE||arr[arr.length-1][arr[0].length - 1]==MAX_VALUE-1)System.out.println(0);
            else System.out.println(caminos(arr.length-1, arr[0].length - 1));
            if(i<N-1)System.out.println();
        }
    }
}
