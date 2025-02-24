# 394. Decode String

# Time Complexity: O(maxK⋅n), 
# where maxK is the maximum value of k and n is the length of a given string. 
# We traverse a string of length n and iterate k times to decode each pattern of form k[string]. 
# This gives us worst case time complexity as O(maxK⋅n).

# Space Complexity: O(m+n), 
# where m is the number of letters (a-z) and n is the number of digits (0-9) in strings. 
# In worst case, the maximum size of stringStack and countStack could be m and n respectively.

# 2 Stack Approach: 
class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        
        stack = []
        curr_num = 0
        curr_str = ""

        for char in s:
            if char.isdigit():
                curr_num = curr_num * 10 + int(char)
            elif char == '[':
                stack.append(curr_str)
                stack.append(curr_num)
                curr_str = ""
                curr_num = 0
            elif char == ']':
                num = stack.pop()
                temp = ""
                for _ in range(num):
                    temp += curr_str
                curr_str = stack.pop() + temp
            else:
                curr_str += char
        return curr_str
    
# Using Recursion:
class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        
        self.index = 0
        return self.decode(s)
    
    def decode(self, s):
        curr_str = ""
        curr_num = 0
        
        while self.index < len(s):
            if s[self.index].isdigit():
                curr_num = curr_num * 10 + int(s[self.index])
                self.index += 1
            elif s[self.index] == '[':
                self.index += 1
                decoded_str = self.decode(s)
                for _ in range(curr_num):
                    curr_str += decoded_str
                curr_num = 0
            elif s[self.index] == ']':
                self.index += 1
                return curr_str
            else:
                curr_str += s[self.index]
                self.index += 1
        
        return curr_str