package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 536
 * @problemName Tree Recovery 
 * @judge http://uva.onlinejudge.org/
 * @category tree
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa536 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null; ){
			StringTokenizer st = new StringTokenizer(ln.trim());
			System.out.println(postOrden(armarArbol(st.nextToken(), st.nextToken())));
		}
	}
	static Arbol armarArbol(String preOrden, String inOrden){
		if(preOrden.length()==0)return null;
		if(preOrden.length()>1)
			return new Arbol(preOrden.charAt(0) + "", armarArbol(preOrden.substring(1, inOrden.indexOf(preOrden.charAt(0)) + 1), inOrden.substring(0, inOrden.indexOf(preOrden.charAt(0)))), armarArbol(preOrden.substring(inOrden.indexOf(preOrden.charAt(0)) + 1), inOrden.substring(inOrden.indexOf(preOrden.charAt(0)) + 1)));
		return new Arbol(preOrden, null, null);
	}
	static String postOrden(Arbol arb){
		if(arb == null)return "";
		return postOrden(arb.izq) + postOrden(arb.der) + arb.cabecera;
	}
	static class Arbol{
		String cabecera;
		Arbol izq, der;
		Arbol(String cabecera, Arbol izq, Arbol der){
			this.cabecera = cabecera;
			this.izq = izq;
			this.der = der;
		}
	}
}
