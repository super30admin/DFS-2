"""
Iterative Approach:
Take a number stack and a string stack. Iterate over input string and depending on 4 parameters do:
1.A number: calculate the number using (prev num *10) + curr num
2.[ : Append curr num and curr string values in respective stacks and reset both num and str to zero and empty str
3.character: Append to curr str
4.] : Pop the num stack and repeat curr str that many times and add it to parent str. Parent str is top of str stack and curr str is value in str variable.


"""
class Solution:
    def decodeString(self, s: str) -> str:
        if s==None or len(s)==None:
            return s

        k=0
        cstr=""
        num_stack=[]
        str_stack=[]

        for i in range(len(s)):
            if s[i].isnumeric():
                k=k*10+ int(s[i])

            elif s[i]=='[':
                num_stack.append(k)
                str_stack.append(cstr)
                k=0
                cstr=""

            elif s[i]=="]":
                popped_num=int(num_stack.pop())
                popped_str=str_stack.pop()
                for i in range(popped_num):
                    popped_str=popped_str+(cstr)

                cstr=popped_str

            else:
                cstr=cstr+s[i]


        return cstr


s=Solution()
print(s.decodeString("3[a]2[bc]"))