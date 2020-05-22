package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1249/C2>
 * @category math
 * @date 22/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF1249C2 {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q=Integer.parseInt(in.readLine()),q=0; q++<Q; ) {
            long N = Long.parseLong(in.readLine());
            String str = "";
            for (int i = 0; N > 2; i++) {
                str = (N % 3) + str;
                N /= 3;
            }
            if(N>0)
                str = N + str;
            boolean ws = true;
            for (; ws; ) {
                ws = false;
                for (int i = str.length() - 1; i >= 0 && !ws; i--) {
                    if (str.charAt(i) == '2') {
                        ws = true;
                        int llevo = 1;
                        str = str.substring(0, i) + "0" + str.substring(i + 1);
                        i = i - 1;
                        for (; i >= 0 && llevo > 0; i--)
                            if (str.charAt(i) == '2')
                                str = str.substring(0, i) + "0" + str.substring(i + 1);
                            else {
                                llevo = 0;
                                int length = str.length();
                                str = str.substring(0, i) + (char) (str.charAt(i) + 1);
                                for(;i+1<length;i++)
                                    str+="0";
                            }
                        if (llevo > 0) {
                            String sol="1";
                            for(int k=0;k<str.length();k++)
                                sol +="0";
                            str=sol;
                        }
                        break;
                    }
                }
            }
            System.out.println(Long.parseLong(str,3));
        }
    }
}
