 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1106/C
 ### @category implementation
 ### @date 12/11/2019

N = int(input())
line = input().split()
arr = []
for i in line:
    arr.append(int(i))
arr.sort()

res = 0
for i in range(N//2):
    res += (arr[i]+arr[N-i-1])*(arr[i]+arr[N-i-1])
print(res)