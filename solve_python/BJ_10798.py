# 세로 읽기
# 10798

words = []
size = []

for _ in range(5) :
    
    # append는 배열 뒤에 덧붙인다는 의미
    word = input()
    words.append(word)
    size.append(len(word))

res = ''

for i in range(max(size)) :
    for j in range(5) :
        if i<size[j] :
            res += words[j][i]
        else :
            continue;
        
print(res)