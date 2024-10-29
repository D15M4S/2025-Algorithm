T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    cnt = int(input())
    floor = list(map(int, input().split()))
    sum = 0
    for cmp in range(2, cnt-1):
        srt = sorted(floor[cmp-2:cmp+3], reverse=True)
        if floor[cmp] > srt[1]:
            sum += floor[cmp] - srt[1]

    print(f"#{test_case} {sum}")

