package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1234/B2>
 * @category implementation
 * @date 01/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF1234B2 {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(String ln;(ln=in.readLine())!=null;) {
            StringTokenizer st = new StringTokenizer(ln);
            int N=parseInt(st.nextToken()), K=parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            TreeSet<Integer> set = new TreeSet<>();
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++) {
                int id = parseInt(st.nextToken());
                if(!set.contains(id)) {
                    if(list.size()==K) {
                        int removed = list.removeLast();
                        set.remove(removed);
                    }
                    list.addFirst(id);
                    set.add(id);
                }
            }
            System.out.println(list.size());
            System.out.println(list.stream().map(a -> ""+a).collect(Collectors.joining(" ")));
        }
    }
}
