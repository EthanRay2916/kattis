import math
m = int(input())
for i in range(m):
    bx, by = map(float, input().split())
    c = int(input())
    works = False
    for j in range(c):
        cx, cy = map(float, input().split())
        if math.sqrt((bx-cx)*(bx-cx) + (by-cy)*(by-cy)) <= 8:
            works = True
    if works:
        print("light a candle")
    else:
        print("curse the darkness")