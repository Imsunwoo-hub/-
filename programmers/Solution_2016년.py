def solution(a, b):
    answer = ''
    d = 0
    day_num = [31, 29, 31, 30, 31,  30, 31, 31, 30, 31,30, 31]
    day = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    for i in range(0, a-1):
        d += day_num[i]
    d += b
    print(d)
    d = d%7-1
    print(d)
    answer = day[d]
    return answer