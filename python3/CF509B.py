 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict  Accepted
 ### @url https://codeforces.com/problemset/problem/509/B
 ### @category 
 ### @date 14/11/2019

line = input().split()
N = int(line[0])
K = int(line[1])
result = [None] * N
line = list(map(lambda x: int(x), input().split()))

for i in range(N):
    k = line[i]//K
    m = line[i]%K
    for j in range(K):
        for l in range(k + (1 if j < m else 0)):
            result[i].append(j+1)
