 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/32/B
 ### @category implementation
 ### @date 12/11/2019

line = input()
i = 0
res = ''
while i < len(line):
    if line[i] == '.':
        res += '0'
        i+=1
    elif line[i+1] == '.':
        res += '1'
        i+=2
    else:
        res += '2'
        i+=2

print(res)