def solution(food_times, k):
    answer = 0
    s_times = sorted(food_times)
    l_times = len(food_times)
    d_time = 0
    l_idx = 0
    for idx in range(l_times):
        if idx == 0:
            d_time += s_times[idx]*(l_times - idx)
        else:
            d_time += (s_times[idx]-s_times[idx-1])*(l_times - idx)
        if d_time > k:
            l_idx = idx -1
            break
    if d_time <= k:
        return -1
    lst = []
    for idx in range(l_times-1, -1, -1):
        if food_times[idx] > s_times[l_idx]:
            lst.append(idx+1)
    if len(lst) != 0:
        return lst[(d_time - k -1)%len(lst)]
    else:
        return (k)%l_times+1