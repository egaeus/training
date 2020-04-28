 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/742/B
 ### @category 
 ### @date 14/04/2020

line = input().split()
N = int(line[0])
X = int(line[1])

line = input().split()

arr = [0] * 1000000

for i in range(N):
  arr[int(line[i])] += 1

res = 0
for i in range(len(arr)):
  if i^X < len(arr):
    if arr[i] > 0:
      if i == i^X:
        res += (arr[i]*(arr[i]-1))//2
      else:
        res += arr[i]*arr[i^X]
    arr[i] = 0
    arr[i^X] = 0
print(res)