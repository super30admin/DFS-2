# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque

class Solution:
    def decodeString(self, s: str) -> str:
        q1=deque([])
        q2=deque([])
        f_num=0
        mul=0
        final_string=""
        for i in s:
            # f_num=0
            if(i.isnumeric()):
                f_num=f_num*10+int(i)
            else:
                if(f_num):
                    q1.append(f_num)
                f_num=0
                q2.append(i)
                print(q1, q2)
                if(i==']'):
                    mul=q1.pop()
                    j=i
                    k=""
                    while(j!='['):
                        j=q2.pop()
                        if(j.isalpha()):
                            k+=j
                    if(len(q2)):
                        if(len(q1)):

                            q2.append(k*mul)
                            k=""
                        else:
                            q2.append(k[::-1]*mul)
                            k=""
                    else:
                        final_string+=k[::-1]*mul
                        k=""
                        continue
        while(len(q2)):
            final_string=final_string+q2.popleft()

        return final_string
                    

                        
        # print(q1, q2)
