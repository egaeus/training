package practice.poj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 1807
 * @problemName Mayan Dates
 * @judge http://poj.org/
 * @category adhoc
 * @level easy
 * @date 02/08/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class POJ1807{
	static boolean isLeap(int year){
		if(year>=0) return year%400==0||(year%4==0&&year%100!=0);
		return isLeap(-(year+1));
	}
	static int dayOfMonth(int m,int y){
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12) return 31;
		if(m==2) return (isLeap(y)?29:28);
		return 30;
	}
	static int incGregorianDate(int d,int m,int y){
		d++;
		if(d>dayOfMonth(m,y)){m++;d=1;}
		if(m>12){y++;m=1;}
		if(y==0)y++;
		return d|(m<<5)|((y<0?3114+y:y)<<9)|((y<0?0:1)<<21);
	}
	static int incLongCount(int a,int b,int c,int d,int e){
		e++;
		if(e==20){e=0;d++;}
		if(d==18){d=0;c++;}
		if(c==20){c=0;b++;}
		if(b==20){b=0;a++;}
		return (a<<20)|(b<<15)|(c<<10)|(d<<5)|e;
	}
	static int incRitualDate(int a,int b,int c,int d){
		a++;
		if(a==14)a=1;
		b++;
		if(b==20)b=0;
		c++;
		if((d==18&&c==5)||c==20){c=0;d++;}
		if(d==19)d=0;
		return (a<<15)|(b<<10)|(c<<5)|d;
	}
	public static void main(String args[]) throws Throwable{
		int MAX=1872001;
		int[] ritual=new int[MAX],longcount=new int[MAX],dates=new int[MAX];
		dates[0]=13|(8<<5);
		longcount[0]=0;
		ritual[0]=(4<<15)|(19<<10)|(8<<5)|17;
		for(int i=1;i<MAX;i++){
			int date=dates[i-1],d,m,y,a,b,c,e;
			d=date%(1<<5);date=date>>5;
			m=date%(1<<4);date=date>>4;
			y=date%(1<<12);date=date>>12;
			y=(date==0?y-3114:y);
			dates[i]=incGregorianDate(d,m,y);
			date=longcount[i-1];
			e=date%(1<<5);date=date>>5;
			d=date%(1<<5);date=date>>5;
			c=date%(1<<5);date=date>>5;
			b=date%(1<<5);date=date>>5;
			a=date%(1<<5);date=date>>5;
			longcount[i]=incLongCount(a,b,c,d,e);
			date=ritual[i-1];
			d=date%(1<<5);date=date>>5;
			c=date%(1<<5);date=date>>5;
			b=date%(1<<5);date=date>>5;
			a=date%(1<<5);date=date>>5;
			ritual[i]=incRitualDate(a,b,c,d);
		}
		String[] month="Pob,Wo, Sip, Sotz', Tzek, Xul, Yaxk'in, Mol, Ch'en, Yax, Sak, Keh, Mak, K'ank'in, Muwan, Pax, K'ayab,Kumk'u, Wayeb".split(",");
		String[] week="Imix, Ik', Ak'bal, K'an, Chikchan, Kimi, Manik', Lamat, Muluk, Ok, Chuwen, Eb, Ben, Ix, Men,Kib, Kaban, Etz'nab, Kawak, Ahaw".split(",");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			String[] arr=in.readLine().trim().split(" +");
			int bs;
			if(arr.length==1){
				int[] s=new int[5];
				StringTokenizer st=new StringTokenizer(arr[0],".");
				for(int i=0;i<5;i++)
					s[i]=parseInt(st.nextToken());
				bs=Arrays.binarySearch(longcount,(s[0]<<20)|(s[1]<<15)|(s[2]<<10)|(s[3]<<5)|s[4]);
			}else{
				int[] s=new int[3];
				StringTokenizer st=new StringTokenizer(arr[0],"/");
				for(int i=2;i>=0;i--)
					s[i]=parseInt(st.nextToken());
				s[0]*=(arr[1].equals("BC")?-1:1);
				bs=Arrays.binarySearch(dates,s[2]|(s[1]<<5)|((s[0]<0?s[0]+3114:s[0])<<9)|((s[0]<0?0:1)<<21));
			}
			sb.append("Scenario #"+t+":\n");
			int date=dates[bs],d,m,y,a,b,c,e;
			d=date%(1<<5);date=date>>5;
			m=date%(1<<4);date=date>>4;
			y=date%(1<<12);date=date>>12;
			y=(date==0?y-3114:y);
			sb.append(d+"/"+m+"/"+abs(y)+" "+(y<0?"BC":"AD")+"\n");
			date=longcount[bs];
			e=date%(1<<5);date=date>>5;
			d=date%(1<<5);date=date>>5;
			c=date%(1<<5);date=date>>5;
			b=date%(1<<5);date=date>>5;
			a=date%(1<<5);date=date>>5;
			sb.append(a+"."+b+"."+c+"."+d+"."+e+"\n");
			date=ritual[bs];
			d=date%(1<<5);date=date>>5;
			c=date%(1<<5);date=date>>5;
			b=date%(1<<5);date=date>>5;
			a=date%(1<<5);date=date>>5;
			sb.append(a+" "+week[b].trim()+" "+c+" "+month[d].trim()+"\n\n");
		}
		System.out.print(new String(sb));
	}
}
