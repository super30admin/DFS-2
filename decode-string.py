#----------------Solution 1 : Iterative using Stack -----------
''' Time Complexity : O(n * k) , n : len of string, k : maximum repaeat count
    Space Complexity : O(n * k)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

Approach : 1. if digit : get the count
           2. if [ : push curr_string and cnt to stack
                     reset to curr = "" and cnt = 0 
                     (idea : new decoding started; add preveious to stacks and reset to new)
          3. if ] : get cnt from stack : append curr_string * cnt to create baby string
                    get papa string from stack , append baby to papa and make as curr_string
         4. else : alpha char : just append to curr_string          
'''
class Solution:
    def decodeString(self, s: str) -> str:
        i_stack = []
        s_stack = []
        curr = ""
        cnt = 0
        n = len(s)
        i = 0
        while i < n:
            char = s[i]
            if char.isdigit():
                cnt = cnt * 10 + int(char)
            elif char == "[":
                s_stack.append(curr)
                i_stack.append(cnt)
                curr = ""
                cnt = 0
            elif char == "]":
                c = i_stack.pop()
                baby_str = ""
                for j in range(0,c):
                    baby_str += curr
                papa_str = s_stack.pop()
                curr = papa_str + baby_str
            else:
                curr += char
            i += 1
        return curr


#----------------Solution 2 : Recursive -----------
''' Time Complexity : O(n * k) , n : len of string, k : maximum repaeat count
    Space Complexity : O(n * k)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

Approach : 1. if digit : get the count
           2. if [ : Inc i; call the recursive fucntion strting (which will start from i)
                     append the return string to curr(papa)
          3. if ] : inc i and return the curr_String
         4. else : alpha char : just append to curr_string          
'''
class Solution:
    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:
        curr = ""
        cnt = 0
        n = len(s)
        while self.i < n:
            char = s[self.i]
            if char.isdigit():
                cnt = cnt * 10 + int(char)
                self.i += 1
            elif char == "[":
                self.i += 1
                decoded_str = self.decodeString(s)
                for j in range(cnt):
                    curr += decoded_str
                cnt = 0            
            elif char == "]":
                self.i += 1
                return curr
            else:
                curr += char
                self.i += 1
        return curr