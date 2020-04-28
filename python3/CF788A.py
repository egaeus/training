 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/788/A
 ### @category implementation
 ### @date 13/11/2019

def f(list):
    listA = []
    listB = [0]
    res = 0
    for i in range(len(list)):
        res = max(res, list[i])
        if i%2==0:
            if len(listA) > 0:
                listA.append(list[i]+listA[len(listA)-1])
            else:
                listA.append(list[i])
        else:
            if len(listB) > 0:
                listB.append(list[i]+listB[len(listB)-1])
            else:
                listB.append(list[i])
    s = 0
    for i in range(len(listA)):
        if i > 0:
            s = max(s, listB[i]-listA[i-1])
        res = max(res, listA[i] - listB[i] + s)
    return res

N = int(input())
list = []

line = input().split()
last = int(line[0])

for i in range(1,N):
    n = int(line[i])
    list.append(abs(last - n))
    last = n

v = f(list)
del list[0]
print(max(v,f(list)))