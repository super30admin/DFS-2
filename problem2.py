// Time Complexity :O(n+sum of numbers in the string)
// Space Complexity :O(n) //n=len of string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
from collections import deque
class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s)==0:
            return s
        
        stackNum=deque()
        stackStr=deque()
        
        curNum=0
        curStr=''
        temp=''
        
        for i in s:         #traverse input string one character at a time
            if i.isdigit():     #if it is a digit store it in curNum
                curNum=curNum*10+int(i)
            elif i=='[':        //if it is '[' append curNum in StackNum and curStr in stackStr and reset curNum and curStr
                stackNum.append(curNum)
                stackStr.append(curStr)
                
                curNum=0
                curStr=''
                
            elif i==']':    # if it is ']' pop the last number from StackNum and append the curStr to local temp string exactly that number of times then update the curStr by popping the last element from stackStr and append temp
                popped=stackNum.pop()
                temp=''
                
                for j in range(popped):
                    temp+=curStr
                curStr=stackStr.pop()+temp
            else:   #if it is a character then append it in curStr
                curStr+=i
        
        return curStr
