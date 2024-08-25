# Time COmplexity: O(len(output)) => depends on the product of numbers till the innermost loop
# Space COmplexity: O(h) => h is the no of nestings.
class Solution:

    def decodeString(self, s: str) -> str:

        def decode(s):
            nonlocal idx
            curr_str = ""
            curnum = 0
            while idx < len(s):
                ch = s[idx]
                idx += 1
                if ch.isnumeric():
                    curnum = curnum*10 + int(ch) 
                elif ch == '[':
                    decoded_str = decode(s)
                    curr_str += decoded_str * curnum
                    curnum = 0
                elif ch == ']':
                    return curr_str
                else:
                    curr_str += ch
            return curr_str
        idx = 0
        return decode(s)
            
