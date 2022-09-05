package practice.uva;

/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 136
 * @problemName Ugly Numbers
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2008
 **/
public class UVa136 {
	public static int []arr = new int[30000000];
	/*public static int isUglyNumber(int n){
		if(n==1)return 2;
		if(n<30000000 &&arr[n]>0)return arr[n];
		if(n%2!=0&&n%3!=0&&n%5!=0)return n < 30000000?arr[n]=1:1;
		if(n<30000000)arr[n]= ((n%5==0?isUglyNumber(n/5)==2:true) && (n%3==0?isUglyNumber(n/3)==2:true) && (n%2==0?isUglyNumber(n/2)==2:true))?2:1;
		return n<30000000?arr[n]:(((n%5==0?isUglyNumber(n/5)==2:true) && (n%3==0?isUglyNumber(n/3)==2:true) && (n%2==0?isUglyNumber(n/2)==2:true))?2:1);
	}*/
	public static void main(String[] args) {
		System.out.print("The 1500'th ugly number is 859963392.");
		/*arr[1]=2;
		int cont = 0;
		int i=0;
		try{
		for (i = 1; cont<=1500; i++){
			if(isUglyNumber(i)==2)System.out.println(i + " " + cont++);
			//System.out.println(cont);
		}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(cont);
		}*/
		/*System.out.println(i-1);*/
	}
}
