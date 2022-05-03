class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        string_stack = []
        current_num = ""
        current_string = ""
        for i, c in enumerate(s):
            if c.isdigit():
                current_num+=c
                if current_string!="":
                    string_stack.append(current_string)
                    current_string = ""
            elif c == "[":
                string_stack.append("[")
                num_stack.append(int(current_num))
                current_num = ""
                current_string = ""
            elif c == "]":
                string = string_stack.pop()
                while(string!="["):
                    current_string = string + current_string
                    string = string_stack.pop()
                if num_stack:
                    num = num_stack.pop()
                    current_string = num * current_string    
                string_stack.append(current_string)
                current_string = ""
            else:
                current_string+=c
                if i==len(s)-1:
                    string_stack.append(current_string)
        while(num_stack):
            string = string_stack.pop()
            num = num_stack.pop()
            string = num * string
            string_stack.append(string)
        return "".join(string_stack)       