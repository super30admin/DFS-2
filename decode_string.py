# Time complexity: O(output string size)
# Space complexity: O(n)
# Approach: there are 4 cases while traversing the string:
# alphabet, number, '[' , ']'.
# we will have 2 stacks one for number and one for string, 
# we will have two string variables, one for string and one for number
# if we encounter a character or number, we just add it to the corresponding variable
# if we encounter a opening bracket-'[',
# put the string and numeric values to corresponding stack and empty the variables.
# if we encounter a closing bracket - ']',
# that means we can append it to the string,
# so, pop from numstack and run a loop for (poppped value) as number of times,
# and attach the string variable those many times to a new string.
# now, append the (popped value from string stack to this string in front and put this string to the string variable)



class Solution:
    def decodeString(self, s: str) -> str:
        stringstack = []
        numstack = []
        output = ''
        num =''
        for c in s:
            if ord('0') <= ord(c) <= ord('9'):
                num += c
            elif ord('a') <= ord(c) <= ord('z'):
                output += c
            elif c == '[':
                stringstack.append(output)
                numstack.append(num)
                num = ''
                output =''
            else:
                count = int(numstack.pop())
                bufferstring =''
                for i in range(count):
                    bufferstring += output
                output = bufferstring
                parent = stringstack.pop()
                output = parent + output
        return output
                    
                    
                    
                
                
                
            
        
        
        