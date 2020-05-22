package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1234/D
 * @category segment tree
 * @date 02/10/2019
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1234D {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringBuilder sb = new StringBuilder();
            char[] str = ln.toCharArray();
            SegmentTree[] trees = new SegmentTree[26];
            for (int i = 0; i < 26; i++)
                trees[i] = SegmentTree.segmentTree(0, str.length);
            for (int i = 0; i < str.length; i++)
                trees[str[i] - 'a'].change(i, 1);
            int Q = parseInt(in.readLine());
            for (int q = 0; q < Q; q++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int o = parseInt(st.nextToken());
                if (o == 1) {
                    int p = parseInt(st.nextToken()) - 1;
                    char c = st.nextToken().charAt(0);
                    trees[c - 'a'].change(p, 1);
                    trees[str[p] - 'a'].change(p, -1);
                    str[p] = c;
                } else {
                    int l = parseInt(st.nextToken()) - 1;
                    int r = parseInt(st.nextToken());
                    int s = 0;
                    for (int i = 0; i < 26; i++)
                        s += trees[i].get(l, r)?1:0;
                    sb.append(s).append("\n");
                }
            }
            System.out.print(new String(sb));
        }
    }

    static class SegmentTree {
        private int value;
        private SegmentTree left;
        private SegmentTree right;
        private int limitLeft;
        private int limitRight;

        static SegmentTree segmentTree(int limitLeft, int limitRight) {
            if (limitRight == limitLeft)
                return null;
            SegmentTree segmentTree = new SegmentTree();
            segmentTree.value = 0;
            if (limitRight - limitLeft > 1) {
                segmentTree.left = segmentTree(limitLeft, (limitLeft + limitRight) / 2);
                segmentTree.right = segmentTree((limitLeft + limitRight) / 2, limitRight);
            }
            segmentTree.limitLeft = limitLeft;
            segmentTree.limitRight = limitRight;
            return segmentTree;
        }

        void change(int p, int v) {
            if (p >= limitLeft && p < limitRight) {
                value += v;
                if (left != null) left.change(p, v);
                if (right != null) right.change(p, v);
            }
        }

        boolean get(int l, int r) {
            if (l >= r || value==0) return false;
            if (limitLeft == l && limitRight == r)
                return value>0;
            if (left != null && left.get(l, Math.min(r, left.limitRight)))
                return true;
            if (right != null)
                return right.get(Math.max(l, right.limitLeft), r);
            return false;
        }
    }
}
