"""
Use stack to track previous strings and repeat counts
On finding '[', push current string and count
On finsind ']', pop and repeat the last recorded string
"""
"""
Time Complexity: O(n) – Every character is processed
Space Complexity: O(n) – Stack space for nested structures
"""

class decodeString:
    def decodeStrings(self, s: str) -> str:
        stack = []
        curr_str = ""
        curr_num = 0

        for char in s:
            if char.isdigit():
                curr_num = curr_num * 10 + int(char)
            elif char == '[':
                stack.append((curr_str, curr_num))
                curr_str = ""
                curr_num = 0
            elif char == ']':
                prev_str, num = stack.pop()
                curr_str = prev_str + curr_str * num
            else:
                curr_str += char

        return curr_str

if __name__ == "__main__":
    obj = decodeString()
    print(obj.decodeStrings("3[a2[c]]"))       
    print(obj.decodeStrings("2[abc]3[cd]ef"))  
    print(obj.decodeStrings("10[a]"))           


