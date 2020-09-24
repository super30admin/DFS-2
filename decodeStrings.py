"""
394. Decode String
    
Time = O(k*n) where k = max integer value, n = length of string
space = O(k*n) where k = max integer value, n = length of string
Successfully excecuted on leetcode


Approach --
1. Stack + dfs
2. Create stack to store [string,number]. At each step we've 4 possibilities
3. If char is '[', append current string and current number to stack.
4. If char is ']', pop number and previous string and update current String as currString multiply with number and previousString
5. If char is digit, store it to CurNum, multiply currNum with 10 in case of numbers having multiple digits
6. Else char is string, append it to current string. 
7. At the end, return current String.
"""


class Decode:
    def decodeString(self, s: str) -> str:
        stack = []
        curNum = 0
        curString = ""
        for char in s:
            if c == "[":
                stack.append(curString)
                stack.append(curNum)
                curString = ""
                curNum = 0
            elif c == "]":
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num*curString
            elif c.isdigit():
                curNum = curNum*10 + int(c) #for numbers with more than one digits
            else:
                curString += c #Append to the empty string in first iteration
                
    return curString          
                
                