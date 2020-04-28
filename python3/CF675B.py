 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/675/B
 ### @category implementation
 ### @date 14/11/2019

line = input().split()
N = int(line[0])
A = int(line[1])
B = int(line[2])
C = int(line[3])
D = int(line[4])

AB = A + B
AC = A + C
BD = B + D
CD = C + D

s = 0

for i in range(1, N+1):
    m = AB + i
    m = min(m, AC+i)
    m = min(m, BD+i)
    m = min(m, CD+i)

    M = AB + i
    M = max(M, AC+i)
    M = max(M, BD+i)
    M = max(M, CD+i)
    
    s += max(0, m+N-M)

print(s)