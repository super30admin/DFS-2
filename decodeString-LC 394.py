# Time Complexity = O(length of final string)
# Space Complexity = O(no. of opening brackets)


# Using 2 stacks
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
                return ""
            
        num = 0
        currStr = ""
        numStack = []
        strStack = []
        
        size = len(s)
        
        for i in range(size):
            c = s[i]
            
            # 4 options - digit, opening bracket, closing bracket, char/string
            
            # If its a digit, calculate the num value
            if (c.isdigit()):
                num = num * 10 + int(c)
                
            # If it is the start of the [], push num and currStr into their stacks and reset the values of both    
            elif c == '[':
                numStack.append(num)
                strStack.append(currStr)
                currStr = ""
                num = 0
            
            # If it is the end of the [], pop out from num stack to get how many times the string needs to be written. Concatenate/Append the strings(k times) to the currStr. At the end, pop from str stack and concatenate that string ahead of currStr
            elif c == ']':
                k = numStack.pop()
                str1 = [currStr for i in range(k)]
                currStr = "".join(str1)
                currStr = strStack.pop() + currStr
                
            # If its a char, concatenate with currStr
            else:
                currStr += c
               
                
        
        return currStr