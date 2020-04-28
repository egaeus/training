package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @problemId 236
 * @problemName VTAS - Vessel Traffic Advisory Service
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 26/01/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa236 {
	static double matriz[][];
	static TreeMap<Character, Integer> nombres;
	static class Vessel{
		String nombre;
		char[] ruta;
		int[] horasRuta;
		double vel;
		int horaInicial;
		boolean ws;
		Vessel(String nombre){
			this.nombre = nombre;
		}
		boolean generarRuta(String ruta, double vel, int horaRuta){
			this.ruta = ruta.toCharArray();
			this.vel = vel;
			horaInicial = horaRuta;
			horasRuta = new int[this.ruta.length];
			horasRuta[0] = horaRuta;
			for(int i = 1; i < this.ruta.length; i++){
				if(!nombres.containsKey(this.ruta[i-1]) || !nombres.containsKey(this.ruta[i]) || matriz[nombres.get(this.ruta[i-1])][nombres.get(this.ruta[i])] == 0)return ws = false;
				int hora = horasRuta[i-1]/100, minutos = horasRuta[i-1]%100;
				minutos += (matriz[nombres.get(this.ruta[i-1])][nombres.get(this.ruta[i])]*60)/vel;
				hora = (hora + (minutos/60))%24;
				minutos %= 60;
				horasRuta[i] = hora*100 + minutos;
			}
			return ws = true;
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; ){
			int N = parseInt(ln.trim());
			char[] arr = in.readLine().trim().toCharArray();
			nombres = new TreeMap<Character, Integer>();
			for (int i = 0; i < arr.length; i++) 
				nombres.put(arr[i], i);
			matriz = new double[N][N];
			for (int i = 0; i < matriz.length; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < matriz.length; j++) matriz[i][j] = Double.parseDouble(st.nextToken());
			}
			ArrayList<Vessel> vessels = new ArrayList<Vessel>();
			for(; !(ln = in.readLine()).startsWith("*");){
				Vessel v = new Vessel(ln.trim());
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				int hora = parseInt(st.nextToken());
				double velocidad = Double.parseDouble(st.nextToken());
				v.generarRuta(in.readLine().trim(), velocidad, hora);
				vessels.add(v);
			}
			for(int i = 0; i < vessels.size(); i++){
				System.out.printf(Locale.US, "%s entering system at %s with a planned speed of %.1f knots%n", vessels.get(i).nombre, (vessels.get(i).horaInicial < 10?"000":(vessels.get(i).horaInicial<100?"00":(vessels.get(i).horaInicial<1000?"0":""))) + vessels.get(i).horaInicial, vessels.get(i).vel);
				if(vessels.get(i).ws){
					String str = "          Waypoint:";
					for (char c: vessels.get(i).ruta) str += "    " + c;
					str += "%n          Arrival:  ";
					for (int c: vessels.get(i).horasRuta) str += " " + (c < 10?"000":(c<100?"00":(c<1000?"0":""))) + c;
					System.out.printf(str + "%n");
					for (int j = 0; j < i; j++) 
						for (int k = 1; k < vessels.get(i).ruta.length; k++) 
							for (int h = 1; h < vessels.get(j).ruta.length; h++) 
								if(((vessels.get(i).ruta[k] == vessels.get(j).ruta[h] && vessels.get(i).ruta[k-1] == vessels.get(j).ruta[h-1]) || (vessels.get(i).ruta[k] == vessels.get(j).ruta[h-1] && vessels.get(i).ruta[k-1] == vessels.get(j).ruta[h])) && seEncuentran(vessels.get(i).horasRuta[k-1], vessels.get(i).horasRuta[k], vessels.get(j).horasRuta[h-1], vessels.get(j).horasRuta[h])){
									System.out.printf("Projected encounter with %s on leg between Waypoints %c & %c%n", vessels.get(j).nombre, vessels.get(i).ruta[k-1], vessels.get(i).ruta[k]);
									break;
								}
					for (int j = 0; j < i; j++) 
						for (int k = 0; k < vessels.get(i).ruta.length; k++) 
							for (int h = 0; h < vessels.get(j).ruta.length; h++) 
								if(vessels.get(i).ruta[k] == vessels.get(j).ruta[h] && (pasoCerrado(vessels.get(i).horasRuta[k], vessels.get(j).horasRuta[h], 0) || pasoCerrado(vessels.get(j).horasRuta[h], vessels.get(i).horasRuta[k], 0))){
									System.out.printf("** Warning ** Close passing with %s at Waypoint %c%n", vessels.get(j).nombre, vessels.get(i).ruta[k]);
									break;
								}
				}
				else
					System.out.printf("**> Invalid Route Plan for Vessel: %s%n", vessels.get(i).nombre);
				System.out.printf("%n");
			}
		}
	}
	static boolean seEncuentran(int horaInicio1, int horaFin1, int horaInicio2, int horaFin2){
		if(horaInicio1 <= horaFin1)return (horaInicio2 >= horaInicio1 && horaInicio2 <= horaFin1) || (horaFin2 >= horaInicio1 && horaFin2 <= horaFin1);
		return horaInicio2 >= horaInicio1 || horaFin2 >= horaInicio1 || horaInicio2 <= horaFin1 || horaFin2 <= horaFin1;
	}
	static boolean pasoCerrado(int hora1, int hora2, int pos){
		if(pos > 3)return false;
		if(hora1 == hora2)return true;
		hora1++;
		return pasoCerrado((hora1/100 + (hora1%100)/60) * 100 + (hora1%100)%60, hora2, pos + 1); 
	}
}
