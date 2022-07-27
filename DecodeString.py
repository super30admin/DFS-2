# Time Complexity => O(N)
# Space Complexity => O(1) or O(DFS of final loop) or O(length of output)

class Solution:
    def decodeString(self, s: str) -> str:
        if(len(s)==0):
            return None
        letters = []
        numbers = []
        currentstring = ""
        num = 0
        for i in s:
            if(i.isdigit()):
                num = num*10+int(i)
            elif(i == "["):
                numbers.append(num)
                letters.append(currentstring)
                num = 0
                currentstring = ""
            elif(i == "]"):
                mul = numbers.pop()
                finalstring = letters.pop()
                for i in range(mul):
                    finalstring+=currentstring
                currentstring = finalstring
            else:
                currentstring+=i
        return currentstring
        