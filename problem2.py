'''
394. Decode String

APPROACH 1: DFS with stack
TIME COMPLEXITY: O(M*N) M = length of s, and N = numericals in the s
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: Nope. I solved it after the class.

APPROACH 2: Recursion
TIME COMPLEXITY: O(M*N) M = length of s, and N = numericals in the s
SPACE COMPLEXITY: O(no of brackets)
LEETCODE: Yes
DIFFICULTIES: Nope. I solved it after the class.

'''

from collections import deque

class Solution:
    def decodeString(self, st: str) -> str:
        
        # DFS with stack
        def approach1(s):
            res = ''
            nmbr = 0
            char_stk = deque()
            num_stk = deque()

            for char in s: # O(N)
                # case 1 - number
                if char.isnumeric():
                    nmbr = nmbr * 10 + int(char)

                # case 2 - [
                elif char == '[':
                    char_stk.append(res)
                    num_stk.append(nmbr)
                    res = ''
                    nmbr = 0

                # case 3 - ]
                elif char == ']':
                    temp_num = num_stk.pop()
                    res = ''.join([res for _ in range(temp_num)]) # O(num)
                    res = char_stk.pop() + res


                # case 4 - character
                else:
                    res += char

            return res
        
        # recursive approach
        def approach2(st):
            global n, s, i
            s = st
            n = len(s)
            i = 0
            
            def rec(): # recursion length = no of opening brackets
                global n, s, i
                
                nmbr = 0
                res = ''
                # base case is taken care by while loop
                                
                # logic
                while i < n:
                    char = s[i]
                    # case 1 - number
                    if char.isnumeric():
                        nmbr = nmbr * 10 + int(char)

                    # case 2 - [
                    elif char == '[':
                        i += 1
                        tmp = rec()
                        tmp = ''.join([tmp for _ in range(nmbr)])
                        res += tmp
                        nmbr = 0

                    # case 3 - ]
                    elif char == ']':
                        # temp_num = num_stk
                        # res = ''.join([res for _ in range(prev_num)]) # O(num)
                        # res = prev_res + res
                        return res

                    # case 4 - character
                    else:
                        res += char
                    i += 1
                
                return res
                
            return rec()
            
        
        return approach1(st)
        # return approach2(st)
        
