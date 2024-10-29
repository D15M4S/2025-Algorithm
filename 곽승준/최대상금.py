from itertools import combinations

def max_prize(nums, swaps, count=0, memo={}):
    global max_value

    # 메모이제이션: (현재 숫자판 상태, 남은 교환 횟수)로 이미 계산된 경우
    key = (tuple(nums), count)
    if key in memo:
        return memo[key]

    # 남은 교환 횟수가 0이면 최대값 계산
    if count == swaps:
        current_value = int("".join(map(str, nums)))
        max_value = max(max_value, current_value)
        return

    # 모든 자리 쌍의 조합
    n = len(nums)
    pairs = list(combinations(range(n), 2))

    for i, j in pairs:
        # 교환
        nums[i], nums[j] = nums[j], nums[i]
        # 백트래킹
        max_prize(nums, swaps, count + 1, memo)
        # 원상 복구
        nums[i], nums[j] = nums[j], nums[i]

    # 남은 교환 횟수가 홀수이고 중복된 숫자가 있다면 교환하지 않고 최대값을 계산
    if (swaps - count) % 2 == 1:
        if len(set(nums)) < len(nums):  # 중복된 숫자가 있는지 확인
            max_value = max(max_value, int("".join(map(str, nums))))
        else:  # 중복이 없으면 마지막 두 자리를 교환해 최대값 갱신
            nums[-1], nums[-2] = nums[-2], nums[-1]
            max_value = max(max_value, int("".join(map(str, nums))))
            nums[-1], nums[-2] = nums[-2], nums[-1]  # 원상 복구

    # 현재 상태를 메모이제이션에 저장
    memo[key] = max_value

# 테스트 케이스 입력
T = int(input())
for t in range(1, T + 1):
    num, swaps = input().split()
    nums = list(map(int, num))
    swaps = int(swaps)

    max_value = 0
    max_prize(nums, swaps)
    print(f"#{t} {max_value}")
