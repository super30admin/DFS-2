## Problem2 (https://leetcode.com/problems/decode-string/)
class Solution:
    def decodeString(self, s: str) -> str:
        """
        Time Complexity: O(L), where L is the length of the final decoded string. 
                         We iterate through the input string, but the string concatenation 
                         operations (especially in `joinString`) take time proportional to 
                         the length of the repeated strings being built.
                         
        Space Complexity: O(M), where M is the maximum depth of nested brackets. 
                          In the worst case, the stacks (`numStack` and `charStack`) will 
                          store an element for each opening bracket. We also use space 
                          to hold the final output string, which would be O(L).
        """
        # Stack to keep track of the multipliers (the numbers outside brackets)
        numStack = []
        # Stack to keep track of the previously built strings before encountering a '['
        charStack = []
        n = len(s)
        
        # 'num' keeps track of the current multiplier being parsed
        num = 0
        # 'result' tracks the current string sequence being built at the current nesting level
        result = ''

        # Helper function to repeat the string 's', 'times' number of times
        def joinString(s: str, times: int) -> str:
            res = ''
            for i in range(times):
                res += s
            return res

        # Iterate through each character in the encoded string
        for i in range(n):
            char = s[i]
            
            # CASE 1: Character is a letter
            # Simply append it to the current working string
            if char.isalpha():
                result += char
                
            # CASE 2: Character is a digit
            # Multiply the previous num by 10 to handle multi-digit numbers (like "12")
            elif char.isdigit():
                num = num * 10 + (ord(char) - ord('0'))
                
            # CASE 3: Character is an opening bracket '['
            # We are entering a new nested sequence. Push our current 'num' and 'result' 
            # to their respective stacks to save their state, then reset them.
            elif char == '[':
                numStack.append(num)
                charStack.append(result)
                num = 0
                result = ''
                
            # CASE 4: Character is a closing bracket ']'
            # We finished the current nested sequence. Pop the saved state and 
            # combine it with the repeated current sequence.
            elif char == ']':
                # How many times to repeat the current inner string
                times = numStack.pop()
                # The string that existed before the matching '['
                parentString = charStack.pop()
                
                # Construct the new result by attaching the multiplied string to the parent
                result = parentString + joinString(result, times)

        return result