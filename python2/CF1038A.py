 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1038/A
 ### @category strings
 ### @date 11/11/2019

line = raw_input().split()
N = int(line[0])
K = int(line[1])
arr = raw_input()
count = [0] * K

for i in range(N):
    count[ord(arr[i]) - ord('A')] += 1

res = N

for i in range(K):
    res = min(res, count[i])

print res * K