class Solution:
    def decodeString(self, s: str) -> str:

        string_q = list()
        number_q = list()
        currstr = []
        currnum = 0 

        for char in s:

            if char.isdigit():
                currnum = currnum * 10 + int(char)
            
            elif char == "[":
                number_q.append(currnum)
                string_q.append(currstr)

                currstr = []
                currnum = 0                 

            elif char == "]":
                count = number_q.pop()
                parent = string_q.pop()

                for k in range(count):
                    parent.extend(currstr)
                
                currstr = parent

            else:
                # Case: char is an alphabet
                currstr.append(char)

        return ''.join(currstr)

# Time complexity: O(n + m), where n is the input length and m is the decoded output length.
# Space complexity: O(n + m), dominated by the decoded output and the stacks.