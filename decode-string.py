class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """

        #         currstr=''
        #         nums=0
        #         newstr=''
        #         stack_num=[]
        #         stack_str=[]
        #         for i in s:

        #             if i.isdigit():
        #                 nums=nums*10+ord(i)-ord('0')
        #             elif i=='[':
        #                 stack_num.append(nums)
        #                 stack_str.append(currstr)
        #                 currstr=''
        #                 nums=0
        #             elif i==']':
        #                 times=stack_num.pop()
        #                 for j in range(times):
        #                     newstr+=currstr
        #                 currstr=stack_str.pop()+newstr
        #                 newstr=''

        #             else:
        #                 currstr+=i
        #         return currstr

        # newstr=''
        # stack_num=[]
        # stack_str=[]

        def decode(s, i):
            currstr = ''
            if s == '':
                return ''
            nums = 0
            while i < len(s):
                if s[i].isdigit():
                    nums = nums * 10 + ord(s[i]) - ord('0')
                    i += 1
                elif i == '[':
                    i += 1
                    inner = decode(s, i)
                    for j in range(nums):
                        currstr += inner
                    # currstr=

                    nums = 0
                elif i == ']':
                    i += 1
                    print(currstr)
                    return currstr


                else:
                    currstr += s[i]
                    i += 1
            # return currstr

        i = 0
        decode(s, i)

        #dfs, bfs=o(nk) nk-longeststring space-0(n)
