class Solution:
    def decodeString(self, s: str) -> str:
        str_stack =[]
        num_stack = []
        curr_num = 0
        curr_str = ''
        result = ''
        for c in s:
            if c.isdigit():
                curr_num = 10* curr_num + int(c)            
            elif c == '[':
                num_stack.append(curr_num)
                str_stack.append(curr_str)
                curr_num = 0
                curr_str = ''              
            elif c == ']':
                my_num = num_stack.pop()
                my_str = str_stack.pop()
                curr_str = my_str+my_num*curr_str         
            else:     #character
                curr_str += c                
        return curr_str