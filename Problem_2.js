
/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    let numStack = [];
    let strStack = [];
    let currStr = '';
    let currNum = 0;
// Use DFS method using stacks for numbers and str seperately and only pop when a closing bracket is found and 
// multiply the number of times from num stack with the existing string. 
    for(let i = 0; i< s.length; i++){
        let char = s.charAt(i);

        if(char >= '0' && char <= '9'){
            currNum = (currNum * 10) + (char - '0');
        }
        else if(char === '['){ // push into stack accordingly 
            numStack.push(currNum);
            strStack.push(currStr);
            //Reset curr str and num
            currNum = 0;
            currStr = '';
        }
        else if(char === ']'){ // pop from stack
            let repeat = numStack.pop();
            let newStr = '';
            for(let j= 0; j < repeat; j++){
                newStr+=currStr; 
            }
            currStr = strStack.pop();
            currStr+=newStr;
        }
        else
            currStr+=char; 
    }
    return currStr;
};