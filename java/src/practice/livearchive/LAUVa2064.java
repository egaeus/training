package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2064
 * @problemName Falling Leaves
 * @judge http://livearchive.onlinejudge.org/
 * @category trees
 * @level easy
 * @date 16/11/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2064 {
	static class Arbol{
		char letra;
		Arbol izq, der;
		Arbol(char letra, Arbol izq, Arbol der){
			this.letra=letra;
			this.izq=izq;
			this.der=der;
		}
		void add(char c){
			if(letra=='\0'){
				letra=c;
				izq=new Arbol('\0',null,null);
				der=new Arbol('\0',null,null);
			}
			else if(letra>c)izq.add(c);
			else der.add(c);
		}
		String preOrden(){
			if(letra=='\0')return "";
			return letra+izq.preOrden()+der.preOrden();
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0;;c=0){
			String ln;
			char[][] arr=new char[1000][];
			for(;!(ln=in.readLine().trim()).equals("$")&&!ln.equals("*");)arr[c++]=ln.toCharArray();
			Arbol arbol=new Arbol('\0',null,null);
			for(int i=c-1;i>=0;i--)for(char h:arr[i])arbol.add(h);
			System.out.println(arbol.preOrden());
			if(ln.equals("$"))break;
		}
	}
}
