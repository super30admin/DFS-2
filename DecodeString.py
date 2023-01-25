#Time Complexity: O(N)
#Space: Depth
#Successfully ran on leetcode

class Solution:
    def decodeString(self, s: str) -> str:
        numStack = []
        charStack = []
        num = 0
        char = ""
        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10 + ord(s[i]) - ord('0')
            elif s[i]=='[':
                numStack.append(num)
                charStack.append(char)
                num = 0
                char = ""
            elif s[i]==']':
                times = numStack.pop()
                newStr = ""
                for j in range(times):
                    newStr+=char
                char = charStack.pop()+newStr
            else:
                char+=s[i]
        return char