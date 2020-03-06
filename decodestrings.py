// Time Complexity : Solution incomplete
// Space Complexity : Solution incomplete
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes, couldn't completely solve the question


// Your code here along with comments explaining your approach

class Solution:
    def decodeString(self, s: str) -> str:
        num = 0
        index = 0
        decoded = ""
        intermediate = ""
        return self.helper(s, index, num, decoded, intermediate)
    
    def helper(self, s, index, num, decoded, intermediate):
        
        if index == len(s):
            return decoded
        
        if s[index].isdigit():
            num = num*10 + int(s[index])
            
        if s[index].isalpha():
            intermediate += s[index]
            
        if s[index] == '[':
            num = 0
            intermediate = ""
            return self.helper(s, index+1,num,decoded,intermediate)
            
        if s[index] == ']': 
            decoded += intermediate*num
     
        return self.helper(s, index+1,num,decoded,intermediate)
            
        