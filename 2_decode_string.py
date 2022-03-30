// Time Complexity : maximum product * maximum length of the string 
// Space Complexity : maximum product * maximum length of the string 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

'''
1. Push to stack till we see a closing bracket
2. When closing bracket occurs, pop till open bracket
3. Also pop digit
4. Process the string and append to stack
5. at the end join all strings in stack and return the 

'''

class Solution(object):
    def decodeString(self, s):
        stack=[]
        for i in s:
            if i!=']':
                stack.append(i)
            else:
                    st=''
                    while stack[-1] !='[':
                        char=stack.pop()
                        st=char+st
                    stack.pop()

                    if stack[-1].isdigit():
                        num=''
                        while len(stack)>0 and stack[-1].isdigit():
                                num= stack.pop()+num

                        r=''
                        for i in range(0,int(num)):
                            r=r+st
                        stack.append(r)
                    else:
                        stack.append(st)
        return (''.join(stack))
            
            
            
        