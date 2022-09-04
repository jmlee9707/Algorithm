
# 3029 백준 경고
# 창영마을의 중심을 지나는 강산강 근처에 숨어있다가 나트륨을 물에 던질것
# 현재 시간과 정인이가 나트륨을 던질 시간이 주어졌을 때 
# 정인이가 얼마나 숨어있어야 하는지 구하는 프로그램

# 현재시간이 주어짐
# 나트륨을 던질 시간이 주어짐
# 기다려야 하는시간을 입력과 같은 형식으로 출력

now = input()
doing = input()

# nowT = list(int(now.split(0,2)),int(now.split(2,4)),int(now.split(4,6)));

nowT = list(map(int, now.split(":")))
doingT = list(map(int, doing.split(":")))

result = [0,0,0]

# 거꾸로 문자열 출력
for i in reversed(range(1,3)) :
    if doingT[i]<nowT[i] :
        doingT[i]+=60
        doingT[i-1]-=1
        
    result[i] = doingT[i]-nowT[i]


if doingT[0]<nowT[0] : 
    doingT[0] +=24
    
result[0] = doingT[0]-nowT[0]

# 반례 
# 정인이는 적어도 1초를 기다리며 많아야 24시간을 기다린다

if result[0]==0 and result[1]==0 and result[2]== 0 :
    result[0] = 24

#2자리로 출력 -> format을 02
print(format(result[0],'02')+":"+format(result[1],'02')+":"+format(result[2],'02'))

