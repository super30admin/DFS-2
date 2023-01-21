# Time Complexity :O(n) // Length of the Output
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def decodeString(self, s):
        currCount=0
        currStr=""
        Numq=deque()
        Strq=deque()
        for i in s:
            if(i.isnumeric()):
                currCount=10*currCount+int(i)
            elif(i=='['):
                Strq.append(currStr)
                Numq.append(currCount)
                currCount=0
                currStr=""

            elif(i==']'):
                currStr=currStr*Numq.pop()
                currStr=Strq.pop()+currStr

            else:
                currStr+=i
        return(currStr)



        