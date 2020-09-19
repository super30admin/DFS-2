#** https://leetcode.com/problems/decode-string/
#// Time Complexity : O(n + no of pops)
#// Space Complexity : O(n)
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
#// Your code here along with comments explaining your approach

decodeString = (s) ->
  return '' if s is null or s.length is 0

  numStack = []
  strStack = []

  currNum = 0
  currStr = ''

  for x in [0...s.length]
    ch = s[x]

    if parseInt(ch) isnt NaN
      currNum = currNum * 10 + (ch - '0')
    else if ch is '['
      numStack.push(currNum)
      strStack.add(currStr)

      currNum = 0
      currStr = ''
    else if ch is ']'
      popInt = numStack.pop()
      temp = ''
      for i in [0...popInt]
        temp += currStr

      currStr = strStack.pop()
      currStr = currStr + temp

  currStr


decodeString("3[a]2[bc]")
