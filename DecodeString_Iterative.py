# TC: O(max(k) + N) where k are the numbers in the string, i.e. times we are iterating a string. And N is the length of the input string. 
# SC: O(M + N) where M is the no. of letters(a-z) in the string and N is the number of digits in the input string.

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return
        
        numStack = []
        strStack = []
        num = 0
        curr_str = ""
        
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + ord(s[i]) - ord('0')
            elif s[i] == '[':
                numStack.append(num)
                strStack.append(curr_str)
                num = 0
                curr_str = ""
            elif s[i] == ']':
                times = numStack.pop()
                new_str = ""
                for i in range(times):
                    new_str += curr_str
                
                curr_str = strStack.pop() + new_str
            else:
                curr_str = curr_str + s[i]
        return curr_str
        
