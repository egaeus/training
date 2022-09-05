package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 10033
 * @problemName Interpreter
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 4/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10033 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,T=parseInt(in.readLine().trim());c<T;c++){
			if(c==0)in.readLine();
			int[] RAM=new int[1000];
			int[] reg=new int[10];
			boolean sumar=true;int res=0,p=0,l=0;
			for(String ln;(ln=in.readLine())!=null&&!(ln=ln.trim()).equals("");){
				RAM[l++]=parseInt(ln);
				while(p!=l&&sumar){
					int N=RAM[p++],A=N/100,B=(N/10)%10,C=N%10;
					p=p%1000;
					if(sumar)res++;
					if(A==1)sumar=false;
					if(A==2)reg[B]=C;
					if(A==3)reg[B]=(reg[B]+C)%1000;
					if(A==4)reg[B]=(reg[B]*C)%1000;
					if(A==5)reg[B]=reg[C];
					if(A==6)reg[B]=(reg[B]+reg[C])%1000;
					if(A==7)reg[B]=(reg[B]*reg[C])%1000;
					if(A==8)reg[B]=RAM[reg[C]];
					if(A==9)RAM[reg[C]]=reg[B];
					if(A==0)if(reg[C]>0)p=reg[B];
				}	
			}
			System.out.println(res+(c<T-1?"\n":""));
		}
	}
}
