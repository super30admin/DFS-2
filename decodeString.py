# // Time Complexity : O(n) for len of string
# // Space Complexity :O(k) recursion stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Using dfs recursion calling function did not increment and was processing infinite loop on "["


# // Your code here along with comments explaining your approach

#using stack(s): we use 2 stacks to add str and num. if we use one pop out in reverse order

class Solution:
    def decodeString(self, s: str) -> str:
        nSt = []                #number stack
        sSt = []                #string stack
        # n = len(s)
        currNum = 0 
        currStr = ""
        # dont push to stack unless we are "[""
        for c in s:
            if c.isdigit():
                currNum = 10*currNum + int(c)
            elif c == '[':
                nSt.append(currNum)  # num
                sSt.append(currStr)  # str
                currStr = ''                # empty 
                currNum = 0                 # empty
            elif c == ']':
                prevStr = sSt.pop()     # str
                times = nSt.pop()       # num
                currStr = prevStr + (times*currStr)    
            else:
                currStr+=c
        return currStr
    

#dfs recursion : error on "[" processing bracket 
class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        n = len(s)
        currNum = 0
        currStr = ""

        while self.i  < n:
            c = s[self.i]

            if c.isdigit():                        # process digit 
                currNum = 10* currNum + int(c)

            elif c == "[":                         # recursive function for children
                self.i +=1                         # process inside bracket not bracket
                baby = self.decodeString(s)
                for _ in range(currNum):
                    currStr+=baby
                currNum = 0
            elif c == "]":
                return currStr
            else:
                currStr += c
            self.i +=1                              

        return currStr