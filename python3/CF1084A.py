 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1084/A
 ### @category implementation
 ### @date 13/11/2019

N = int(input())
line = input().split()
list = []
for i in range(N):
    list.append(int(line[i]))
res = 100000000
for x in range(N):
    s = 0
    for i in range(N):
        s += (4*i) * list[i]
    res = min(res, s)
print(res)