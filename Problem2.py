"""
TC: O(N * M) {where N is the length of the encoded string and M is the maximum number of times any character is repeated}
SC: O(N) {in the worst-case scenario, the stack can hold a significant portion of the decoded string}

Approach:

This problem can be effectively solved using a **stack** to handle the nested nature of the encoded string. The core idea is to process the string from **right to left**, building the decoded string as we go. Processing from right to left simplifies handling the numbers and brackets.

We iterate through the encoded string from the end to the beginning.
If we encounter a **non-digit character**, we simply push it onto the stack.
If we encounter a **digit**, it signals the start of a repeated sequence. We extract the full multi-digit number, which may span multiple characters. Then, we pop characters from the stack to form the substring to be repeated. This process continues until we find the closing bracket `]`. We remove both the opening and closing brackets from the stack. The extracted substring is then repeated the specified number of times, and the individual characters of the repeated string are pushed back onto the stack.

After iterating through the entire input string, the stack will contain the characters of the fully decoded string in reverse order. We can then join these characters and reverse the final result to get the correct output.

The problem ran successfully on LeetCode.
"""

class Solution:
    def decodeString(self, s: str) -> str:

        stack = []
        i = len(s)-1

        while i >= 0:
            if s[i].isdigit():
                multi = ""
                while s[i].isdigit():
                    multi += s[i]
                    i -=1
                multi = int(multi[::-1])

                temp = ""

                #remove the [
                stack.pop()
                
                while stack[-1] != "]":
                    temp += stack.pop()

                #remove the ]
                stack.pop()

                for j in range(multi):
                    for each in temp[::-1]:
                        stack.append(each)
            else:
                stack.append(s[i])
            
                i -= 1
        
        return "".join(stack[::-1])