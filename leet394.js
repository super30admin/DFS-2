// Time Complexity : O(N)
// Space Complexity : O(length of string)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

const decodeString = s => {
  const stack = [];
  for (const char of s) {
    if (char !== "]") { stack.push(char); continue; }
    let cur = stack.pop();
    let str = '';
    while (cur !== '[') {
      str = cur + str;
      cur = stack.pop();
    }
    let num = '';
    cur = stack.pop();
    while (!Number.isNaN(Number(cur))) {
      num = cur + num;
      cur = stack.pop();
    }
    stack.push(cur);
    stack.push(str.repeat(Number(num)));
  }
  return stack.join('');
};