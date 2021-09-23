# // Time Complexity :O(n)
# // Space Complexity :O(k)where k is the depth of tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        self.i=0
        
    def decodeString(self, s: str) -> str:
        num=0
        curstr=""
    
        while(self.i<len(s)):
            print(curstr)
            print(s)
            print(self.i)
            c=s[self.i]
            print(c)
            if c.isdigit():
                num=(num*10)+int(c)
                print(num)
                self.i=self.i+1
            elif c=='[':
                self.i=self.i+1
                decode=self.decodeString(s)
                print(num)
                curstr=curstr+(decode*num)
                num=0
                print(curstr)
            elif c==']':
                self.i=self.i+1
                return curstr
            else:
                curstr=curstr+c
                self.i=self.i+1
        return curstr
                
        