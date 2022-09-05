package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10194
 * @problemName Football (aka Soccer)
 * @judge http://uva.onlinejudge.org/
 * @category sort, warning: encoding
 * @level easy
 * @date 26/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.TreeMap;
public class UVa10194{
	static class Equipo implements Comparable<Equipo>{
		String nombre;
		int puntos, ganados, empatados, perdidos, golFavor, golContra, posicion;
		Equipo(String nombre, int posicion){
			this.nombre = nombre;
			this.posicion = posicion;
			puntos = ganados = empatados = perdidos = golFavor = golContra = 0;
		} 
		public void ingresaPartido(int golFavor, int golContra){
			boolean victoria = golFavor>golContra, empate = golFavor==golContra;
			puntos += victoria?3:(empate?1:0);
			ganados += victoria?1:0;
			empatados += empate?1:0;
			perdidos += (!victoria&&!empate)?1:0;
			this.golContra += golContra;
			this.golFavor += golFavor;
		}
		public int compareTo(Equipo o) {
			if(puntos > o.puntos)return 1;
			if(puntos < o.puntos)return -1;
			if(ganados > o.ganados)return 1;
			if(ganados < o.ganados)return -1;
			if(golFavor - golContra > o.golFavor - o.golContra)return 1;
			if(golFavor - golContra < o.golFavor - o.golContra)return -1;
			if(golFavor > o.golFavor)return 1;
			if(golFavor < o.golFavor)return -1;
			if(ganados + empatados + perdidos < o.ganados + o.empatados + o.perdidos)return 1;
			if(ganados + empatados + perdidos > o.ganados + o.empatados + o.perdidos)return -1;
			return nombre.toUpperCase().compareTo(o.nombre.toUpperCase())*-1;
		}
	}
	public static void main(String[] args) throws Throwable{
		OutputStreamWriter out=new OutputStreamWriter(System.out,"ISO-8859-1");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
		for (int i = 0, N = parseInt(in.readLine().trim()); i < N; i++) {
			String campeonato = in.readLine();
			Equipo[] equipos = new Equipo[parseInt(in.readLine().trim())];
			TreeMap<String, Integer> posEquipos = new TreeMap<String, Integer>();
			for (int j = 0; j < equipos.length; j++){
				equipos[j] = new Equipo(in.readLine(), j);
				posEquipos.put(equipos[j].nombre, j);
			}			
			for (int j = 0, G = parseInt(in.readLine().trim()); j < G; j++) {
				String arr[] = in.readLine().split("#");
				String resultado[] = arr[1].split("@");
				equipos[posEquipos.get(arr[0])].ingresaPartido(parseInt(resultado[0]), parseInt(resultado[1]));
				equipos[posEquipos.get(arr[2])].ingresaPartido(parseInt(resultado[1]), parseInt(resultado[0]));
			}
			Arrays.sort(equipos);
			out.append(campeonato + "\n");
			for (int j = equipos.length - 1; j >= 0; j--) {
				int pos = equipos.length - j;
				out.append(pos + ") " + equipos[j].nombre + " " + equipos[j].puntos + "p, " + (equipos[j].empatados+equipos[j].ganados+equipos[j].perdidos) + "g (" + equipos[j].ganados + "-" + equipos[j].empatados + "-" + equipos[j].perdidos + "), " + (equipos[j].golFavor-equipos[j].golContra) + "gd (" + equipos[j].golFavor + "-" + equipos[j].golContra + ")\n");
			}
			if(i < N-1)out.append("\n");
		}
		out.flush();
	}
}
