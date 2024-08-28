########394. Decode String###################################################################################
// Time Complexity : O(n) -> as we are going through list just once
// Space Complexity : O(n) -> for 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
Here we have maintained 2 stacks 1 stack for int and another for character, also we keep track of currentstring and current int which will help us to identify the number of string that we will put in stacks when and [ is encountered we insert the current value of currstring and current in stack and when  ] is encountered we poppet element for both stack and multiply by the times the int is present.

class Solution:
    def decodeString(self, s: str) -> str:
        stackint=[]
        stackstring=[]
        tmpint=0
        #tmpstr=''
        currstr=''
        for i in s:
            #print(i)
            if i.isnumeric():
                tmpint=tmpint*10+int(i)
                #print('int ',stackint,stackstring,tmpint,currstr)
            elif i=='[':
                stackint.append(tmpint)
                stackstring.append(currstr)
                tmpint=0
                currstr=''
                #print('[ ',stackint,stackstring,tmpint,currstr)
            elif i==']':
                #t1=''
                cnt=stackint.pop()
                stackstr=stackstring.pop()
                currstr=currstr*cnt
                #print(cnt,currstr)
                #t1=parentstr+t1
                #stackstr=stackstring.pop()
                currstr=stackstr+currstr
                #tmpstr=''
                #print('] ',stackint,stackstring,tmpint,currstr)
            else:
                currstr+=i
                #print('str ',stackint,stackstring,tmpint,currstr)
        return currstr

        
        
        
            
            

        
        
