package practice.codejam; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url https://codingcompetitions.withgoogle.com/codejam/round/0000000000000130/00000000000004c0
 * @category greedy
 * @date March, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CodeJam2018PSB {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(":");
            int N=parseInt(in.readLine());
            int[] A=new int[N];
            StringTokenizer st=new StringTokenizer(in.readLine());
            int sum=0;
            for(int i=0;i<N;i++) {
                A[i] = parseInt(st.nextToken());
                sum+=A[i];
            }
            for(;sum>0;) {
                boolean ws=false;
                for(int i=0;i<N&&!ws;i++) {
                    for (int j = i + 1; j < N && !ws; j++) {
                        if(A[i]>0&&A[j]>0) {
                            A[i]--;
                            A[j]--;
                            boolean can = true;
                            for (int k = 0; k < N && can; k++)
                                can = A[k] <= (sum - 2) / 2;
                            if (can) {
                                ws = true;
                                sb.append(" ").append((char) (i + 'A')).append((char) (j + 'A'));
                                sum-=2;
                            }
                            else {
                                A[i]++;
                                A[j]++;
                            }
                        }
                    }
                }
                if(!ws) {
                    for (int i = 0; i < N && !ws; i++) {
                        if (A[i] > 0) {
                            A[i]--;
                            boolean can=true;
                            for (int k = 0; k < N && can; k++)
                                can = A[k] <= (sum - 1) / 2;
                            if (can) {
                                sum--;
                                ws=true;
                                sb.append(" ").append((char) (i + 'A'));
                            }
                            else A[i]++;
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
