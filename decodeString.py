#TimeComplexity:O(N) 
#SpaceComplexity: max char array + max integer in string
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def decodeString(self, s: str) -> str:
        char=[]
        nums=[]
        curstr=''
        curnum=0
        print(s)
        for i in s:
            if i.isdigit():
                curnum=curnum*10+int(i)
            elif i=='[':
                char.append(curstr)
                nums.append(curnum)
                curstr=''
                curnum=0
                
            elif i==']':
                num=nums.pop()
                temp=''
                for i in range(num):
                    temp+=curstr
                #print(temp)
                curstr=char.pop()
                curstr+=temp
            else:
                curstr+=i
        return curstr
        