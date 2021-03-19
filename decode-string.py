#time complexit: O(n)
#space complexity: O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        numStack = []
        charStack = []
        res = ""
        i = 0
        while i < len(s):
            if s[i].isdigit():
                count = 0
                while s[i].isdigit():
                    count = count * 10 + int(s[i])
                    i = i+1
                numStack.append(count)
            elif s[i] == '[':
                charStack.append(res)
                res = ''
                i=i+1
            elif s[i] == ']':
                temp = charStack.pop()
                c = int(numStack.pop())
                j = 0
                while j < c:
                    temp+=res
                    j=j+1
                res = temp
                i+=1
            else:
                res+=(s[i])
                i = i +1
        return res
