#time = O(n)
#space = O(n)
def decodeString(s):
    num_stack = []  # Stack to store numbers
    str_stack = []  # Stack to store strings
    current_str = ""
    k = 0
    
    for char in s:
        if char.isdigit():
            k = k * 10 + int(char)
            print(char)
        elif char == '[':
            # Push the current number and string onto their respective stacks
            num_stack.append(k)
            str_stack.append(current_str)
            # Reset the current number and string
            k = 0
            current_str = ""
        elif char == ']':
            # Pop the number and previous string
            prev_k = num_stack.pop()
            prev_str = str_stack.pop()
            # Decode the current string
            current_str = prev_str + prev_k * current_str
        else:
            current_str += char
    
    return current_str

# Examples
print(decodeString("3[a]2[bc]"))      # Output: "aaabcbc"
# print(decodeString("3[a2[c]]"))       # Output: "accaccacc"
# print(decodeString("2[abc]3[cd]ef"))  # Output: "abcabccdcdcdef"
