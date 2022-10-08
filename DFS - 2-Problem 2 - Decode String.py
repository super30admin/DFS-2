"""
FAANMG Problem #68 {Medium}

394. Decode String

Time Complexity : O(max(length of char output, max number in string))

Space Complexity : O(max(length of char output, max number in string))


Did this code successfully run on Leetcode : Yes

Iterative Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def decodeString(self, s: str) -> str:
        
        # num_stack is for number stack and str_stack is for string stack
        str_stack = []
        num_stack=[]
        
        # initalize empty string and variables as 0 to use for calculations
        curr_num=-0
        sub_str=""
        
        # traverse over the whole string
        
        for c in s:
            # if we find a digit then store it in the curr num variable
            if( c.isnumeric()):
                curr_num = 10 * curr_num + int(c)
            
             # if we find an opening brace, then append the stack with the current string and number 
             #Rest the currnum and strsubstring to default
            elif( c=='[' ):
                str_stack.append(sub_str)
                num_stack.append(curr_num)
                curr_num=-0
                sub_str=""
                
            # if we find an closing brace, then pop the stack num_stack and str_stack
              
            elif( c==']' ):
                n = num_stack.pop()
                s_sub = str_stack.pop()
                
                #multiple the substring to the number
                sub_str= sub_str * n
                
                #add the current string to the previous sub string
                sub_str = s_sub + sub_str
            
            #Keep apending the char to the current substring
            else:
                sub_str = sub_str + c
                
        return sub_str
         
                
"""
FAANMG Problem #68 {Medium}

394. Decode String

Time Complexity : O(max(length of char output, max number in string))

Space Complexity : O(max(length of char output, max number in string))


Did this code successfully run on Leetcode : Yes

Recursive Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""                
                
                 
                
class Solution:    
    # global variable to keep track of the position of the char in string
    i = 0
    def decodeString(self, s: str) -> str:
        times = 0
        currNum = 0
        currStr = ''
        
        n = len(s)
        ch = ''
        
        
        # traversing over the string
        while self.i < n:
            
            ch = s[self.i]
            
            # check for digit, to get the times to be multiplied
            if ch.isdigit():
                currNum = currNum * 10 + ord(ch) - ord('0')
                self.i += 1
                
            # if we find an opening brace, then we recursively call the function with the string
            elif ch == '[':
                self.i += 1
                baby = self.decodeString(s)

                # multiply the string we got until we get an ending brace and then add it to the current string
                currStr = currStr + baby * currNum

                # reset the number
                currNum = 0

                # when finding a closing brace, increment the index and return the current string that we have till now
            elif ch == ']':
                self.i += 1
                return currStr
            else:
                # if all condition above doesn't work, that mean we have characters to add to the current string
                currStr += ch
                self.i += 1
        # at the end, simply return the current string
        return currStr      
        
"""
FAANMG Problem #68 {Medium}

394. Decode String

Time Complexity : O(max(length of char output, max number in string))

Space Complexity : O(max(length of char output, max number in string))


Did this code successfully run on Leetcode : Yes

Recursive Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""              
        
class Solution:    

    def decodeString(self, s: str) -> str:
        
        
        def dfs(index, cur_str):
            # every recursive call, we start with an empty string
            ret = ""  
            # as well as the num counte
            num = 0   
			
            while index < len(s):
                
                # deal with digit cases
                while s[index].isdigit(): 
                    num = num*10 + int(s[index])
                    index += 1
                
                # if we meet a '[', we need to recursive call the function
                if s[index] == '[': 
                                    
                    ret_str, end_pos = dfs(index + 1, "") 
                    # the ret_str will have what within the bracket, the end_pos is the index we have done in recursion
                    # then we add to current ret string
                    # and reset the num counter to zero
                    ret += num * ret_str
                    num = 0 
                    
                    # move current index to the position that have never deal with
                    index = end_pos + 1 
                    
                # if current index is a ']' return the current string and the current index positon    
                elif s[index] == ']': 
                    return ret, index
                
                # if we meet a characher, we direct add to ret, and move to next
                else: 
                    ret += s[index]
                    index += 1
                    
            # finally return the formed string and a index
            return ret, index 
        
        
        
        result, pos = dfs(0, "") # pos is only used for recursion inside, here is not useful
        
        return result
    
    