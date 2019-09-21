# Decode String
# Time complexity: O(sum of (multiplication of integer followed by size of string in the bracket))
# Space complexity: O(sum of (multiplication of integer followed by size of string in the bracket))
# Approach: Approach is similar to bracket matching algorithm. 
#			The only difference is identify the string in the brackets, multiply it times the number before the bracket and then
#			push the resulting string onto the stack again.
#			Result is the stack in reverse.

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for i in s:
            if i != ']':
                stack.append(i)
            else:
                tmp_str_list = []
                while stack[-1] != '[':
                    char = stack.pop()
                    tmp_str_list.append(char)
                stack.pop()
                times = []
                while len(stack) > 0  and '0' <= stack[-1] <= '9':    
                    times.append(stack.pop())
                times_int = int("".join(times[::-1]))
                new_str_list = tmp_str_list[::-1] * times_int
                stack = stack + new_str_list
        
        return "".join(stack)
                