 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1027/A
 ### @category strings
 ### @date 11/11/2019

Q = int(input())

for q in range(Q):
    N = int(input())
    text = raw_input()
    ws = True
    for i in range(len(text)/2):
        x = ord(text[i])
        y = ord(text[len(text) - i - 1])
        if x + 1 != y - 1 and x + 1 != y + 1 and x - 1 != y - 1 and x - 1 != y + 1:
            ws = False
    print "YES" if ws else "NO"