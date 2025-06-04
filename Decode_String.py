# Time Complexity = O(n)
# Space Complexity = O(n)
class Solution:
    def decodeString(self, s: str) -> str:

        stack = []

        for i in s:
            if i!=']':
                stack.append(i)
            else:
                temp_string = ""
                while stack[-1]!='[':
                    temp_string = stack.pop() + temp_string
                stack.pop()
                curr_num = ""
                while stack and stack[-1].isdigit():
                    curr_num = stack.pop() + curr_num
                    
                temp_string =  int(curr_num)*temp_string 
                stack.append(temp_string)
        
        return "".join(stack)


        