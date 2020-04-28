package practice.codejam;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e03
 * @category greedy
 * @date March, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CodeJam20191AB {

    static int solve(int N,int M,Scanner sc) {
        TreeSet<Integer> R=new TreeSet<>();
        for(int i=1;i<=M;i++)R.add(i);
        for(int i=0;i<M&&R.size()>1&&i<17;i++) {
            String line = "";
            for(int j=0;j<18;j++)
                line+=(18-i)+" ";
            System.out.println(line);
            int sum=0;
            for(int j=0;j<18;j++)
                sum+=sc.nextInt();
            TreeSet<Integer> r=new TreeSet<>();
            for(int j=0;sum+j*(18-i)<=M;j++)
                if(R.contains(sum+j*(18-i)))
                    r.add(sum+j*(18-i));
            R=r;
        }
        return R.size()==0?-1:R.first();
    }

    public static void main(String args[]) throws Throwable{
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(),N=sc.nextInt(),M=sc.nextInt(),R=1;
        for(int t=0;t++<T&&R==1;) {
            int r = solve(N, M, sc);
            if(r==-1)break;
            System.out.println(r);
            R=sc.nextInt();
        }
    }
}
