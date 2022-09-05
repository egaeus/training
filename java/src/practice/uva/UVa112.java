package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 112
 * @problemName  Tree Summing 
 * @judge http://uva.onlinejudge.org/
 * @category trees
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
public class UVa112 {
	static class Arbol{
		int valor;
		Arbol izq,der;
		Arbol(String str){
			str=str.substring(1,str.length()-1);
			if(str.length()>0){
				char[] s=str.toCharArray();
				valor=parseInt(str.substring(0,str.indexOf("(")));
				int desde=str.indexOf("("),i,c;
				for(i=desde+1,c=1;c!=0;i++)if(s[i]=='(')c++;else if(s[i]==')')c--;
				if(i-desde>2)izq=new Arbol(str.substring(desde,i));
				if(str.length()-i>2)der=new Arbol(str.substring(i));
			}
			else valor=MIN_VALUE;
		}
		public String toString(){
			return "("+valor+(izq==null?"()":izq.toString())+(der==null?"()":der.toString())+")";
		}
		public TreeSet<Integer> getValores(){
			return getValores(0);
		}
		private TreeSet<Integer> getValores(int suma){
			TreeSet<Integer> res=new TreeSet<Integer>();
			if(izq==null&&der==null)res.add(suma+valor);
			else {
				if(izq!=null)res.addAll(izq.getValores(suma+valor));
				if(der!=null)res.addAll(der.getValores(suma+valor));
			}
			return res;
		}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] caso=new char[1000000];int p=0,c=0;
		boolean ws=false;
		for(int C;(C=in.read())!=-1;){
			char ch=(char)C;
			if(ch=='('||ch==')'||ch=='-'||Character.isDigit(ch))
				caso[p++]=ch;
			ws|=ch=='(';
			if(ch=='(')c++;
			if(ch==')')c--;
			if(ws&&c==0){
				int i=0;
				for(;i<p;i++)if(caso[i]=='(')break;
				int N=parseInt(new String(caso,0,i));
				System.out.println(new Arbol(new String(caso,i,p-i)).getValores().contains(N)?"yes":"no");
				p=0;
				ws=false;
			}
		}
	}
}
