"""
APPROACH:
1. Walk through the string one character at a time, tracking a running number and a running string.
2. When a digit is seen, build up the multi-digit number (e.g. "12" becomes 12).
3. When "[" is seen, push the current number and string onto stacks, then reset both to start fresh.
4. When "]" is seen, pop the last number and string, and repeat the current string that many times, appending it after the popped string.
5. Any other character (a letter) is just appended to the current string.

PATTERN:
Stack (Two Stacks for Number and String)

TIME COMPLEXITY:
O(n * k) - n is length of s, k is the max repeat count, since repeated strings must be built out

SPACE COMPLEXITY:
O(n) - stacks and current string can grow proportional to input size

EXAMPLE:
Input:
s = "3[a2[c]]"

Output: "accaccacc"
Why: 2[c] becomes "cc", so 3[a2[c]] becomes 3[a + "cc"] = 3["acc"] = "accaccacc"
"""

class Solution:
    def decodeString(self, s: str) -> str:
        currNum = 0  # tracks current number being built (handles multi-digit numbers)
        currStr = ""  # tracks the string being built at current nesting level
        numStack = []  # stores numbers for outer levels while going deeper
        strStack = []  # stores strings for outer levels while going deeper

        for char in s:

            if char.isdigit():
                # build multi-digit numbers, e.g. "1" then "2" becomes 12
                currNum = int(char) + currNum * 10

            elif char == "[":
                # entering a new nested level, save current progress
                numStack.append(currNum)  # save the repeat count for later
                strStack.append(currStr)  # save the string built so far
                currNum = 0  # reset number for the new nested level
                currStr = ""  # reset string for the new nested level

            elif char == "]":
                # leaving a nested level, combine with saved outer progress
                prevNum = numStack.pop()  # get the repeat count for this level
                prevStr = strStack.pop()  # get the outer string to prepend
                currStr = prevStr + prevNum * currStr  # repeat and merge back into outer string
            
            else:
                # regular letter, just add it to current string
                currStr = currStr + char
        
        return currStr  # final fully decoded string