import sys
import fileinput
def gcd(a, b):
  if b == 0:
    return a
  return gcd(b, a % b)
inputFile = open(r"input.txt", "Access_Mode")
#n = int(sys.stdin.readline().rstrip("\n"))
n = int(inputFile.readline().rstrip("\n"))
#a = tuple(map(int, sys.stdin.readline().rstrip("\n").split(" ")))
a = tuple(map(int, inputFile.readline().rstrip("\n").split(" ")))

all = sum(a)

re = ""

for k in range(1, n + 1):
  common = gcd(k, n)

  if common == 1:
    total = all
  else:
    total = 0
    for i in range(0, n, common):
      total += a[i]
  re = "".join((re, str(total), "\n"))

print(re)