package _template;
/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.*;

import static java.lang.Integer.parseInt;

public class CodeJamTemplate {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(": ");

            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
