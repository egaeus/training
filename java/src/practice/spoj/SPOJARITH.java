package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId ARITH
 * @problemName Simple Arithmetics
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy(mam�n)
 * @date 14/03/2011
 **/
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SPOJARITH {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = Integer.parseInt(in.readLine().trim()); c++ < C;){
			int operacion = 0;
			StringTokenizer st = null;
			String ln = in.readLine();
			if(ln.contains("+"))st = new StringTokenizer(ln, "+");
			if(ln.contains("-")){st = new StringTokenizer(ln, "-");operacion=1;}
			if(ln.contains("*")){st = new StringTokenizer(ln, "*");operacion=2;}
			char[] str1 = st.nextToken().toCharArray(), str2 = st.nextToken().toCharArray();
			int max = 0;
			char[][] solucion = null;
			if(operacion==0){
				solucion = new char[4][1005];
				for(int i = 0; i < solucion.length; i++)Arrays.fill(solucion[i], ' ');
				for(int i = str1.length - 1, k = 0; i >= 0; i--, k++)solucion[0][solucion[0].length-1-k]=str1[i];
				for(int i = str2.length - 1, k = 0; i >= 0; i--, k++)solucion[1][solucion[1].length-1-k]=str2[i];
				solucion[1][solucion[1].length-str2.length-1]='+';
				max = max(str1.length, str2.length+1);
				int lSuma = suma(str1, str2, solucion[3], 0);
				max = max(max, lSuma);
				for(int i = 0; i < max(str2.length+1, lSuma); i++)solucion[2][solucion[2].length-1-i]='-';
			}
			if(operacion==1){
				solucion = new char[4][1005];
				for(int i = 0; i < solucion.length; i++)Arrays.fill(solucion[i], ' ');
				for(int i = str1.length - 1, k = 0; i >= 0; i--, k++)solucion[0][solucion[0].length-1-k]=str1[i];
				for(int i = str2.length - 1, k = 0; i >= 0; i--, k++)solucion[1][solucion[1].length-1-k]=str2[i];
				solucion[1][solucion[1].length-str2.length-1]='-';
				max = max(str1.length, str2.length+1);
				int lResta = resta(str1, str2, solucion[3]);
				max = max(max, lResta);
				for(int i = 0; i < max(str2.length+1, lResta); i++)solucion[2][solucion[2].length-1-i]='-';
			}
			if(operacion==2){
				solucion = new char[str2.length>1?(5+str2.length):4][1005];
				for(int i = 0; i < solucion.length; i++)Arrays.fill(solucion[i], ' ');
				for(int i = str1.length - 1, k = 0; i >= 0; i--, k++)solucion[0][solucion[0].length-1-k]=str1[i];
				for(int i = str2.length - 1, k = 0; i >= 0; i--, k++)solucion[1][solucion[1].length-1-k]=str2[i];
				solucion[1][solucion[1].length-str2.length-1]='*';
				max = max(str1.length, str2.length+1);
				int lMultiplicacion = multiplicacion(str1, str2, solucion, 3, str2.length+1);
				max = max(max, lMultiplicacion);
			}
			for(int i = 0; i < solucion.length; i++)
				sb.append(new String(Arrays.copyOfRange(solucion[i], solucion[i].length - max, solucion[i].length)) + "\n");
			sb.append("\n");
			if(sb.length() > 100000){System.out.print(new String(sb)); sb = new StringBuilder();}
		}
		System.out.print(new String(sb));
	}
	static int resta(char[] n, char[] m, char[] sol){
		boolean carry = false;
		int K = 0;
		for(int i = n.length - 1, j = m.length - 1; i >= 0 && j>= 0; i--,j--,K++){
			int a = n[i] - '0', b = (m[j] - '0') + (carry?1:0);
			carry = b > a;
			if(carry)sol[sol.length-1-K]=(char)((10-b)+a+'0');
			else sol[sol.length-1-K]=(char)(a-b+'0');
		}
		for(int i = max(n.length, m.length)-min(n.length, m.length)-1; i >= 0; i--, K++){
			int a = n[i] - '0', b = carry?1:0;
			carry = b > a;
			if(carry)sol[sol.length-1-K]=(char)((10-b)+a+'0');
			else sol[sol.length-1-K]=(char)(a-b+'0');		
		}
		for(; K > 1; K--)
			if(sol[sol.length-K]=='0')sol[sol.length-K]=' ';
			else break;
		return K;
	}
	static int suma(char[] n, char[] m, char[] sol, int posicion){
		int carry = 0, K = posicion;
		for(int i = n.length - 1, j = m.length - 1; i >= 0 && j>= 0; i--,j--,K++){
			sol[sol.length-1-K]=(char)(((n[i]-'0')+(m[j]-'0')+carry)%10 + '0');
			carry = ((n[i]-'0')+(m[j]-'0')+carry)/10;
		}
		for(int i = max(n.length, m.length)-min(n.length, m.length)-1; i >= 0; i--, K++){
			sol[sol.length-1-K]=(char)((((n.length>m.length?n[i]:m[i])-'0')+carry)%10 + '0');
			carry = (((n.length>m.length?n[i]:m[i])-'0')+carry)/10;			
		}
		for(; carry>0; K++, carry/=10)
			sol[sol.length-1-K] = (char)(carry%10 + '0');
		return K;
	}
	static int multiplicacion(char[] n, char[] m, char[][] mat, int posicion, int lLinea){
		int K = 0, k = 1, cantUltimo = 0, cantPrimero = 0;
		char sol[] = new char[1005];
		Arrays.fill(sol, ' ');
		sol[sol.length-1] = '0';
		for(int i = 0; i < m.length; i++){
			int cant = multiplicacion(n, m[m.length-i-1], i, mat[posicion+i]);
			K = max(K, cant);
			k = suma(Arrays.copyOfRange(sol, sol.length-k, sol.length - i), Arrays.copyOfRange(mat[posicion+i], mat[posicion+i].length-cant, mat[posicion+i].length - i), sol, i);
			if(i==m.length-1)cantUltimo=cant;
			if(i==0)cantPrimero=cant;
		}
		for(; k > 1; k--)
			if(sol[sol.length-k]=='0')sol[sol.length-k]=' ';
			else break;
		for(int i = 0; i < max(lLinea, cantPrimero); i++)
			mat[posicion-1][mat[posicion-1].length-1-i] = '-';
		if(m.length>1){
			for(int i = 0; i < max(k, cantUltimo); i++)
				mat[posicion+m.length][mat[posicion+m.length].length-1-i] = '-';
			mat[posicion+m.length+1] = sol;
		}
		return max(K, k);
	}
	static int multiplicacion(char[] arr, char a, int posicion, char sol[]){
		if(a=='0'){
			sol[sol.length-1-posicion]='0';
			return posicion+1;
		}
		int carry = 0, m = a-'0', K = posicion;
		for(int i = arr.length - 1; i >= 0; i--, K++){
			sol[sol.length-1-K] = (char)(((carry+(arr[i]-'0')*m)%10)+'0');
			carry = (carry+(arr[i]-'0')*m)/10;
		}
		for(; carry>0; K++, carry/=10)
			sol[sol.length-1-K] = (char)(carry%10 + '0');
		return K;
	}
}
