'''
 Time Complexity : 0(n)
 Space Complexity : 0(n)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : yes, it failed many test cases initially, it took me
 long time to make it work for all test cases.


 Your code here along with comments explaining your approach
 - If the char is a digit we  keep inserting them till `[` doesn't occur
 - We add all characters it into stack until `]` doesn't occur
 - we pop all characters and multiple with the number we have
 and add it onto the stack
 - after reaching the end, we joing the string contents present
 in the stack

'''

class Solution(object):
    def decodeString(self, s):
        if not s:
            return s
        i = 0
        string = ""
        result = []
        
        while(i < len(s)):
            if s[i].isdigit():
                num = ""
                
                while(s[i] != "["):
                    num += s[i]
                    i += 1
                
                num = int(num)
                result.append(num)
            
            elif s[i] == "]":
                str = ""
                
                while(result[-1] != "["):
                    str = result.pop() + str
                
                result.pop()
                str = result.pop() * str
                result.append(str)
                i+=1
            
            else:
                result.append(s[i])
                i+=1 
                
        return "".join(result)