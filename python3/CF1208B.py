 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1208/B
 ### @category 
 ### @date 14/04/2020

def check(arr, k):
  dictionary = {}
  for i in range(len(arr) - k):
    if arr[i] in dictionary:
      dictionary[arr[i]] += 1
    else:
      dictionary[arr[i]] = 1
  if len(dictionary) == len(arr) - k:
    return True
  for i in range(len(arr) - k):
    delete = len(arr) - k - i - 1
    add = len(arr) - 1 - i
    dictionary[arr[delete]] -= 1
    if dictionary[arr[delete]] == 0:
      del dictionary[arr[delete]]
    if arr[add] in dictionary:
      dictionary[arr[add]] += 1
    else:
      dictionary[arr[add]] = 1
    if len(dictionary) == len(arr) - k:
      return True
  return False

N = int(input())
line = input().split()

arr = [0] * N
for i in range(N):
  arr[i] = int(line[i])

a = 0
b = N

while a < b:
  p = (a+b) // 2
  if check(arr, p):
    b = p
  else:
    a = p + 1

print(a)
