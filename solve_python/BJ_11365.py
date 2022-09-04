# 백준 !밀비 급일
# 11365

# 거꾸로 입력된 문자열 출력하기

secret = []
num = 0

while True :
    temp = input()
    if temp=="END" : break;
    
    else :
        result = temp[::-1]
        print(result)