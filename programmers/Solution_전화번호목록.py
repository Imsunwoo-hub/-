def solution(phone_book):
    answer = True
    temp = ''
    phone_book.sort()
    for i in range(0,len(phone_book)) :
        if answer == False :
            break
        temp = phone_book[i]
        for j in range(i+1, len(phone_book)) :
            s = phone_book[j][:len(temp)]
            if temp == s :
                answer = False
                break;
            
    return answer