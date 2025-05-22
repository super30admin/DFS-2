# Approach 1: Single Stack Iterative Approach
# Time Complexity: O(n), Space Complexity: O(n)
class SolutionStack:
    def decodeString(self, s: str) -> str:
        stack = []

        for i in range(len(s)):
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""
                while stack[-1] != "[":
                    substr = stack.pop() + substr
                stack.pop()  # Remove '['

                k = ""
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                stack.append(int(k) * substr)

        return "".join(stack)


# Approach 2: Two Stack Iterative Approach
# Time Complexity: O(n), Space Complexity: O(n)
class SolutionTwoStacks:
    def decodeString(self, s: str) -> str:
        count_stack = []
        string_stack = []
        current_string = ""
        current_num = 0

        for char in s:
            if char.isdigit():
                current_num = current_num * 10 + int(char)

            elif char == "[":
                count_stack.append(current_num)
                string_stack.append(current_string)
                current_string = ""
                current_num = 0

            elif char == "]":
                repeat_times = count_stack.pop()
                prev_string = string_stack.pop()
                current_string = prev_string + current_string * repeat_times

            else:
                current_string += char

        return current_string


# Approach 3: Recursive Stack Approach (Recursive Descent Parsing)
# Time Complexity: O(n), Space Complexity: O(n) due to recursion stack
class SolutionRecursive:
    def decodeString(self, s: str) -> str:
        def dfs(index):
            result = ""
            k = 0

            while index < len(s):
                char = s[index]

                if char.isdigit():
                    k = k * 10 + int(char)

                elif char == "[":
                    sub_str, index = dfs(index + 1)
                    result += k * sub_str
                    k = 0

                elif char == "]":
                    return result, index

                else:
                    result += char

                index += 1

            return result, index

        decoded, _ = dfs(0)
        return decoded


test_input = "3[a2[c]]"

sol1 = SolutionStack()
print("Output1:", sol1.decodeString(test_input))

# Approach 2
sol2 = SolutionTwoStacks()
print("Output2:", sol2.decodeString(test_input))

# Approach 3
sol3 = SolutionRecursive()
print("Output3:", sol3.decodeString(test_input))
