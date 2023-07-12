n = int(input())

visited = [0 for _ in range(n+1)]
visited[0] = 1
stack = []

li = []
for i in range(n):
    li.append(int(input()))

answer = ""

for s in li:
    for j in range(1, s+1):
        if visited[j]==0:
            stack.append(j)
            # print('+')
            answer += '+\n'
            visited[j] = 1
    else :
        stack.pop()
        # print('-')
        answer += '-\n'
        continue

flag = True

for i in visited:
    if i==0:
        flag = False
        break

if flag:
    print(answer)
else :
    print('NO')