 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1195/B
 ### @category math
 ### @date 12/11/2019

import math

line = input().split()
N = int(line[0])
K = int(line[1])

n = (-3 + math.sqrt(9+4*(2*N+2*K)))/2

print(int(N-n))
