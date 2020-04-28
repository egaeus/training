 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1221/A
 ### @category math
 ### @date 10/11/2019

import math

Q = int(input())

for q in range(Q):
    n = int(input())
    line = raw_input().split()
    arr = [0] * 12
    for i in range(n):
        a = int(math.log(int(line[i]), 2))
        if a < 12:
            arr[a] += 1
    for i in range(1, 12):
        arr[i] += arr[i-1]/2
    print "yes" if arr[11] > 0 else "no"