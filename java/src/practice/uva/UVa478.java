package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 478
 * @problemName Points in Figures: Rectangles, Circles, Triangles
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 3/01/2012
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa478 {
	static interface Figura{
		boolean puntoDentroFigura(double px,double py);
	}
	static class Rectangulo implements Figura{
		private double x1,y1,x2,y2;
		public Rectangulo(double x1,double y1,double x2,double y2){
			this.x1=x1;
			this.x2=x2;
			this.y1=y1;
			this.y2=y2;
		}
		public boolean puntoDentroFigura(double px,double py) {
			return px<x2&&px>x1&&py<y1&&py>y2;
		}		
	}
	static class Triangulo implements Figura{
		private double x1,y1,x2,y2,x3,y3;
		public Triangulo(double x1,double y1,double x2,double y2,double x3,double y3){
			this.x1=x1;
			this.x2=x2;
			this.y1=y1;
			this.y2=y2;
			this.x3=x3;
			this.y3=y3;
		}
		private double dist(double px,double py,double px1,double py2){
			return sqrt((px-px1)*(px-px1)+(py-py2)*(py-py2));
		}
		private double area(){
			double a=dist(x1,y1,x2,y2),b=dist(x2,y2,x3,y3),c=dist(x3,y3,x1,y1),
			d=((c*c+b*b-a*a)/(2*c));
			return c*sqrt(b*b-d*d)/2;
		}
		public boolean puntoDentroFigura(double px,double py) {
			double t1=new Triangulo(x1,y1,x2,y2,px,py).area(),
			t2=new Triangulo(x1,y1,x3,y3,px,py).area(),t3=new Triangulo(x2,y2,x3,y3,px,py).area();
			return abs(area()-t1-t2-t3)<1e-5&&t1!=0&&t2!=0&&t3!=0;
		}
	}
	static class Circulo implements Figura{
		private double x,y,r;
		public Circulo(double x,double y,double r){
			this.x=x;
			this.y=y;
			this.r=r;
		}
		public boolean puntoDentroFigura(double px,double py) {
			return sqrt((x-px)*(x-px)+(y-py)*(y-py))<r;		
		}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Figura> figuras=new ArrayList<Figura>();
		for (String ln;(ln=in.readLine().trim()).charAt(0)!='*';) {
			StringTokenizer st=new StringTokenizer(ln);
			char ch=st.nextToken().charAt(0);
			if(ch=='r'){
				double x1=parseDouble(st.nextToken()),y1=parseDouble(st.nextToken()),
				x2=parseDouble(st.nextToken()),y2=parseDouble(st.nextToken());
				figuras.add(new Rectangulo(x1,y1,x2,y2));
			}
			if(ch=='c'){
				double x=parseDouble(st.nextToken()),y=parseDouble(st.nextToken()),r=parseDouble(st.nextToken());
				figuras.add(new Circulo(x,y,r));
			}
			if(ch=='t'){
				double x1=parseDouble(st.nextToken()),y1=parseDouble(st.nextToken()),
				x2=parseDouble(st.nextToken()),y2=parseDouble(st.nextToken()),
				x3=parseDouble(st.nextToken()),y3=parseDouble(st.nextToken());
				figuras.add(new Triangulo(x1,y1,x2,y2,x3,y3));
			}
		}
		StringBuilder sb=new StringBuilder();int p=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;p++){
			double x=parseDouble(st.nextToken()),y=parseDouble(st.nextToken());
			if(x==9999.9&&y==9999.9)break;
			boolean ws=false;
			for(int i=0;i<figuras.size();i++){
				if(figuras.get(i).puntoDentroFigura(x,y)){
					ws=true;
					sb.append("Point "+p+" is contained in figure "+(i+1)+"\n");
				}
			}
			if(!ws)sb.append("Point "+p+" is not contained in any figure\n");
		}
		System.out.print(new String(sb));
	}
}
