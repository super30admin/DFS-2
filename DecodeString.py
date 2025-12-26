'''
In this problem, given a string with digits, characters and opening and closing braces we need to find the decoded string.
To solve this problem, I considered 2 stacks for numeric values and characters separately, and 2 variables to store current numberic and characters which initially set to 0 and empty string.
Initially I stored the digits while storing its denomination value and the charecter string untill we found a opening brace, once we see a opening brace we store the current values to stacks in order to resolve innermost values first.
once stored in the stack, we reset the current values to its default values. Then moving forward when we find a closing brace, we perfrom pop on numeric stack and repeat the value in charecter stack as many times as the popped value.
and combine it with the next character value.
We repeat this until we go out of bound on the string.
'''
class Solution:
    def decodeString(self, s: str) -> str:
        # stacks for storing numeri and character values seperately
        numSt = []
        strSt = []
        # to store current values
        currNum = 0
        currStr = []

        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            # add respective values to its stacks
            elif c == '[':
                strSt.append(currStr)
                numSt.append(currNum)
                # updating curr values to default values
                currNum = 0
                currStr = []
            # pop and repeat the characters after every brace closing
            elif c == ']':
                cnt = numSt.pop()
                parent = strSt.pop()

                for k in range(cnt):
                    parent.extend(currStr)
                currStr = parent
            else:
                currStr.append(c)
        
        return ''.join(currStr)

'''
Time Complexity: O(n*k)
Time taken is equal to the length of output string, which is maximum repeat count times the length of the string.
Space Complexity: o(n*k)
maximum space taken is similar to the depth of the stack.
'''