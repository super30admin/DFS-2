class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s)==0:
            return ""
        snums=[]
        sstr=[]
        num=0
        currstr=""
        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10 + int(s[i])
            elif s[i]=="[":
                
                snums.append(num)
                sstr.append(currstr)
                num=0
                currstr=""
            elif s[i]=="]":
                times=snums.pop()
                repeated = currstr*times
                last_cur = sstr.pop()
                currstr = last_cur + repeated
            else:
                currstr+=(s[i])
        
        return currstr