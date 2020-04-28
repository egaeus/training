 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1010/A
 ### @category 
 ### @date 16/04/2020

def f(arr, p, W):
  fuel = p
  for i in range(N):
    expend = (fuel + W) / arr[i][0]
    fuel -= expend
    expend = (fuel + W) / arr[(i+1)%N][1]
    fuel -= expend
    if fuel < 0:
      return False
  return fuel >= 0

N = int(input())
W = int(input())

arr = [[0] * 2 for row in range(N)]

line = input().split()
for i in range(N):
  arr[i][0] = int(line[i])

line = input().split()
for i in range(N):
  arr[i][1] = int(line[i])

a = 0
b = 1000000001

while b - a > 1e-6:
  p = (b+a) / 2
  if f(arr, p, W):
    b = p
  else:
    a = p

if a <= 1000000000:
  print(a)
else:
  print (-1)
  
