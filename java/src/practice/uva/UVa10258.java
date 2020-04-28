package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10258
 * @problemName Contest Scoreboard 
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 13/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa10258 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
			if(c==0)in.readLine();
			TreeMap<Integer, TreeMap<Integer, Integer>> problems = new TreeMap<Integer, TreeMap<Integer,Integer>>();
			TreeSet<int[]> solucionados = new TreeSet<int[]>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[0]<o2[0])return -1;
					if(o1[0]>o2[0])return 1;
					if(o1[1]<o2[1])return -1;
					if(o1[1]>o2[1])return 1;
					return 0;
				}
			});
			for (String ln; ((ln = in.readLine()) != null) && !ln.trim().equals("");) {
				StringTokenizer st = new StringTokenizer(ln.trim());
				int contestat = parseInt(st.nextToken()), p = parseInt(st.nextToken()), time = parseInt(st.nextToken());
				char res = st.nextToken().charAt(0);
				if(!problems.containsKey(contestat))problems.put(contestat, new TreeMap<Integer, Integer>());
				TreeMap<Integer, Integer> problem = problems.get(contestat);
				if(!problem.containsKey(p))problem.put(p, 0);
				switch(res){
					case 'C':{
						if(!solucionados.contains(new int[]{contestat, p})){
							problem.put(p, problem.get(p) + time);
							solucionados.add(new int[]{contestat, p});
						}
						break;
					}
					case 'I':{
						if(!solucionados.contains(new int[]{contestat, p}))
							problem.put(p, problem.get(p) + 20);
						break;
					}
				}
			}
			int[][] solucion = new int[problems.size()][3];
			int i = 0;
			for (Entry<Integer, TreeMap<Integer, Integer>> entry: problems.entrySet()) {
				solucion[i][0] = entry.getKey();
				for(Entry<Integer, Integer> p: entry.getValue().entrySet())
					if(solucionados.contains(new int[]{entry.getKey(), p.getKey()})){
						solucion[i][1]++;
						solucion[i][2]+=p.getValue();
					}
				i++;
			}
			Arrays.sort(solucion, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1]<o2[1])return 1;
					if(o1[1]>o2[1])return -1;
					if(o1[2]<o2[2])return -1;
					if(o1[2]>o2[2])return 1;
					if(o1[0]<o2[0])return -1;
					if(o1[0]>o2[0])return 1;
					return 0;
				}
			});
			for (int j = 0; j < solucion.length; j++) 
				sb.append(Arrays.toString(solucion[j]).replaceAll("[\\[\\],]", "") + "\n");
			if(c < C-1)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
