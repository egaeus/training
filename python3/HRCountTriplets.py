 ### @author egaeus
 ### @mail sebegaeusprogram@gmail.com
 ### @veredict Accepted
 ### @url https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 ### @category maps
 ### @date 10/02/2020

import math
import os
import random
import re
import sys

# Complete the countTriplets function below.
def countTriplets(arr, r):
    countLeft = {}
    countRight = {}
    for i in arr:
        if i in countRight:
            countRight[i]+=1
        else:
            countRight[i]=1
    sol = 0
    for m in arr:
        countRight[m] -= 1
        if m % r == 0:
           sol += (countLeft[m/r] if m/r in countLeft  else 0) * (countRight[m*r] if m*r in countRight  else 0)
        if m in countLeft:
            countLeft[m]+=1
        else:
            countLeft[m]=1
    return sol

if __name__ == '__main__':
    nr = input().rstrip().split()
    n = int(nr[0])
    r = int(nr[1])
    arr = list(map(int, input().rstrip().split()))
    ans = countTriplets(arr, r)
    print(str(ans) + '\n')
