 ### @author egaeus
 ### @mail sebegaeusprogram@gmail.com
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1257/C
 ### @category implementation
 ### @date 13/11/2019

T = int(input())
for t in range(T):
    N = int(input())
    line = input().split()
    list = []
    for i in range(N):
        list.append(int(line[i]))
    res = N + 1
    ants = [-1] * (N+1)
    for i in range(N):
        if ants[list[i]] != -1:
            res = min(res, i-ants[list[i]]+1)
        ants[list[i]] = i
    print (res if res <= N else -1)