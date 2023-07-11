n = int(input())

visited = [0 for _ in range(n+1)]
visited[0] = 1
stack = []


for i in range(n):
    s = int(input())
    for j in range(1, s+1):
        if visited[j]==0:
            stack.append(j)
            print('+')
            visited[j] = 1
    else :
        stack.pop()
        print('-')