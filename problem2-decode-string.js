//** https://leetcode.com/problems/decode-string/
//// Time Complexity : O(n + no of pops)
//// Space Complexity : O(n)
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

//// Your code here along with comments explaining your approach
var decodeString;

decodeString = function(s) {
  var ch, currNum, currStr, i, j, k, numStack, popInt, ref, ref1, strStack, temp, x;
  if (s === null || s.length === 0) {
    return '';
  }
  numStack = [];
  strStack = [];
  currNum = 0;
  currStr = '';
  for (x = j = 0, ref = s.length; (0 <= ref ? j < ref : j > ref); x = 0 <= ref ? ++j : --j) {
    ch = s[x];
    if (parseInt(ch) !== (0/0)) {
      currNum = currNum * 10 + (ch - '0');
    } else if (ch === '[') {
      numStack.push(currNum);
      strStack.add(currStr);
      currNum = 0;
      currStr = '';
    } else if (ch === ']') {
      popInt = numStack.pop();
      temp = '';
      for (i = k = 0, ref1 = popInt; (0 <= ref1 ? k < ref1 : k > ref1); i = 0 <= ref1 ? ++k : --k) {
        temp += currStr;
      }
      currStr = strStack.pop();
      currStr = currStr + temp;
    }
  }
  return currStr;
};

decodeString("3[a]2[bc]");

//# sourceMappingURL=problem2-decode-string.js.map
