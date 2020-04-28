 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/981/A
 ### @category strings
 ### @date 02/12/2019

s = input()
res = 0

for i in range(len(s)):
    for j in range(i+1, len(s) + 1):
        ws = True
        for k in range(0, j - i):
            if s[i+k] != s[j-k-1]:
                ws = False
        if not ws:
            res = max(res, j - i)
print(res)