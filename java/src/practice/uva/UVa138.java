package practice.uva;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 138
 * @problemName Street Numbers
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 13/12/2011
 **/
public class UVa138 {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		for(long j=0,i=3,s=3,k;j<10;s+=i++){
			if(Math.abs((k=(long)Math.sqrt(s))-Math.sqrt(s))<1e-10){
				for(int h=(k+"").length();h<10;h++)sb.append(" ");
				sb.append(k);
				for(int h=((i-1)+"").length();h<10;h++)sb.append(" ");
				sb.append(i-1+"\n");
				j++;
			} 
		}
		System.out.print(new String(sb));
	}
}
