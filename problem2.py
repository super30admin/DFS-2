#time complexity: O(len(s))
#space complexity: O(max nesting of paranthesis)
#ran on leetcode: Yes
#track charcters in ch and numbers in mum while looping thorugh the input string. When you encounter a '[', then push the ch and num inside a stack in that order. Whn you encounter a ']', we have to expand: the charcter tracked by ch will have to be repeated stk[-1] times(number presentin stack since we pushed when we saw a [). Then this cahracter has to be appended with the next element in the stk(the character/string that we pushed just before pushing num) and this resultant string will be the new ch. Finally return the ch
class Solution:
    def decodeString(self, s: str) -> str:
        ch=''
        num=0
        integer=['0','1','2','3','4','5','6','7','8','9']
        i=0
        stk=[]
        while(i<len(s)):
            if(s[i] in integer):
                num=(num*10)+int(s[i])
            elif(s[i]=='['):
                stk.append(ch)
                stk.append(num)
                ch=''
                num=0
            elif(s[i]==']'):
                rep=stk[-1]
                del(stk[-1])
                print(rep)
                temp=stk[-1]+(ch*rep)
                #print(temp)
                del(stk[-1])
                #stk.append(temp)
                ch=temp
                num=0
            else:
                ch+=s[i]
            i+=1
        return ch
