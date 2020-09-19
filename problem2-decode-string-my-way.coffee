#** https://leetcode.com/problems/decode-string/
#// Time Complexity : O(string length) we iterate through all characters in string
#// Space Complexity : O(string length) we may push all characters into a stack
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# believe it or not something as simple as parsing 100[a], my stack popping of ['1', '0', '0'] was problematic
# also putting an evaluation back onto the stack vs directly into the output.
# i could probably check if the stack is empty to decide whether to push onto the stack or directly to output string
#
#// Your code here along with comments explaining your approach
#
# for each character in string
#   if it isnt ']'
#     push onto the stack
#   else
#     pop off all substring until '['
#     pop '['
#     pop off all number
#     create a string of number * substring, push onto stack
#
# pop any remaining stack directly into output string
# return output string

decodeString = (string) ->
  return string if string is null or string is ''

  stack = []

  outstr = ''

  for ch in string
    switch
      when ch isnt ']'
        stack.push(ch)
      else
        # pop off all substring until '['
        # pop '['
        # pop off all number
        # create a string of number * substring, push onto stack
        substring = ''
        while stack[stack.length-1] isnt '['
          substring = stack.pop() + substring
        stack.pop() # '['
        num = 0
        tempstack = []
        while stack.length > 0 && ('0' <= stack[stack.length-1] <= '9')
          tempstack.push(stack.pop())
        factor = 0
        num = tempstack.pop()
        while tempstack.length > 0
          num = num * 10 + parseInt(tempstack.pop())
          factor += 1
        tempstr = ''
        for i in [0...num]
          tempstr = tempstr + substring
        stack.push(tempstr)

  while stack.length > 0
    outstr = stack.pop() + outstr

  outstr

#decodeString('abcd') is 'abcd'
#decodeString('2[c]') is 'cc'
#decodeString('3[a]2[bc]') is 'aaabcbc'
#decodeString('3[a2[c]]') is 'accaccacc'
decodeString("100[leetcode]")
