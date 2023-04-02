#TC-O(n)
#SC-O(output string)
#logic-loop through string with global variable and if i is number add to currnum,is alpha add to currstr
#is [ then recursive call on string and add return str to currstr and make currnum=0 and ']' return currstr
class Solution:
    global i
    i=0
    def decodeString(self, s: str) -> str:
        global i
        curstr=''
        curnum=0
        while i<len(s):
            if s[i].isdigit():
                curnum=curnum*10+int(s[i])
                i+=1
            elif s[i]=='[':
                i+=1
                child =self.decodeString(s)
                for k in range(curnum):
                    curstr+=child
                curnum=0
                i+=1
            elif s[i]==']':
                return curstr
            else:
                curstr+=s[i]
                i+=1
        i=0
        return curstr
            
