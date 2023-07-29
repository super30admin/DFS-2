# Time complexity : O(n)
# Space complexity : O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        string_stack=[]
        num_stack=[]
        cur_str=''
        cur_num=0

        for i in range(len(s)):
            char=s[i]

            if char.isdigit():
                cur_num=cur_num*10+int(char)
            
            if char=='[':
                num_stack.append(cur_num)
                cur_num=0
                string_stack.append(cur_str)
                cur_str=''

            if char.isalpha():
                cur_str+=char
            
            if char==']':
                num=num_stack.pop()
                temp=cur_str*num
                st=string_stack.pop()
                cur_str=st+temp
        return cur_str



