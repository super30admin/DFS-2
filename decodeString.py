############ Recursive method using single stack ############
# Time complexity -> O(n)
# Space complexity -> O(D) where D is depth or number of open brackets
class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        if not s:
            return s
        
        curStr = ''
        curNum = 0
        index = Solution.i
        while Solution.i < len(s):
            if s[Solution.i] == '[':
                Solution.i += 1
                temp = self.decodeString(s)
                curStr += (temp*curNum)
                curNum = 0
                
            elif s[Solution.i] == ']':
                Solution.i += 1
                return curStr
                       
            elif s[Solution.i].isdigit():
                curNum = curNum*10 +(ord(s[Solution.i])-ord('0'))
                Solution.i += 1

            else:
                curStr += s[Solution.i]
                Solution.i += 1
                
        return curStr
            
        
############ Iterative method using 2 stacks ############
# Time complexity -> O(n)
# Space complexity -> O(n)
# class Solution:
#     def decodeString(self, s: str) -> str:
#         if not s:
#             return s
        
#         curStr = ''
#         curNum = 0
#         numStack, wordStack = [], []
        
#         for i in s:
#             if i == '[':
#                 numStack += [curNum]
#                 wordStack += [curStr]
#                 curNum  = 0
#                 curStr = ''
                
#             elif i == ']':
#                 curStr *= numStack.pop()
#                 curStr =  wordStack.pop() + curStr
                       
#             elif i.isdigit():
#                 curNum = curNum*10 +(ord(i)-ord('0'))
                 
#             else:
#                 curStr += i
                
#         return curStr
                       
                
                
        