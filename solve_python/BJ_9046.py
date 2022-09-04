# 복호화
# 백준 9046

tc = int(input()) # 테스트 케이스

for _ in range(tc) :
    data = input();
    dic = dict(); # 사전 자료형 카운트
    
    for i in range(len(data)) :
        if data[i] == ' ' : 
            continue # 공백이면 카운트 안함
        if data[i] in dic: # key 값은 알파벳, value 값은 숫자
            dic[data[i]] += 1
        else :
            dic[data[i]] = 1
    
    # print(dic)
    max_value = 0;
    
    #dict에서 value 값만 뽑아서 사용하기
    for value in dic.values() :
        if max_value < value :
            max_value = value;
    
    count = 0; # 최대값이 몇개?
    result = '';
    
    for key,value in dic.items() :
        # print(value,key)
        if(value == max_value) : 
            count += 1
            result = key;
    
    if count == 1 :
        print(result)
    else :
        print('?')
        
    

