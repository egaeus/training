package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ANARC09D
 * @problemName Hop Do not Walk
 * @judge http://www.spoj.pl
 * @category graph
 * @level easy
 * @date 22/03/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
public class SPOJANARC09D {
	static class Nodo{
		int num, posF;
		char[] str;
		Nodo(int num, char[] str, int posF){
			this.num=num;
			this.str = str.clone();
			this.posF = posF;
		}
		public boolean esValida(){
			boolean negro = false, blanco = false;
			for(int i = 0; i < str.length; i++)
				if(str[i]=='B'){
					negro=true;
					if(blanco)return false;
				}
				else if(negro&&str[i]=='W')blanco=true;
			return true;
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		for(String ln; !(ln = in.readLine().trim()).contains("-"); caso++){
			LinkedList<Nodo> cola = new LinkedList<Nodo>();
			char[] str = ln.toCharArray();
			int posF = 0;
			for(int i = 0; i < str.length; i++)if(str[i]=='F')posF=i;
			cola.add(new Nodo(0, str, posF));
			TreeSet<char[]> visitados = new TreeSet<char[]>(new Comparator<char[]>() {
				public int compare(char[] o1, char[] o2) {
					for(int i = 0; i < o1.length; i++)
						if(o1[i]<o2[i])return -1;
						else if(o1[i]>o2[i])return 1;
					return 0;
				}
			});
			visitados.add(ln.toCharArray());
			int sol = -1;
			while(!cola.isEmpty()){
				Nodo d = cola.pollFirst();
				if(d.num==11)cola.clear();
				else if(d.esValida()){
					sol = d.num;
					cola.clear();
				}
				else{
					char[] nuevo = d.str;
					if(d.posF>0){
						nuevo[d.posF]=nuevo[d.posF-1];
						nuevo[d.posF-1]='F';
						if(!visitados.contains(nuevo)){
							visitados.add(nuevo.clone());
							cola.add(new Nodo(d.num+1, nuevo, d.posF-1));
						}
						nuevo[d.posF-1]=nuevo[d.posF];
						nuevo[d.posF]='F';
					}
					if(d.posF<d.str.length-1){
						nuevo[d.posF]=nuevo[d.posF+1];
						nuevo[d.posF+1]='F';
						if(!visitados.contains(nuevo)){
							visitados.add(nuevo.clone());
							cola.add(new Nodo(d.num+1, nuevo, d.posF+1));
						}
						nuevo[d.posF+1]=nuevo[d.posF];
						nuevo[d.posF]='F';
					}
					if(d.posF>1){
						nuevo[d.posF]=nuevo[d.posF-2]=='W'?'B':'W';
						nuevo[d.posF-2]='F';
						if(!visitados.contains(nuevo)){
							visitados.add(nuevo.clone());
							cola.add(new Nodo(d.num+1, nuevo, d.posF-2));
						}
						nuevo[d.posF-2]=nuevo[d.posF]=='W'?'B':'W';
						nuevo[d.posF]='F';
					}
					if(d.posF<d.str.length-2){
						nuevo[d.posF]=nuevo[d.posF+2]=='W'?'B':'W';
						nuevo[d.posF+2]='F';
						if(!visitados.contains(nuevo)){
							visitados.add(nuevo.clone());
							cola.add(new Nodo(d.num+1, nuevo, d.posF+2));
						}
						nuevo[d.posF+2]=nuevo[d.posF]=='W'?'B':'W';
						nuevo[d.posF]='F';
					}
				}
			}
			System.out.println(caso+". "+sol);
		}
	}
}
