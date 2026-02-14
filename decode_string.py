"""
time complexity: O(n*m) where n and m are the length of the input string and the maximum depth of nested brackets.
space complexity: O(n*m) in the worst case when the input string is fully nested and each character is a digit or a letter.
We use two stacks: one for numbers and one for characters. We iterate through the input string character by character. 
When we encounter a digit, we build the number until we hit a non-digit character. When we encounter an opening bracket '[', 
we push the current number onto the number stack and reset the number string. 
When we encounter a closing bracket ']', we pop the last number from the number stack and repeat the string built from the character stack 
until we hit the corresponding opening bracket.
"""

class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        char_stack=[]
        open_bracket_count=0
        num_str=''
        result=''
        for c in s:
            if c == '[':
                open_bracket_count+=1
                char_stack.append(c)
                num_stack.append(int(num_str))
                num_str=''
            elif c== ']':
                char_str=''
                while char_stack and char_stack[-1]!='[':
                    char_str = char_stack.pop() + char_str
                char_stack.pop() #pop '['
                open_bracket_count-=1
                if num_stack:
                    multiplier = num_stack.pop()
                    char_str*=multiplier
                    if open_bracket_count==0:
                        result+=char_str
                    else:
                        char_stack.append(char_str)
            elif c.isdigit():
                num_str+=c
            else:
                if open_bracket_count==0:
                    result+=c
                else:
                    char_stack.append(c)
        

        return result