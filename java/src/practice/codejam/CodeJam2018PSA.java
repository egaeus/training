package practice.codejam; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codingcompetitions.withgoogle.com/codejam/round/0000000000000130/0000000000000523
 * @category binary search
 * @date March, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CodeJam2018PSA {

    static boolean solve(BufferedReader in) throws Throwable {
        StringTokenizer st =new StringTokenizer(in.readLine());
        int A=parseInt(st.nextToken()),B=parseInt(st.nextToken());
        int N=parseInt(in.readLine());
        A++;
        for(int i=0;A<=B&&i<N;i++) {
            int p=(A+B)/2;
            System.out.println(p);
            String response = in.readLine();
            if(response.equals("CORRECT"))return true;
            if(response.equals("WRONG_ANSWER"))return false;
            if(response.equals("TOO_SMALL"))A=p+1;
            if(response.equals("TOO_BIG"))B=p-1;
        }
        return false;
    }

    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        for(int t=0;t++<T;)
            if(!solve(in))break;
    }
}
