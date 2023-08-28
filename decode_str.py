class Solution:
    def decodeString(self, s: str) -> str:

        stack_num = []
        stack_char = []
        final_result = ""
        curr_str = ""
        nums = 0
        for i in range(len(s)):

            if s[i].isdigit():
               nums = nums *10 + int(s[i])
            
            elif s[i] == "[":
                stack_num.insert(0,nums)
                nums = 0
                
                stack_char.insert(0,curr_str)
                curr_str = ""
            
            elif s[i] == "]":
                final_result = curr_str * stack_num.pop(0)
                
                curr_str = stack_char.pop(0) + final_result
                
            else:
                curr_str = curr_str + s[i]


        return curr_str
