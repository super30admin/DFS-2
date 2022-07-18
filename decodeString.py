#T(N)= O(N)
#S(N)= O(N)
class Solution:
    def decodeString(self, s: str) -> str:
        from collections import deque
        
        st1=deque()
        st2=deque()
        num=0
        st=""
        for i in s:
            if i.isalpha():
                st+=i
            elif i.isdigit():
                num=num*10+int(i)
    
            elif i=="[":
                st1.append(st)
                st2.append(num)
                print(st1,st2)
                st=""
                num=0
            elif i=="]":
                st=st1.pop()+(st2.pop()*st)
                
        # while st1:
        #     st=st1.pop()+st
        return st
            
                