# // Time Complexity : stack and recursion both o(produce of the numbers * lenght of the max string)
# // Space Complexity : length of the string
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : deriving the solution intuitively


# // Your code here along with comments explaining your approach
# idea is to maintain two stacks one for storing the number that needs to be multiplied with the innermost decoded string and another stack to attach to the parent once we see a ]
# so basically keep pusing to currstring till be see a character for every number multiply by 10 the previou and add curr since they can be 2 digits
# on every [  push the curr string to stack and number to the stack and on every ] multiply by number from the stack prepare the string and attach to the string popped from stack , repeat till we reach the end and t


# class Solution:
#     def decodeString(self, s: str) -> str:
#         numSt = []
#         strSt = []
#         n = len(s)
#         num = 0
#         currStr = ""
#         for i in range(n):
#             c = s[i]
#             if  c.isdigit():
#                 num=num*10 + int(c)
#             elif c == "[":
#                 strSt.append(currStr)
#                 numSt.append(num)
#                 currStr = ""
#                 num = 0
#             elif c == "]":
#                 temp = currStr
#                 currStr = strSt.pop()
#                 count = numSt.pop()
#                 currStr+=temp*count
#             else:
#                 currStr += c
#         return currStr

# recursive approach
class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        num = 0
        currStr = ""
        while self.i<len(s):
            c = s[self.i]
            if  c.isdigit():
                num=num*10 + int(c)
                self.i+=1
            elif c == "[":
                self.i+=1
                child = self.decodeString(s)
                temp = child
                currStr+=temp*num
                num = 0
            elif c == "]":
                self.i+=1
                return currStr
            else:
                currStr += c
                self.i+=1
        return currStr


        