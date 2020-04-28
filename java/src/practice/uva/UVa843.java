package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 843
 * @problemName Crypt Kicker 
 * @judge http://uva.onlinejudge.org/
 * @category Backtracking
 * @level easy
 * @date 10/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa843 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		diccionario = new TreeMap<Integer, ArrayList<char[]>>();
		for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
			String str = in.readLine().trim();
			if(!diccionario.containsKey(str.length()))
				diccionario.put(str.length(), new ArrayList<char[]>());
			diccionario.get(str.length()).add(str.toCharArray());
		}
		for (String ln; (ln = in.readLine()) != null; ) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			char[] linea = ln.toCharArray();
			palabras = new ArrayList<char[]>(); 
			while(st.hasMoreTokens())palabras.add(st.nextToken().toCharArray());
			if(function(new TreeSet<Character>(), new TreeMap<Character, Character>(), 0, 0))
				/*for (int i = 0; i < palabras.size(); i++) {
					for (char ch: palabras.get(i)) 
						sb.append(solucion.get(ch));
					sb.append(i < palabras.size() - 1?" ":"");
				}
			else
				for (int i = 0; i < palabras.size(); i++) {
					for (char ch: palabras.get(i)) 
						sb.append("*");
					sb.append(i < palabras.size() - 1?" ":"");
				}*/
				for (int i = 0; i < linea.length; i++) {
					Character ch = solucion.get(linea[i]);
					if(ch != null)sb.append(ch);
					else sb.append(linea[i]);
				}
			else{
				for (int i = 0; i < linea.length; i++) {
					if(linea[i]!=' ')sb.append("*");
					else sb.append(linea[i]);
				}
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	static ArrayList<char[]> palabras;
	static TreeMap<Integer, ArrayList<char[]>> diccionario;
	static TreeMap<Character, Character> solucion;
	static boolean function(TreeSet<Character> utilizados, TreeMap<Character, Character> alfabeto, int posPalabra, int posDiccionario){
		if(posPalabra == palabras.size()){
			solucion = (TreeMap<Character, Character>)alfabeto.clone();
			return true;
		}
		ArrayList<char[]> palabrasTamano = diccionario.get(palabras.get(posPalabra).length);
		if(palabrasTamano == null)return false;
		if(posDiccionario == palabrasTamano.size())return false;
		TreeMap<Character, Character> nuevos = new TreeMap<Character, Character>();
		for (int i = 0; i < palabras.get(posPalabra).length; i++) {
			Character ch = alfabeto.get(palabras.get(posPalabra)[i]);
			if(ch == null){
				if(utilizados.contains(palabrasTamano.get(posDiccionario)[i])){
					for(Entry<Character, Character> c: nuevos.entrySet()){
						alfabeto.remove(c.getKey());
						utilizados.remove(c.getValue());
					}
					return function(utilizados, alfabeto, posPalabra, posDiccionario + 1);
				}
				alfabeto.put(palabras.get(posPalabra)[i], palabrasTamano.get(posDiccionario)[i]);
				utilizados.add(palabrasTamano.get(posDiccionario)[i]);
				nuevos.put(palabras.get(posPalabra)[i], palabrasTamano.get(posDiccionario)[i]);
			}
			else{
				if(!ch.equals(palabrasTamano.get(posDiccionario)[i])){
					for(Entry<Character, Character> c: nuevos.entrySet()){
						alfabeto.remove(c.getKey());
						utilizados.remove(c.getValue());
					}
					return function(utilizados, alfabeto, posPalabra, posDiccionario + 1);
				}
			}
		}
		boolean ws = function(utilizados, alfabeto, posPalabra + 1, 0);
		for(Entry<Character, Character> c: nuevos.entrySet()){
			alfabeto.remove(c.getKey());
			utilizados.remove(c.getValue());
		}
		return ws || function(utilizados, alfabeto, posPalabra, posDiccionario + 1);
	}
}
