for i in range(10):
    tc = int(input())
    apt = list(map(int, input().split()))
    cnt = 0

    for j in range(2, tc-2):
        check = 0
        check = max(apt[j-1], apt[j+1], apt[j-2], apt[j+2])
        if apt[j] > check:
            cnt += apt[j] - check 
    print(f"#{i+1} {cnt}")
