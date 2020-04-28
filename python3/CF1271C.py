 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1271/C
 ### @category 
 ### @date 15/04/2020

from operator import itemgetter

line = input().split()
N = int(line[0])
Sx = int(line[1])
Sy = int(line[2])

arrX = [0] * N
arrY = [0] * N

for i in range(N):
  line = input().split()
  arrX[i] = int(line[0])
  arrY[i] = int(line[1])

sortX = sorted(arrX)
sortY = sorted(arrY)

M = 0
P = [0] * 2

for i in range(N):
  if sortX[i] > Sx:
    C = N - i
    if C > M:
      M = C
      P[0] = sortX[i]
      P[1] = Sy
  if sortX[i] < Sx:
    C = i + 1
    if C > M:
      M = C
      P[0] = sortX[i]
      P[1] = Sy

for i in range(N):
  if sortY[i] > Sy:
    C = N - i
    if C > M:
      M = C
      P[0] = Sx
      P[1] = sortY[i]
  if sortY[i] < Sy:
    C = i + 1
    if C > M:
      M = C
      P[0] = Sx
      P[1] = sortY[i]
  

print(M)
print(P[0], P[1])