###
#         Approach:
#         - Use a stack to handle nested encodings.
#         - Traverse the string character by character.
#         - When a digit is found, accumulate it as the repeat count.
#         - On encountering '[', push the current string and repeat count to the stack.
#         - On ']', pop from stack and build the expanded string.
#         - On a letter, keep appending it to the current string.
#         Time Complexity: O(n), where n = length of string
#         Space Complexity: O(n), for stack and result string
#         ##
class Solution:
    def decodeString(self, s):
        i = 0
        stack = []
        curr_sum = 0
        curr_string = ""
        for i in range(len(s)):
            if s[i].isdigit():
                curr_sum = curr_sum * 10 + int(s[i])
            elif s[i] == '[':
                stack.append((curr_sum, curr_string))
                curr_sum = 0
                curr_string = ""
            elif s[i] == ']':
                rep, prev_string = stack.pop()
                curr_string = prev_string + curr_string * rep
            else:
                curr_string += s[i]
        return curr_string
    
    def main(self):
        test_cases = [
            "3[a]2[bc]",       # Expected: "aaabcbc"
            "3[a2[c]]",        # Expected: "accaccacc"
            "2[abc]3[cd]ef",   # Expected: "abcabccdcdcdef"
            "abc3[cd]xyz",     # Expected: "abccdcdcdxyz"
        ]

        for s in test_cases:
            print(f"Input: {s}")
            print("Decoded:", self.decodeString(s))
            print("---")

# Run the test
sol = Solution()
sol.main()