package practice.uva;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict TLE
 * @category graph
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class UVa13301 {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("aaaa.txt"));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            initSet(N);
            HashSet<Integer> lAdy[] = new HashSet[N];
            HashSet<Integer> lAdyC[] = new HashSet[N];
            for (int i = 0; i < N; i++)
                lAdy[i] = new HashSet<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int K = parseInt(st.nextToken());
                if (K == 1)
                    lAdy[parseInt(st.nextToken()) - 1].add(parseInt(st.nextToken()) - 1);
                else {
                    int first = parseInt(st.nextToken()) - 1;
                    for (int j = 0; j < K - 1; j++)
                        unionSet(first, parseInt(st.nextToken()) - 1);
                }
            }
            HashSet<Integer> newHashSet[] = new HashSet[_numDisjointSets];
            HashSet<Integer> newHashSetT[] = new HashSet[_numDisjointSets];
            int[] sets = new int[N];
            for (int i = 0; i < _numDisjointSets; i++) {
                newHashSet[i] = new HashSet<>();
                newHashSetT[i] = new HashSet<>();
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int set = findSet(i);
                Integer S = map.get(set);
                if (S == null) {
                    map.put(set, map.size());
                    S = map.size() - 1;
                }
                sets[i] = S;
            }
            for (int i = 0; i < N; i++) {
                int setI = sets[i];
                for (int v : lAdy[i]) {
                    int setV = sets[v];
                    if (setI != setV) {
                        newHashSet[setI].add(setV);
                        newHashSetT[setV].add(setI);
                    }
                }
            }
            System.out.println(kosaraju(newHashSet, newHashSetT) ? "YES" : "NO");
        }
    }

    static int nVisitados;

    static boolean kosaraju(HashSet<Integer>[] adjList, HashSet<Integer>[] adjListT) {
        int n = adjList.length;
        int[] orden = new int[n];
        boolean[] visitado = new boolean[n];
        nVisitados = 0;
        for (int i = 0; i < orden.length; i++)
            if (!visitado[i])
                dfs(i, orden, visitado, adjList);
        adjList = adjListT;
        visitado = new boolean[n];
        int nComponente = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (!visitado[orden[i]]) {
                if(nComponente>0)
                    return false;
                dfsComp(orden[i], visitado, nComponente, adjList);
                nComponente++;
            }
        }
        return true;
    }

    static void dfsComp(int nodo, boolean[] visitado, int nComponente, HashSet<Integer>[] adjList) {
        visitado[nodo] = true;
        for (int v : adjList[nodo]) {
            if (!visitado[v]) {
                dfsComp(v, visitado, nComponente, adjList);
            }
        }
    }

    static void dfs(int nodo, int[] orden, boolean[] visitado, HashSet<Integer>[] adjList) {
        visitado[nodo] = true;
        for (int v : adjList[nodo])
            if (!visitado[v])
                dfs(v, orden, visitado, adjList);
        orden[nVisitados] = nodo;
        nVisitados++;
    }

    public static int[] set;
    public static int _numDisjointSets;

    public static void initSet(int size) {
        set = new int[size];
        _numDisjointSets = size;
        for (int i = 0; i < size; i++)
            set[i] = i;
    }

    public static int findSet(int i) {
        return set[i] == i ? i : findSet(set[i]);
    }

    public static boolean isSameSet(int i, int j) {
        return (findSet(i) == findSet(j));
    }

    public static int findpatern(int i) {
        return findSet(i) == i ? i : findpatern(findSet(i));
    }

    public static void unionSet(int i, int j) {
        if (!isSameSet(i, j))
            _numDisjointSets--;
        set[findSet(i)] = findSet(j);
    }

    public static int numDisjointSets() {
        return _numDisjointSets;
    }

}
