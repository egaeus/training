 ### @author egaeus
 ### @mail sebegaeusprogram@gmail.com
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1257/A
 ### @category implementation
 ### @date 13/11/2019

T = int(input())
for t in range(T):
    line = input().split()
    N = int(line[0])
    X = int(line[1])
    A = int(line[2])
    B = int(line[3])
    m = min(A,B)
    M = max(A,B)
    A=m
    B=M
    while (X >= 0) and (A > 0):
        X-=1
        A-=1
    while (X >= 0) and (B < N):
        X-=1
        B+=1
    print (B-A-1)

