package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 477
 * @problemName Points in Figures: Rectangles and Circles 
 * @judge http://uva.onlinejudge.org/
 * @category geometry
 * @level easy
 * @date 2010
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa477 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		ArrayList<Figura> figuras = new ArrayList<Figura>(); 
		for (String ln; !(ln = in.readLine().trim()).equals("*"); ) {
			String[] arr = ln.split(" +");
			if(arr[0].equals("r")){
				Cuadrado c = new Cuadrado('r', new Punto(parseDouble(arr[1]), parseDouble(arr[2])), new Punto(parseDouble(arr[3]), parseDouble(arr[4])));
				figuras.add(c);
			}
			if(arr[0].equals("c")){
				Circulo c = new Circulo('c', new Punto(parseDouble(arr[1]), parseDouble(arr[2])), parseDouble(arr[3]));
				figuras.add(c);
			}
		}
		int cont = 0;
		while(true){
			cont++;
			String[] arr = in.readLine().trim().split(" +");
			Punto p = new Punto(parseDouble(arr[0]), parseDouble(arr[1]));
			if(p.x == 9999.9 && p.y == 9999.9)break;
			boolean ws = false;
			for (int i = 0; i < figuras.size(); i++)
				if(p.puntoDentroDeFigura(figuras.get(i))){
					sb.append("Point " + cont + " is contained in figure " + (i+1) + "\n");
					ws = true;
				}
			if(!ws)sb.append("Point " + cont + " is not contained in any figure\n");
		}
		System.out.print(new String(sb));
	}
	static class Punto{
		public double x, y;
		Punto(double x, double y){this.x = x; this.y = y;}
		public boolean puntoDentroDeFigura(Figura fig){
			if(fig.tipo == 'r')return puntoDentroDeFigura((Cuadrado)fig);
			return puntoDentroDeFigura((Circulo)fig);
		}
		private boolean puntoDentroDeFigura(Circulo cir){
			return Math.pow((cir.c.x - x)*(cir.c.x - x) + (cir.c.y - y)*(cir.c.y - y), 0.5)<cir.r;
		}
		private boolean puntoDentroDeFigura(Cuadrado cua){
			if(x <= cua.ul.x)return false;
			if(x >= cua.dr.x)return false;
			if(y <= cua.dr.y)return false;
			if(y >= cua.ul.y)return false;
			return true;
		}
	}
	static class Figura{
		char tipo;
		Figura(char tipo){this.tipo = tipo;}
	}
	static class Circulo extends Figura{
		Punto c;
		double r;
		Circulo(char tipo, Punto c, double r){super(tipo);this.c = c; this.r = r;};
	}
	static class Cuadrado  extends Figura{
		Punto ul, dr;/*ul: up left, dr: down rigth*/
		Cuadrado(char tipo, Punto ul, Punto dr){super(tipo);this.ul = ul; this.dr = dr;}
	}
}
