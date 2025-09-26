# Space Complexity: O(N)
# Time Complexity: O(N)

class Solution:
    def decodeString(self, s: str) -> str:
        
        number_stack = collections.deque()

        string_stack = collections.deque()

        curr_num, curr_str = 0, ""
        for ch in s: 
            # if the ch is a number
            if ch.isnumeric(): 
                curr_num = curr_num * 10 + int(ch)

            elif ch == '[': 
                string_stack.append(curr_str)
                number_stack.append(curr_num)
                curr_num, curr_str = 0, ""

            
            elif ch == ']':
                # decode the baby
                count = number_stack.pop()
                decoded_baby = curr_str * count 
                parent = string_stack.pop()
                curr_str = parent + decoded_baby
            
            # if its a string
            else: 
                curr_str += ch

        return curr_str



