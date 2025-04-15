# Approach:
# 1. Use a stack to process each character in the string.
# 2. When encountering ']', pop characters to get the substring and number k, then repeat the substring k times and push it back to the stack.
# 3. Finally, join all elements in the stack to get the decoded string.

# Time Complexity: O(N) — where N is the length of the string (each character is processed once)
# Space Complexity: O(N) — for storing characters in the stack

class Solution:
    def decodeString(self, s: str) -> str:

        stack = []

        for i in range(len(s)):
            if s[i] != ']':  # Push character if not ']'
                stack.append(s[i])
            else:
                # Pop till '[' to get the substring
                substr = ''
                while stack[-1] != '[':
                    substr = stack.pop() + substr

                stack.pop()  # remove '['

                # Get the number k
                k = ''
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k

                # Push repeated substring
                stack.append(int(k) * substr)

        return ''.join(stack)
