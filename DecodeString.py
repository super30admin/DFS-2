class Solution:
    def decodeString(self, s: str) -> str:
        
        num_stack = []
        str_stack = []
        
        num = 0
        curr_str = ""
        result = ""
        
        for i in range(len(s)):
            
            if s[i].isdigit():
                num = (num * 10) + int(s[i])
            elif s[i] == "[":
                num_stack.append(num)
                str_stack.append(curr_str)
                num = 0
                curr_str = ""
                
            elif s[i] == "]":
                times = num_stack.pop()
                curr_str = curr_str * times
                curr_str = str_stack.pop() + curr_str 
            else:
                curr_str = curr_str + s[i]
        return curr_str
                
                
        
    # Time complexity: O(maxk x n) where maxk is the maximum value of k and n is the length of the given string s. We traverse a string of length n and iterate time to decode the pattern. Hence the worst case time complexity will be maximum of k * len(s).
    
    # SPACE COMPLEXITY: O(m + n) where m and n are the number of digits and letter in string s.