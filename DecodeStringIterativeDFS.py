'''
TC: O(maxK⋅n) where K is the max number and n is the length of the currStr
SC: O(n) - n is the stack space
'''
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currStr, currNum = "", 0
        for i in range(len(s)):
            if s[i].isalpha():
                currStr += s[i]
            
            elif s[i].isdigit():
                currNum = currNum*10+int(s[i])

            elif s[i] == '[':
                stack.append(currStr)
                stack.append(currNum)
                currStr, currNum = "", 0

            elif s[i] == ']':
                currStr = stack.pop()*currStr
                currStr = stack.pop()+currStr
        return currStr
s = Solution()
print(s.decodeString("3[a]2[bc]"))
print(s.decodeString("3[a2[c]]"))
print(s.decodeString("2[abc]3[cd]ef"))