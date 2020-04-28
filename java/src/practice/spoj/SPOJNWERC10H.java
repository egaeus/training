package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId NWERC10H
 * @problemName Stock Prices
 * @judge http://www.spoj.pl
 * @category adhoc
 * @level easy
 * @date 23/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class SPOJNWERC10H {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			int N = parseInt(in.readLine().trim());
			TreeMap<Integer, Integer> compras = new TreeMap<Integer, Integer>(),
			ventas = new TreeMap<Integer, Integer>(), mapa = null;
			int negocio = -1;
			for(int k = 0; k < N; k++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				String trans = st.nextToken();
				int cant = parseInt(st.nextToken());
				st.nextToken(); st.nextToken();
				int precio = parseInt(st.nextToken());
				if(trans.equals("buy"))mapa=compras;
				else mapa = ventas;
				if(mapa.containsKey(precio))mapa.put(precio, mapa.get(precio)+cant);
				else mapa.put(precio, cant);
				for(;ventas.size()>0&&compras.size()>0&&ventas.firstEntry().getKey()<=compras.lastEntry().getKey();){
					negocio = ventas.firstKey();
					if(ventas.firstEntry().getValue()>compras.lastEntry().getValue()){
						ventas.put(ventas.firstEntry().getKey(), ventas.firstEntry().getValue()-compras.lastEntry().getValue());
						compras.remove(compras.lastKey());
					}
					else if(ventas.firstEntry().getValue()<compras.lastEntry().getValue()){
						compras.put(compras.lastEntry().getKey(), compras.lastEntry().getValue()-ventas.firstEntry().getValue());
						ventas.remove(ventas.firstKey());
					}
					else{
						compras.remove(compras.lastKey());
						ventas.remove(ventas.firstKey());
					}
				}
				System.out.println((ventas.size()==0?"-":ventas.firstKey())+" "+(compras.size()==0?"-":compras.lastKey())+" "+(negocio>0?negocio:"-"));
			}
		}
	}
}
