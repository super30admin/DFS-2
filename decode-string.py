'''
TC: O(L)
SC: O(L)

L - length of the dechipered string

Intuition: Connected Components, inplace change
'''
class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return
        
        cstack, nstack = list(), list()
        
        curr = ""
        for ch in s:
            if ch == "[":
                start = len(curr)
                while start > 0 and curr[start - 1].isdigit():
                    start -= 1
                cstack.append(curr[:start])
                nstack.append(curr[start:])
                curr = ""
            elif ch == "]":
                curr = cstack.pop() + curr * int(nstack.pop())
            else:
                curr += ch
        
        return curr
        
        
        