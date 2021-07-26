class Solution:
    def decodeString(self, s: str) -> str:
        nums='0123456789'
        bracks='[]'
        self.globalPointer=0
        self.ans=''
        def DFS():
            txt=''
            nms=''
            localPointer=self.globalPointer
            while localPointer<len(s):
                while localPointer<len(s) and s[localPointer] not in bracks:
                    if s[localPointer] in nums:
                        nms+=s[localPointer]
                    else:
                        txt+=s[localPointer]
                    localPointer+=1
                if localPointer>=len(s):
                    self.ans=txt
                    return
                if s[localPointer]=='[':
                    self.globalPointer=localPointer+1
                    r=DFS()
                    txt+=int(nms)*r
                    self.ans=txt
                    localPointer=self.globalPointer
                    nms=''
                elif s[localPointer]==']':
                    self.globalPointer=localPointer+1
                    return txt
        DFS()
        return self.ans