
            
def solution(numbers):
    arr=[]
    for i in range(0,10):
        if i in numbers:
            pass
        else:
            arr.append(i)
    
    answer=sum(arr)
    return answer
   