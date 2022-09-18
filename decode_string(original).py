class Solution:
    def decodeString(self, s: str) -> str:
        num_stack=[]
        letter_stack=[]
        curr_str=""
        num=0
        
        for i in range(len(s)):
            if s[i].isdigit():
                num=num*10+int(s[i])
            
            elif s[i]=="[":
                letter_stack.append(curr_str)
                num_stack.append(num)
                curr_str=""
                num=0
            elif s[i]=="]":
                k=num_stack.pop()
                temp=k*curr_str
                parent=letter_stack.pop()
                curr_str=parent+temp
            else:
                curr_str+=s[i]
                
        return curr_str