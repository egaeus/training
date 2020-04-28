package practice.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1251C {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q = parseInt(in.readLine()), q = 0; q++ < Q; ) {
            char[] a = in.readLine().toCharArray();
            int N = a.length;
            Node[] nodes = new Node[N];
            for (int i = 0; i < a.length; i++) {
                nodes[i] = new Node();
                nodes[i].val = a[i] - '0';
                if (i > 0) {
                    nodes[i - 1].next = nodes[i];
                    nodes[i].prior = nodes[i - 1];
                }
            }
            Node first = nodes[0];
            for (int i = N - 1; i >= 0; i--)
                if (nodes[i].next == null)
                    nodes[i].nextOdd = null;
                else if (nodes[i].val % 2 != nodes[i].next.val % 2) {
                    nodes[i].nextOdd = nodes[i].next;
                    nodes[i].nextMy = nodes[i].next.nextOdd;
                } else {
                    nodes[i].nextOdd = nodes[i].next.nextOdd;
                    nodes[i].nextMy = nodes[i].next;
                }
            //System.out.println(first.toString());
            for (Node node = first; node != null; node = node.next) {
                //System.out.println("Node: " + node.toString(false));
                if (node.nextOdd != null) {
                    Node nextOdd = node.nextOdd;
                    for (; node.val <= nextOdd.val && node != nextOdd; node = node.next)
                        node.nextOdd = nextOdd;
                    if (node != nextOdd) {
                        if (nextOdd.prior != null)
                            nextOdd.prior.next = nextOdd.next;
                        if (nextOdd.next != null)
                            nextOdd.next.prior = nextOdd.prior;
                        nextOdd.prior = node.prior;
                        if (node.prior != null)
                            node.prior.next = nextOdd;
                        else first = nextOdd;
                        nextOdd.next = node;
                        node.prior = nextOdd;
                        node.nextOdd = nextOdd.nextMy;
                    }
                    node = node.prior;
                    //System.out.println("----------------");
                    //System.out.println(first.toString(true));
                } else if (node.next != null && node.val % 2 == node.next.val % 2)
                    node.next.nextOdd = node.nextOdd;

            }
            StringBuilder sb = new StringBuilder();
            for (Node node = first; node != null; node = node.next)
                sb.append(node.val);
            System.out.println(new String(sb));
        }
    }

    static class Node {
        int val;
        Node next;
        Node nextOdd;
        Node prior;
        Node nextMy;

        @Override
        public String toString() {
            return toString(true);
        }

        public String toString(boolean withChilds) {
            String str = "(val: " + val + ", next: " + (next != null ? next.val : null) + ", prior: " + (prior != null ? prior.val : null) + ", nextOdd: " + (nextOdd != null ? nextOdd.val : null) + ", nextMy: " + (nextMy != null ? nextMy.val : null) + ")";
            if (next != null && withChilds) {
                str += "\n" + next.toString();
            }
            return str;
        }
    }
}