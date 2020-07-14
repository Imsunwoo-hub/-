def solution(s, n):
    answer = ''
    if n < 0 or n > 25 :
        answer = ''
    else : 
        for i in s :
            a = 0
            if i.isupper() :
                a = ord(i) + n
                if(a > 90) :
                    a = 64 + (a - 90)
                answer += chr(a)

            elif i.islower() :
                a = ord(i)+ n
                if( a > 122) :
                    a = 96 + (a - 122)
                answer += chr(a)  

            elif i == " " : 
                answer += i

        print(answer)        
            
    return answer