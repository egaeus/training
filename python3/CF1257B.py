 ### @author egaeus
 ### @mail sebegaeusprogram@gmail.com
 ### @veredict Accepted
 ### @url https://codeforces.com/problemset/problem/1257/B
 ### @category implementation
 ### @date 13/11/2019
T = int(input())
for t in range(T):
    line = input().split()
    X = int(line[0])
    Y = int(line[1])
    if Y <= X:
        print("YES")
    elif X<=3:
        if X == 1:
            print("NO")
        elif X==2:
            if Y > 3:
                print("NO")
            else:
                print("YES")
        elif X==3:
            print ("NO")
    else:
        print("YES")