# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        count_stack = []
        result_stack = []
        current = []
        k = 0

        for ch in s:
            if ch.isdigit():
                k = k * 10 + int(ch)
            elif ch == '[':
                count_stack.append(k)
                result_stack.append(current)
                current = []
                k = 0
            elif ch == ']':
                decoded_string = result_stack.pop()
                repeat_times = count_stack.pop()
                current = decoded_string + current * repeat_times
            else:
                current.append(ch)

        return ''.join(current)

# Example usage:
sol = Solution()

# Example 1
s1 = "3[a]2[bc]"
print("Input: {}".format(s1))
print("Output: {}".format(sol.decodeString(s1)))

# Example 2
s2 = "3[a2[c]]"
print("\nInput: {}".format(s2))
print("Output: {}".format(sol.decodeString(s2)))

# Example 3
s3 = "2[abc]3[cd]ef"
print("\nInput: {}".format(s3))
print("Output: {}".format(sol.decodeString(s3)))