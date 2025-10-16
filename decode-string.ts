// Time complexity - O(n*k),n = length of the string, k = max repeat count
// Space complexity - O(n*k)
function decodeString(s: string): string {
	const strStack = [];
	const numStack = [];
	let currStr = "";
	let currNum = 0;

	for (let ch of s) {
		if (!isNaN(Number(ch))) {
			// ensure currNum is updated for more than 1 digit repear number
			currNum = currNum * 10 + Number(ch);
		} else if (ch == "[") {
			// push the parent string (currentStr) into strStack and the repeat number (currNum) in their respective stacks
			strStack.push(currStr);
			numStack.push(currNum);

			// reset currStr and currNum
			currStr = "";
			currNum = 0;
		} else if (ch == "]") {
			// if we encounter closing bracket, get the prev number to create a repeat baby str
			const prevNum = numStack.pop();
			const parentStr = strStack.pop();
			let babyStr = "";
			for (let i = 0; i < prevNum; i++) {
				babyStr += currStr;
			}
			// update curr by adding babyStr to parentStr
			currStr = parentStr + babyStr;
		} else {
			// append alphabet to current string
			currStr += ch;
		}
	}

	return currStr;
}
