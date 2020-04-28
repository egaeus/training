 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/697/A
 ### @category math
 ### @date 10/11/2019

line = raw_input().split()

t = int(line[0])
s = int(line[1])
x = int(line[2])

if x < t:
    print "NO"
elif x == t + 1:
    print "NO"
else:
    a = (x - t) / s
    a = a * s + (x - t) % s
    print "NO" if a % s > 1 else "YES"