# 394. Decode String

# TC : O(n), where n is the maximum length of the expanded string.
# SC : O(m), where m is the depth of nested brackets. This is due to the recursive call stack.
# Did this code successfully run on Leetcode : Yes

# Approach :
# Use recursion to handle nested patterns in the encoded string.
# Maintain a global index pointer to keep track of the current position in the string.
# The DFS function builds up the decoded string by processing characters one by one.
# When it encounters a digit, it extracts the number and then recursively processes the inner string.
# The recursive call continues until it encounters a closing bracket, which signals the end of the current segment.
# After returning from the recursive call, the function appends the decoded inner string to the result, repeated the specified number of times.

# Line-by-Line Explanation:
    # Initialize a global index pointer to keep track of the current position in the string.
    # In the DFS function:
        # Initialize an empty result string.
        # Process characters until we reach the end or find a closing bracket:
            # If the current character is not a digit, add it to the result.
            # If it's a digit, extract the full number, skip the opening bracket, recursively decode the inner string, skip the closing bracket, and append the decoded string repeated the specified number of times.
    # Return the result string once we're done processing the current segment.
    # Start the recursion from the beginning of the string.

class Solution:
    def decodeString(self, s: str) -> str:
        # Initialize global index pointer
        self.index = 0
        
        # Main recursive function to decode the string
        def dfs():
            result = ""
            
            # Continue until we reach the end or closing bracket
            while self.index < len(s) and s[self.index] != ']':
                # If current character is not a digit, add it to result
                if not s[self.index].isdigit():
                    result += s[self.index]
                    self.index += 1
                else:
                    # Extract number (k)
                    k = 0
                    while self.index < len(s) and s[self.index].isdigit():
                        k = k * 10 + int(s[self.index])
                        self.index += 1
                    
                    # Skip the opening bracket
                    self.index += 1  # Skip '['
                    
                    # Recursive call to decode the inner string
                    decoded = dfs()
                    
                    # Skip the closing bracket
                    self.index += 1  # Skip ']'
                    
                    # Append the decoded string k times
                    result += decoded * k
            
            return result
        
        return dfs()
        