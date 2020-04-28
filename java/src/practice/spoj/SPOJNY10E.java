package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId NY10E
 * @problemName Non-Decreasing Digits
 * @judge http://www.spoj.pl
 * @category pd
 * @level easy
 * @date 22/03/2011
 **/
import java.util.Scanner;
public class SPOJNY10E {
	static long[][] mem = new long[10][65];
	static long function(int n, int i){
		if(n==1)return mem[i][n]=10-i;
		if(mem[i][n]>0)return mem[i][n];
		long sum = 0;
		for(int j=i;j<10;j++)sum+=function(n-1,j);
		return mem[i][n] = sum;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i < 65; i++)function(i, 0);
		for(int c = 0, C = sc.nextInt(); c++ < C; )
			System.out.println(sc.nextInt() + " " + mem[0][sc.nextInt()]);
	}
}
/* C�digo en C++ (No pasa en java por tiempo, de hecho porque le pusieron un tiempo muy ficti al problema)
#include <iostream.h>
#include <stdio.h>
long long int mem[10][65];
long long int function(int n, int i){
	if(i==10)return 0;
	if(n==1)return mem[i][n] = 10-i;
	if(mem[i][n]>0)return mem[i][n];
	return mem[i][n] = function(n-1,i) + function(n,i+1);
}
int main(int argc, char *argv[]){
	int n, r, num, i, j;
	for(i=0;i<10;i++)
		for(j=0;j<65;j++)
			mem[i][j]=0;
	for(j=1;j<65;j++)function(j, 0);
	cin>>r;
	for(;r--;){
		cin>>n;
		cin>>num;
		cout<<n<<" "<<mem[0][num]<<endl;
	}
	return 0;
}
 */
