package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 5139
 * @problemName Rare Order
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 10/11/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
public class LAUVa5139 {
	static TreeSet<Integer>[] lAdy;
	static void llenarGrafo(ArrayList<String> textos){
		TreeMap<Character, ArrayList<String>> diferentes=new TreeMap<Character, ArrayList<String>>();
		for(int i=0;i<textos.size();i++){
			if(textos.get(i).length()>1){
				ArrayList<String> list=diferentes.get(textos.get(i).charAt(0));
				if(list==null)list=new ArrayList<String>();
				list.add(textos.get(i).substring(1));
				diferentes.put(textos.get(i).charAt(0), list);
			}
			if(i>0&&textos.get(i).charAt(0)!=textos.get(i-1).charAt(0))
				lAdy[letras[textos.get(i-1).charAt(0)-'A']].add(letras[textos.get(i).charAt(0)-'A']);
		}
		for(Entry<Character,ArrayList<String>> entry:diferentes.entrySet())
			llenarGrafo(entry.getValue());
	}
	static LinkedList<Integer> sortTopologico(TreeSet<Integer>[] lAdy){
		LinkedList<Integer> res=new LinkedList<Integer>();
		boolean[] visitados=new boolean[lAdy.length];
		for(int i=0;i<lAdy.length;i++)if(!visitados[i])res.addAll(dfsST(lAdy,i,visitados));
		return res;
	}
	static LinkedList<Integer> dfsST(TreeSet<Integer>[] lAdy, int v, boolean[] visitados){
		LinkedList<Integer> res=new LinkedList<Integer>();
		visitados[v]=true;
		for(int u:lAdy[v])
			if(!visitados[u])res.addAll(dfsST(lAdy,u,visitados));
		res.add(v);
		return res;
	}
	static int[] letras;
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> palabras=new ArrayList<String>();
		letras=new int[26];Arrays.fill(letras,-1);int c=0;
		int[] numeros=new int[26];
		for(String ln;!(ln=in.readLine().trim()).equals("#");){			
			palabras.add(ln);
			char[] arr=ln.toCharArray();
			for(char a:arr)if(letras[a-'A']==-1){numeros[c]=a-'A';letras[a-'A']=c++;}
		}
		lAdy=new TreeSet[c];
		for(int i=0;i<c;i++)lAdy[i]=new TreeSet<Integer>();
		llenarGrafo(palabras);
		List<Integer> st=sortTopologico(lAdy);
		for(int i=st.size()-1;i>=0;i--)
			System.out.print((char)(numeros[st.get(i)]+'A'));
		System.out.println();
	}
}
