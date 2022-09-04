# 프로그래머스 
# kakao blind recruitment 실패율

def solution(N, stages):
    answer = []
    user = len(stages); # 이용자 수
    
    all = stages.count(N+1)

    percent = dict() # dictionary
    sum = all 

    for i in reversed(range(1,N+1)) :
        temp = stages.count(i)
        # 스테이지에 도달한 플레이어 수가 0보다 큰 경우와 0인 경우로 나누어서 생각해야 함
        if (sum+temp)>0 : 
            sum +=temp
            percent[i] =  temp / sum
        else : 
            percent[i] = 0
        # key : stage / value : 실패율

    
    percent = dict(sorted(percent.items(),key = lambda item : item[0]))
    
    # 실패율의 내림차순으로 정렬
    # 파이썬은 sorted() 내장 함수로 정렬할 수 있다
    # 인자로는 lambda가 전달되고 item[0]= key, item[1] = value를 의미한다.
    # 내림차순은 reverse=True 로 사용할 수 있다.

    # value를 기준으로 내림차순 정렬하겠다는 뜻
    #items()를 사용하면 튜플 자료형 형식으로 리턴한다
    # 다시 dict 형식으로 사용하려면 마지막에 dict() 작성해주어야 한다.

    copy = dict(sorted(percent.items(),key = lambda item : item[1], reverse=True))
    
    # list(dict.keys()) 는 딕셔너리의 key에 대한 리스트를 생성하는 것이다
    answer = list(copy.keys())
    return answer