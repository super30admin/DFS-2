## Problem2 (https://leetcode.com/problems/decode-string/)

class Solution:
    def decodeString(self, s: str) -> str: 
        if s == None or len(s)==0:
                return s
        st_str = []
        st_num = []
        curr_string = ""
        num = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num *10 + int(c)
            
            elif c =='[':
                st_num.append(num)
                st_str.append(curr_string)
                num = 0
                curr_string = ""
            elif c== ']':
                times = st_num.pop()
                temp = ""
                for j in range(times):
                    temp = temp + curr_string
                curr_string = st_str.pop() + temp
                    
                
            else:
                curr_string = curr_string + c
        return curr_string
    
        #Time Complexity: O(nk) n - length of the string k - max number of a substring/stack
        #Space Complexity: O(nk)
        #Approach: Use two stacks - one to push numbers and one to push the strings. Pop a number from the number stack when we encounter a closing bracket symbol run the string for that number of times and append it to the main string. When we encounter a open brackets push all the string values into the string stack along with respective number. Keep resetting the string and number to store the most recent substrings. 
             
        