package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/158/C
 * @category implementation
 * @date 28/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF158C {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringBuilder sb = new StringBuilder();
            int N = parseInt(ln);
            Path root = new Path("", null);
            Path path = root;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                if (st.nextToken().equals("pwd"))
                    sb.append(path.toString()).append("\n");
                else {
                    String directory = st.nextToken();
                    st = new StringTokenizer(directory, "/");
                    if(directory.startsWith("/"))
                        path = root;
                    while (st.hasMoreTokens()) {
                        String name = st.nextToken();
                        if(name.equals(".."))
                            path = path.parent;
                        else
                            path = path.getChild(name);
                    }
                }
            }
            System.out.print(new String(sb));
        }
    }

    static class Path {
        private String name;
        private Path parent;
        private List<Path> children;

        Path(String name, Path parent) {
            this.name = name;
            this.parent = parent;
            children = new ArrayList<>();
        }

        @Override
        public String toString() {
            String str = name + "/";
            if (parent != null)
                str = parent.toString() + str;
            return str;
        }

        public Path getChild(String name) {
            for(Path child: children)
                if(child.name.equals(name))
                    return child;
            return new Path(name, this);
        }
    }
}
