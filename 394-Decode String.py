class Solution:
    def decodeString(self, s: str) -> str:
        if len(s) == None: return ""
        numStack = []
        strStack = []
        num = 0
        currStr = ''
        for i in s:
            if i.isnumeric():
                num = num * 10 + int(i)
            
            elif i == '[':
                strStack.append(currStr)
                numStack.append(num)
                num = 0
                currStr = ''
                
            elif i == ']':
                times = numStack.pop()
                newStr = ''
                for j in range(times):
                    newStr = newStr + currStr
                    
                currStr = strStack.pop()
                currStr = currStr + newStr 
            else:
                currStr = currStr + i
        return currStr
    
    
    # T.C=>O(N) => Length of string
    # S.C=> O(N) => Since we will append all the elements in the stack
    # Approach = > Here we check if the character is numeric. If it is then change it to number of times.
    # Then append that to the num stack. 
    # Similary if it is string append it to the currStr until we get '['.
    # Ones we get ']' remove the string from currStr and add it to newStr and loop it the number of times we pop the number from the num stack.
    # Loop this process forwhole string
        