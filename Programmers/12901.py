# 프로그래머시 2016년

a = int(input());
b = int(input());

answer = ''

day = ['SUN', 'MON','TUE','WED','THU','FRI','SAT']
start = 5; # 1월 1일은 금요일
month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    
for i in range(a) :
    # if days==a : break
    start += month[i]
    print(i)

start = (start+b-1)%7
answer = day[start]
    
print (answer);