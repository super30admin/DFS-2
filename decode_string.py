"""
Time Complexity: O(n)
Space Complexity: O(n)
"""

#handle for numbers > 9
def decodeString(s):
    
    str_stack = []
    num_stack = []
    curr_str = ''
    curr_num = 0
    
    for char in s:
        if char.isdigit():
            curr_num = curr_num*10 + int(char)
        elif char == '[':
            str_stack.append(curr_str)
            num_stack.append(curr_num)
            curr_str = ''
            curr_num = 0
        elif char == ']':
            times = num_stack.pop()
            curr_str = str_stack.pop() + curr_str*times
        else:
            curr_str += char
            
    return curr_str