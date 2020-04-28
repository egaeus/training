 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/616/B
 ### @category implementation
 ### @date 13/11/2019

line = input().split()

N = int(line[0])
M = int(line[1])

res = 0

for i in range(N):
    m = 1000000000
    line = input().split()
    for j in range(M):
        m = min(m, int(line[j]))
    res = max(res, m)
print(res)