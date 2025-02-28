# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)

# Use a standard boiler plate for directions. Initialize a queue to store leaf nodes. 
# We increment the count whenever we reach a '1', then we will check for all neighbouring elements and
# replace them by '0' to make sure we do not repeat
# We parse through all the nodes and keep on popping it from the stack until the entire grid is done.
# Return count which is total number of islands.

## Problem2 (https://leetcode.com/problems/decode-string/)

# Initialize a stack to maintain the string character followed by a digit.
# We parse over the string, if the character is a digit then we update the number of times the char 
# needs to be considered.
# If the string has an opening bracket then we push the string character and number to the stack
# If the string has an closing bracket then we pop the string and the digit
# Update the resultant string after the pop function and concatenate until the stack is empty. 