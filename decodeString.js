/**
 * @param {string} s
 * @return {string}
Intuition:
We use two stacks to decode the string: 
one (cntSt) to store the repeat counts and another (strSt) to store the strings built so far. As we iterate through the input:

Digits: Build the repeat count currCount (handling multi-digit numbers).

'[': Push the current string and count onto their respective stacks and reset them, marking the start of a new encoded segment.

']': Pop the last count and string from the stacks, repeat the current string count times, and append it to the string popped from the stack.

Characters: Append normal characters to currStr.

By the end of iteration, currStr contains the fully decoded string. 

T.C: O(N*M)
S.C: O(N+M)
 */
var decodeString = function (s) {
    const cntSt = [];
    const strSt = [];
    let currStr = '';
    let currCount = 0;
    const isDigit = (c) => c.charCodeAt(0) >= 48 && c.charCodeAt(0) <= 57;
    for (let i = 0; i < s.length; i++) {
        const currChar = s[i];
        if (isDigit(currChar)) {
            currCount = currCount * 10 + Number(currChar);
        } else if (currChar === '[') {
            strSt.push(currStr);
            cntSt.push(currCount);
            currStr = '';
            currCount = 0;
        } else if (currChar === ']') {
            const count = cntSt.pop();
            let stBuilt = '';
            for (let i = 0; i < count; i++) {
                stBuilt += currStr;
            }
            const papa = strSt.pop();
            currStr = `${papa}${stBuilt}`;
        } else {
            // normal char
            currStr = `${currStr}${currChar}`;
        }
    }
    return currStr;
};