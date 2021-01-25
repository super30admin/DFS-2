#Time Complexity :O(maxk len(s))
#Space Complexity :O(l+d) l-no of letters in letter stack and digits in digit stack 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if(s==None or len(s)==0):
            return s
        
        numq=[]
        strq=[]
        
        curstr=''
        curnum=0
        
        for i in s:
            #print(numq,strq)
            if(i.isdigit()):
                curnum=curnum*10+int(i)
            elif(i.isalpha()):
                curstr+=i
            elif(i=='['):
                numq.append(curnum)
                strq.append(curstr)
                curstr=''
                curnum=0
            elif(i==']'):
                num=numq.pop()
                st=''
                for i in range(num):
                    st=st+curstr
                curstr=st
                st=strq.pop()
                curstr=st+curstr
                curnum=0
        return curstr
                    
        
        
        