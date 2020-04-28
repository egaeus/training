  ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/342/A
 ### @category implementation
 ### @date 13/11/2019

N = int(input())
n = N/3
list = [0] * 8
line = input().split()

for i in range(N):
    x = int(line[i])
    list[x] += 1
if list[1] == n and list[2] + list[3] == n and list[4] + list[6] == n and list[6] >= list[3]:
    for i in range(list[3]):
        print("1 3 6")
    for i in range(list[6] - list[3]):
        print("1 2 6")
    for i in range(list[4]):
        print("1 2 4")
else:
    print(-1)