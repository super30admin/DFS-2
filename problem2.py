#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
class Solution:
    def decodeString(self, s: str) -> str:
        currstr = ""
        currnum = 0
        stack1 = []
        stack2 = []
        for i in range (len(s)):
            c = s[i]
            if c.isdigit():
                currnum = currnum * 10 + (ord(c)-ord('0'))
            elif c == '[':
                stack1.append(currstr)
                stack2.append(currnum)
                currstr = ""
                currnum = 0
            elif c == ']':
                popped = stack2.pop()
                temp = ""
                for j in range(popped):
                    temp += currstr
                currstr = stack1.pop() + temp 
#If the next char is simple char
            else:
                currstr += c
        return currstr