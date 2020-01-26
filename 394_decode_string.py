class Solution:
    def decodeString(self, s: str) -> str:
        """
            https://leetcode.com/problems/decode-string/
            // Time Complexity : O(n)
                'n' is the length of the string
            // Space Complexity : O(n)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - Intialise current string, current number and
                            stack (holds prev string, and current current character count)
                    - Four cases:
                        - Chr is Digit      add to current number
                        - Chr is [          add to stack ( prev str, current number), reset
                        - Chr is ]          pop, add times * current str + prev str
                        - Chr is Character  just add to current string
        """
        cur_str = cur_num = ''
        stack = []

        for chr in s:
            if chr.isdigit():
                # cur_num = cur_num * 10 + ord(chr) - ord('0')
                cur_num += chr
            elif chr == '[':
                stack.append((cur_str, int(cur_num)))
                cur_str = cur_num = ''
            elif chr == ']':
                prev_str, ct = stack.pop()
                cur_str = prev_str + (cur_str * ct)
            else:
                cur_str += chr
        return cur_str
