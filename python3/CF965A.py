 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/965/A
 ### @category math
 ### @date 13/11/2019

import math

line = input().split()
K = int(line[0])
N = int(line[1])
S = int(line[2])
P = int(line[3])

print (math.ceil((K*math.ceil(N/S))/P))