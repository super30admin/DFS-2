'''
Time Complexity -->
O(n)

Space Complexity -->
O(n) + O(n)
'''
class Solution:
    def decodeString(self, s: str) -> str:
        #we can make use of two stacks one for number and one for string character
        st_num = []
        st_string = []
        newst = ''
        num = 0
        st =''
        for i in s:
            if i.isdigit():
                num = num*10+ (ord(i)-ord('0'))
            elif i=='[':                   #Start the process
                st_num.append(num)
                st_string.append(st)
                num = 0
                st = ''
            
            elif i==']':  #time to resolve
                n = st_num.pop(-1)
                newst = n*st
                st = st_string.pop(-1) + newst
                
                
            
            else:
                st+=i
        return st
                
                
            
            
        