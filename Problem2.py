# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Decode String

class Solution:
    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = ""
        numSt = []
        strSt = []

        for c in s:
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == "[":
                numSt.append(currNum)
                strSt.append(currStr)
                currNum = 0
                currStr = ""
            elif c == "]":
                cnt = numSt.pop()
                parent = strSt.pop()
                baby = ""
                for i in range(cnt):
                    parent += currStr
                currStr = parent
            else:
                currStr += c
        return "".join(currStr)
                
    
        # currNum = 0
        # currStr = ""
        # numSt = []
        # strSt = []

        # for c in s:
        #     if c.isdigit():
        #         currNum = currNum * 10 + int(c)
        #     elif c == "[":
        #         numSt.append(currNum)
        #         strSt.append(currStr)
        #         currNum = 0
        #         currStr = ""
        #     elif c == "]":
        #         cnt = numSt.pop()
        #         baby = strSt.pop()
        #         for j in range(cnt):
        #             baby += currStr
        #         currStr = baby
        #     else:
        #         currStr += c
        # return "".join(currStr)

        
        # stack = []
        # for i in range(len(s)):
        #     if c != "]":
        #         stack.append(c)
        #     else:
        #         substr = ""
        #         while stack[-1] != "[":
        #             substr = stack.pop() + substr
        #         stack.pop()
                
        #         k = ""
        #         while stack and stack[-1].isdigit():
        #             k = stack.pop() + k
                
        #         stack.append(int(k) * substr)
        
        # return "".join(stack)