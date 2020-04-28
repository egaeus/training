 ### @author egaeus 
 ### @mail sebegaeusprogram@gmail.com 
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/567/C
 ### @category 
 ### @date 02/12/2019

line = input().split()
N = int(line[0])
K = int(line[1])

line = input().split()
numbers = []

dictionary2 = {}
dictionary1 = {}

for i in range(N):
    numbers.append(int(line[i]))
    if numbers[i] in dictionary1:
        dictionary1[numbers[i]] += 1
    else:
        dictionary1[numbers[i]] = 1
sol = 0
for i in numbers:
    dictionary1[i] -= 1
    if i%K == 0:
        sol += (dictionary2[i/K] if i/K in dictionary2 else 0) * (dictionary1[i*K] if i*K in dictionary1 else 0)
    if i in dictionary2:
        dictionary2[i] += 1
    else:
        dictionary2[i] = 1
print(sol)
