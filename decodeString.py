class Solution:

    def decodeString(s):
        stack=[]
        current_num=0
        current_str=''

        for char in s:
            if char.isdigit():
                current_num=current_num*10+int(char)
            elif char =='[':
                stack.append((current_str,current_num))
                current_str=''
                current_num=0
            elif char==']':
                prev_str,num=stack.pop()
                current_str=prev_str+num*current_str
            else:
                current_str+=char

        return current_str


print(Solution.decodeString("3[a]2[bc]"))
print(Solution.decodeString("3[a2[c]]"))
print(Solution.decodeString("2[abc]3[cd]ef"))
    