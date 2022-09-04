# 20154
# 이 구역의 승자는 누구야?!

# alpha = dict();

# 딕셔너리는 리스트나 튜플처럼 순차적으로 해당 요솟값을 구하는 것이 아닌
# key 값을 이용해서 value를 얻는다
alpha  = {'A' : 3, 'B' : 2, 'C' : 1,'D' : 2, 'E' : 3,'F' :3,'G' :3,'H' :3,'I' :1,'J' :1,'K':3,'L':1,'M' :3,'N':3,'O':1,'P':2,'Q' :2,'R':2,'S':1,'T':2,'U':1,'V':1,'W':2,'X':2,'Y':2,'Z':1}
num = []
string = input()
res =''

# dict에서 찾아서 값 집어넣기
for i in range(len(string)) :
    num.append(alpha[string[i]]) # 리스트 뒤에 더하기


# while len(num)>1 :
#     cal = []
#     for i in range(len(num)) :
#         if i+1<len(num) :
#             cal.append(num[i]+ num[i+1])
#             # del num[i+1] # num[i+1] 요소 삭제
#         else : # 마지막 요소이면
#             continue;
#     num.clear()
#     num = cal.copy() # 리스트 복사
    

number = sum(num) %10
print(number)


if number % 2 == 1 :
    res = "I'm a winner!"
else :
    res = "You're the winner?"

print(res)