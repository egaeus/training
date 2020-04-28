 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1077/B
 ### @category dp
 ### @date 11/11/2019

def f(p, a):
    if p >= N - 1:
        return 0
    if mem[p][a] != None:
        return mem[p][a]
    if arr[p] == 0 and a == 1 and arr[p+1] == 1:
        mem[p][a] = min(f(p+1, 0) + 1, f(p+2, 0) + 1)
        return mem[p][a]
    m = f(p+1, arr[p])
    if arr[p] == 1:
        m = min(m, f(p+1, 0) + 1)
    mem[p][a] = m
    return m

N = int(input())
arr = [0] * N
mem = [None] * N
line = raw_input().split()
for i in range(N):
    mem[i] = [None] * 2
    arr[i] = int(line[i])
print f(1,arr[0])