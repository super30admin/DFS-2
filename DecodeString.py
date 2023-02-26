#All TC on leetcode passed

class Solution:
    def decodeString(self, s: str) -> str:

        #Here we main 2 stacks for nums and chars and 2 strings for num and char. If we get a 
        #[ the we add curNum and curStr into their respective stacks and make curNum=0 and curStr to empty. 
        #If we get ] then we pop from both stacks, then we multiply curStr by the num poped and later append 
        #the multiplied string with char poped from stack and assign this to curStr.
        #Time complexity - O(n) where n is length of output string. Here we cant say the based on 
        #i/p because output depends on the num that the string is multiplied by.
        #Space complexity - O(b) where b is number of open brackets i.e. no. of enteries in stack is 
        #equal to number of open brackets

        strStack = []
        numStack = []

        curStr = ""
        curNum = 0

        i = 0
        while i<len(s):
            if s[i].isdigit():
                curNum = curNum*10 + int(s[i])

            elif s[i]=="[":
                strStack.append(curStr)
                numStack.append(curNum)
                curStr = ""
                curNum = 0

            elif s[i]=="]":
                num = numStack.pop()
                curStr = strStack.pop() + (num * curStr) 

            else:
                curStr += s[i]

            i+=1

        return curStr

        