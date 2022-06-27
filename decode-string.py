# Time Complexity: O(n), n = length of output string
# Space Complexity: O(n), n=length of input string
class Solution:
    
    def decodeString(self, s: str) -> str:
        cur_str=""
        num=0
        str_st=[]
        num_st=[]
        for i in range(len(s)):
            if s[i].isdigit():
                num=num*10+ (ord(s[i]) -ord('0'))
            elif s[i]=='[':
                str_st.append(cur_str)
                num_st.append(num)
                num=0
                cur_str=""
                
            elif s[i]==']':
                temp1=''
                x=num_st.pop()
                for j in range(x):
                    temp1+=cur_str
                
                cur_str=str_st.pop()+temp1
            else:
                cur_str+=s[i]
        return cur_str
    # Time Complexity: O(n), n = length of output string
    # Space Complexity: O(h), h= number of '[' in input string
    # i=0
    # def decodeString(self, s: str) -> str:
    #     global i
    #     cur_str=""
    #     num=0
    #     while self.i<len(s):
    #         if s[self.i].isdigit():
    #             num=num*10+int(s[self.i])
    #             self.i+=1
    #         elif s[self.i]=='[':
    #             self.i+=1
    #             st=self.decodeString(s)
    #             temp=''
    #             for j in range(num):
    #                 temp+=st
    #             cur_str=cur_str+temp
    #             num=0
    #         elif s[self.i]==']':
    #             self.i+=1
    #             return cur_str
    #         else:
    #             cur_str+=s[self.i]
    #             self.i+=1
    #     return cur_str
        
        
        
        
                
                
                
                
            
        