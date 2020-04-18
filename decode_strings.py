"""
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Given below
"""
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        #Method1 - Iterative Stack based solution
        """
        1. Stack for numbers and strings used to track prev state number and string
        2. If the char is "[", update the current_string and current_number inside []
        3. If the char is "]" , Pop the number from the number stack, update the current_string
        4. Update the process string(result) -> string from stack + current_string
        """
        numbers = []
        strings = []
        final_str = ""
        current_number = 0
        current_string = ""
        for ch in s:
            if ch.isdigit():
                #creating the number
                current_number= current_number*10 + int(ch)
            elif ch == '[':
                #updating the previous env state in the stacks 
                numbers.append(current_number)
                strings.append(current_string)
                #resetting the prev env states for number and string
                current_number=0
                current_string=''
            elif ch == "]":
                #Updating the current env string by using number before '[' and current_string and appending to previous env string(strings.pop())
                current_string = strings.pop() + numbers.pop()*current_string
            else:
                #updating the string
                current_string+=ch
        return current_string
        
        #Method2 - recursive solution
        """
        Main pointers - Using current_number to update the current_string 
        and appending to existing string and returning it to caller fn
        """
        def rec_decode(s,i):
            current_number = 0
            final_string = ""
            j = i
            while j < len(s):
                if s[j].isdigit():
                    current_number = current_number * 10 + int(s[j])
                elif s[j] == '[':
                    #Get the string inside the []
                    value = rec_decode(s,j+1)
                    current_string= value[0]
                    j = value[1]
                    #Appending the formed string to final_string
                    final_string += current_number * current_string
                    current_number = 0
                elif s[j] == ']':
                    #returning j to update the last pointer in the string and avoid traversing same chars again
                    return final_string,j
                else:
                    #appending the chars to string
                    final_string+=s[j]
                j+=1
            return final_string,j
        
        a = rec_decode(s,0)
        return a[0]