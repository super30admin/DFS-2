"""
TC/SC:O(KN)/O(n)
"""
class Solution:
    def decodeString(self, s: str) -> str:
        res = []
        for ch in s:
            if ch != ']':
                res.append(ch)
            else:
                string = ""
                while res and res[-1]!= '[':
                    string = res.pop() + string
                res.pop()
                num = ""
                while res and res[-1].isdigit():
                    num = res.pop() + num
                
                string = string * int(num)
                res.append(string)
        
        return "".join(res)
                
