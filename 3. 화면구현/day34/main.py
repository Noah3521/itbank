n = int(input())

li = []
for i in range(n):
    li.append(int(input()))

mx = 0
stack = []

answer=""

for k in li:
    for i in range(1, k+1):
        while stack.count(k)!=0:
            stack.pop()
            answer+='-\n'
        else :
            if mx < i:
                stack.append(i)
                answer+='+\n'
                mx = i
    print(stack)

if stack:
    print('NO')
else :
    print(answer)