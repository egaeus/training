 ### @author egaeus
 ### @mail sebegaeusprogram@gmail.com
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1097/B
 ### @category dp
 ### @date 09/11/2019

def f(p, sum):
    if sum <= -360:
        sum += 360
    if sum >= 360:
        sum -= 360
    if p == n:
        if sum == 0:
            return True
        else:
            return False
    if mem[p][sum+360] != None:
        return mem[p][sum+360] == 0
    ws = f(p + 1, sum + _list[p]) or f(p + 1, sum - _list[p])
    if ws:
        mem[p][sum+360] = 0
    else:
        mem[p][sum+360] = 1
    return ws

n = int(input())
_list = []
mem = [None] * n
for i in range(n):
    mem[i] = [None] * 1000
    _list.append(int(input()))
print "YES" if f(0, 0) else "NO"