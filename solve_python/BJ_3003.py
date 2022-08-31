#  백준 3003
# 킹, 퀸, 룩, 비숍, 나이트, 폰

# 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개

chess = [1, 1, 2, 2, 2, 8]
hyek = list(map(int, input().split()))

for i in range(6) :
    print(chess[i]-hyek[i], end=" ") #원래 end의 default가 \n

