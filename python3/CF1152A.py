 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1152/A
 ### @category implementation
 ### @date 12/11/2019

line = input().split()
N = int(line[0])
M = int(line[1])
chests = [0, 0]
keys = [0, 0]

line = input().split()
for i in range(N):
    chests[int(line[i])%2] += 1

line = input().split()
for i in range(M):
    keys[int(line[i])%2] += 1

print (min(chests[0], keys[1]) + min(chests[1], keys[0]))