# Time Complexity : O(K*N) - >K is max repeating number in the string 
# Space Complexity :    O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    def decodeString(self, s: str) -> str:
        if len(s)==0:
            return ""
        
        numstack = []
        charstack = []
        curStr = ""
        curnum = 0
        parent = ""
        
        for i in range(len(s)):
            if s[i].isdigit():
                curnum = curnum*10+int(s[i])               
            elif s[i].isalpha():
                curStr+=s[i]
            elif s[i] == '[':
                numstack.append(curnum)
                charstack.append(curStr)
                curnum = 0
                curStr = ""
            else:
                k = numstack.pop()
                parent = charstack.pop()
                for i in range(k):
                    parent+=curStr
                
                curStr = parent
        return curStr
