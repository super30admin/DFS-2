#Time Complexity : O(m*n)
#Space Complexity : O(m+n)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def decodeString(self, s: str) -> str:
        li = []
        for i in s:
            if i == "]":
                strr=""
                cha = ""
                while cha!="[":
                    strr += cha
                    cha = li.pop()
                ele = "1"
                strr3=""

                while (li and li[-1].isdigit()):
                    ele = li.pop()
                    strr3 = ele + strr3
                num = int(strr3)
                strr = num * strr
                strr = strr[::-1]
                for i in strr:
                    li.append(i)
                continue
            li.append(i)
        
        strr = ""
        for i in li:
            strr += i
        
        return strr
            
            