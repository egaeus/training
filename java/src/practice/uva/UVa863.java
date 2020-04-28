package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @problemId 863
 * @problemName Process Scheduling 
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level ?
 * @date 15/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa863 {
	static class Procedure{
		int tiempo;
		TreeSet<Integer> dependencias;
		Procedure(int tiempo){
			this.tiempo = tiempo;
			this.dependencias = new TreeSet<Integer>();
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int processors = parseInt(st.nextToken()), procedures = parseInt(st.nextToken());
			Procedure procedimientos[] = new Procedure[procedures];
			TreeSet<Integer> tareasPendientes = new TreeSet<Integer>();
			for(int i = 0; i < procedures; i++){
				tareasPendientes.add(i);
				st = new StringTokenizer(in.readLine().trim());
				procedimientos[i] = new Procedure(parseInt(st.nextToken()));
				for(;st.hasMoreTokens();)procedimientos[i].dependencias.add(parseInt(st.nextToken())-1);
			}
			for(;!tareasPendientes.isEmpty();){
				TreeSet<Integer> proceduresEliminados = new TreeSet<Integer>();
				String ln = ""; boolean primeraPasada = true;
				for (int i = 0, ultimo = 0, j = 0; proceduresEliminados.size() < tareasPendientes.size() && j < processors; i=(i+1)%procedures) {
					if(tareasPendientes.contains(i) && !proceduresEliminados.contains(i)){
						boolean ws = true;
						for(Integer r: tareasPendientes)if(procedimientos[i].dependencias.contains(r)){ws=false;break;}
						if(ws){
							ultimo = i;
							j++;
							ln += (i < 9?" ":"") + (i + 1) + " ";
							procedimientos[i].tiempo--;
							if(procedimientos[i].tiempo == 0)proceduresEliminados.add(i);
						}
						else if(ultimo==i && !primeraPasada)break;
					}
					else if(ultimo==i && !primeraPasada)break;
					primeraPasada = false;
				}
				if(ln.equals(""))break;
				System.out.println(ln.substring(0, ln.length() - 1));
				tareasPendientes.removeAll(proceduresEliminados);
			}
			if(c < C - 1)System.out.println();
		}
	}
}
