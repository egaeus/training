package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 442
 * @problemName Matrix Chain Multiplication
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 28/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa442{
	static int[] sol(String exp){
		try{
			if(exp.length()==1)return new int[]{0,mapa.get(exp.charAt(0))[0],mapa.get(exp.charAt(0))[1]};
			else{
				int[] solIzq,solDer;
				if(Character.isLetter(exp.charAt(0))){
					solIzq=sol(exp.charAt(0)+"");
					solDer=sol(exp.substring(1));
				}
				else{
					if(exp.charAt(0)==')')return null;
					int par=1,i=1;
					for(;par!=0&&i<exp.length();i++)if(exp.charAt(i)==')')par--;else if(exp.charAt(i)=='(')par++;
					if(par==0&&i==exp.length())return sol(exp.substring(1,exp.length()-1));
					solIzq=sol(exp.substring(1,i-1));
					solDer=sol(exp.substring(i));
				}
				if(solIzq==null||solDer==null)return null;
				if(solIzq[2]!=solDer[1])return null;
				return new int[]{solIzq[0]+solDer[0]+solIzq[1]*solIzq[2]*solDer[2],solIzq[1],solDer[2]};
			}
		}catch(Exception e){return null;}
	}
	static TreeMap<Character,int[]> mapa=new TreeMap<Character,int[]>();
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N=parseInt(in.readLine().trim()),n=0;n++<N;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			mapa.put(st.nextToken().charAt(0),new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())});
		}
		for(String ln;(ln=in.readLine())!=null;){
			int[] sol=sol(ln.trim());
			System.out.println(sol==null?"error":sol[0]);
		}
	}
}
