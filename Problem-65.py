#leet code - decode string - 394 - https://leetcode.com/problems/decode-string/
#Time complexity -O(N)
#space complexity-O(N)


class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack=[]
        currstr=""
        currnum=""
        for i in s:
            #case1
            if i.isdigit():
                currnum=currnum+i
            #case2:
            elif i=='[':
                stack.append((int(currnum),currstr))
                currnum,currstr="",""
             #case3
            elif i==']':
                n,prev=stack.pop()
                currstr=prev+n*currstr    
            #case4
            else:
                currstr=currstr+i
        return currstr
            
            
       