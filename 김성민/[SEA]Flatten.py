T = 10
for test_case in range(1, T + 1):
    sum = 0
    dump = int(input()) # 덤프 횟수
    box = list(map(int, input().split())) # 각 상자의 높이

    for j in range(dump):
        min_index = box.index(min(box))
        max_index = box.index(max(box))
        box[min_index] += 1
        box[max_index] -= 1
    sum = max(box) - min(box)

    print(f"#{test_case} {sum}")
