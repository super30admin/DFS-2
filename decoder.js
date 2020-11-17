// Time Complexity : O(N)
// Space Complexity : O(N*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var decodeString = function(s) {
    if(s == null || s.length == 0) return s;

    let currStr = '';
    let num = 0;

    let numSt = [];
    let StrSt = [];

    for(let  i = 0; i < s.length; i++){
        let c = charAt(i);
        if(!isNaN(c)){
            num = num * 10 + c -'0';
        }
        else if(c == '['){
            numSt.push(num);
            StrSt.push(currStr);
            currStr = '';
            num = 0;
        }
        else if(c == ']'){
            let times = numSt.pop();
            let newStr = '';
            for(let j = 0; j < times; j++){
                newStr.concat(currStr);
            }
            currStr = StrSt.pop().concat(newStr)
        }
        else {
            currStr.concat(c)
        } 
    }
    return currStr.toString();
};


