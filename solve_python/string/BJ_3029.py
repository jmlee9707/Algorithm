# 3029 백준 경고
# 창영마을의 중심을 지나는 강산강 근처에 숨어있다가 나트륨을 물에 던질것
# 현재 시간과 정인이가 나트륨을 던질 시간이 주어졌을 때 
# 정인이가 얼마나 숨어있어야 하는지 구하는 프로그램

# 현재시간이 주어짐
# 나트륨을 던질 시간이 주어짐
# 기다려야 하는시간을 입력과 같은 형식으로 출력


nowT = list(map(int, input().split(":"))); # 현재 시간
doingT = list(map(int, input().split(":"))); # 던질 시간

result = [0,0,0]; # 기다려야 하는 시간

if nowT[0]==doingT[0] and nowT[1]==doingT[1] and  nowT[2]==doingT[2] :
    print("24:00:00")
else :
    for i in reversed(range(1,3)) : 
        if doingT[i]<nowT[i] :
            result[i] = 60 + doingT[i] - nowT[i]
            doingT[i-1] -= 1
        else : 
            result[i] = doingT[i] - nowT[i]
    
    if doingT[0]<nowT[0] :
        doingT[0] += 24
        
    result[0] = doingT[0] - nowT[0]

    print(format(result[0],'02')+":"+format(result[1],'02')+":"+format(result[2],'02'))
            
        
