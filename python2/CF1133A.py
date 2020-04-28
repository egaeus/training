 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1133/A
 ### @category implementation
 ### @date 10/11/2019


def p(n):
    s = str(n)
    if n < 10:
        s = '0'+s
    return s

h1 = raw_input().split(':')
h2 = raw_input().split(':')

hour1 = int(h1[0])*60+int(h1[1])
hour2 = int(h2[0])*60+int(h2[1])
hour = (hour1 + hour2) / 2

print p(hour/60)+':'+p(hour%60)