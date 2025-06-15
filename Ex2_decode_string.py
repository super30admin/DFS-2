# Time Complexity : O(n * k), where n is the length of the input string and k is the maximum repeat count
# Space Complexity : O(n * k), due to the stack and final decoded string construction
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

class Solution(object):
    def decodeString(self, s):
        
        # stack-based iterative approach
        stack = []
        curr = []
        num = 0

        for ch in s:
            if ch.isdigit():
                num = num * 10 + int(ch)         # Build multi-digit number
            elif ch == "[":
                stack.append(("".join(curr), num))  # Save current context
                curr = []
                num = 0
            elif ch == "]":
                prev, k = stack.pop()            # Retrieve previous context
                curr = list(prev) + curr * k     # Decode current segment
            else:
                curr.append(ch)                  # Append character

        return "".join(curr)

        # ---------------------------------------
        # Alternative: Recursive DFS approach
        # Time Complexity : O(n * k)
        # Space Complexity : O(n * k) due to recursion depth and final string

        # def decode(i):
        #     res = []
        #     while i < len(s) and s[i] != "]":
        #         if s[i].isalpha():
        #             res.append(s[i])
        #             i += 1
        #         elif s[i].isdigit():
        #             k = 0
        #             while s[i].isdigit():
        #                 k = k * 10 + int(s[i])
        #                 i += 1
        #             i += 1  # skip '['
        #             decoded_string, i = decode(i)
        #             res.append(decoded_string * k)
        #             i += 1  # skip ']'
        #     return ''.join(res), i
        #
        # result, _ = decode(0)
        # return result


if __name__ == "__main__":
    sol = Solution()

    # Test Case 1: Simple repeats
    print(sol.decodeString("3[a]2[bc]"))        # Expected: aaabcbc

    # Test Case 2: Nested brackets
    print(sol.decodeString("3[a2[c]]"))         # Expected: accaccacc

    # Test Case 3: Multiple sequences with suffix
    print(sol.decodeString("2[abc]3[cd]ef"))    # Expected: abcabccdcdcdef

    # Test Case 4: Double digit repeat count
    print(sol.decodeString("10[a]"))            # Expected: aaaaaaaaaa

    # Test Case 5: Nested inside sequence
    print(sol.decodeString("3[ab2[c]]"))        # Expected: abccabccabcc
