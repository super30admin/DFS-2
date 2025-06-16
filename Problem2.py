"""
I used two stacks one to store the number of times a string needs to be repeated (nums), and another to store previously built strings (strings). When I encounter [, I push the current number and string onto their stacks and reset them. When I see ], I pop from both stacks and repeat the current string accordingly, then append it to the previous string.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def decodeString(self, s: str) -> str:
        nums = []
        strings = [] 
        currStr = ""
        currNum = 0

        for c in s:
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == '[':
                nums.append(currNum)
                strings.append(currStr)
                currNum = 0
                currStr = ""
            elif c == ']':
                times = nums.pop()
                prevStr = strings.pop()
                currStr = prevStr + currStr * times
            else:
                currStr += c
        
        return currStr      