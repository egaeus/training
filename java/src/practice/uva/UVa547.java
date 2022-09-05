package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 547
 * @problemName DDF
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 20/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa547 {
    static ArrayList<Integer>[] res;
    static ArrayList<Integer> function(int n){
        if(res[n] != null)return res[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                char[] temp = ("" + i).toCharArray();
                for (int j = 0; j < temp.length; j++)
                    sum += temp[j] - '0';           
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(n);
        if(sum != n)result.addAll(function(sum));
        return res[n] = result;
    }
    public static void main(String[] args) throws Throwable {
        res = new ArrayList[3001];
        res[0] = new ArrayList<Integer>();
        for (int i = 1; i < res.length; i++)
            function(i);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int caso = 1;
        for(String ln; (ln = in.readLine()) != null; ){
            StringTokenizer st = new StringTokenizer(ln.trim());
            int desde = parseInt(st.nextToken()), hasta = parseInt(st.nextToken());
            int max = 0, val = 0;
            for (int i = Math.min(desde, hasta); i <= Math.max(desde, hasta); i++)
                if(res[i].size() > max){
                    max = res[i].size();
                    val = i;
                }
            sb.append("Input" + caso + ": " + desde + " " + hasta + "\nOutput" + caso++ + ":");
            for (int i: res[val])sb.append(" " + i);
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}