package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2294
 * @problemName Hangover
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 18/11/2011
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class LAUVa2294 {
	public static void main(String[] args) throws Throwable{
		double r=0;int i=2;double[] arr=new double[278];
		for(;r<=5.20;i++)
			arr[i]=r+=1./i;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(double d;(d=parseDouble(in.readLine().trim()))!=0;){
			int bs=Arrays.binarySearch(arr,d);
			if(bs<0)bs=-bs-1;
			System.out.println((bs-1)+" card(s)");
		}
	}
}
