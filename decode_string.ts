// TC: O(NxM) SC: O(NxM)
// N = Length of the string
// M = biggest digit in the string
let i: number = 0;
function decodeString_recursive(s: string): string {
  let currentStr: string = "";
  let currentNumber: number = 0;

  while (i < s.length) {
    let ch: string = s.charAt(i);
    const charCode = s.charCodeAt(i);
    i++;
    if (ch == "[") {
      let result = decodeString_recursive(s);
      for (let j = 0; j < currentNumber!; j++) {
        currentStr += result;
      }
      currentNumber = 0;
    } else if (ch == "]") {
      return currentStr;
    } else if (charCode >= 48 && charCode <= 57) {
      let num = Number.parseInt(ch, 10);
      currentNumber = currentNumber * 10 + num;
    } else {
      currentStr += ch;
    }
  }

  return currentStr;
}

// TC: O(NxM) SC: O(NxM)
// N = Length of the string
// M = biggest digit in the string
function decodeString(s: string): string {
  let numStack: number[] = [];
  let strStack: string[] = [];

  let currentStr: string = "";
  let currentNumber: number = 0;

  for (let i = 0; i < s.length; i++) {
    let ch: string = s.charAt(i);
    const charCode = s.charCodeAt(i);
    if (ch == "[") {
      strStack.push(currentStr);
      numStack.push(currentNumber);
      currentStr = "";
      currentNumber = 0;
    } else if (ch == "]") {
      let parent: string | undefined = strStack.pop();
      let c: number | undefined = numStack.pop();
      for (let j = 0; j < c!; j++) {
        parent += currentStr;
      }
      currentStr = parent!;
    } else if (charCode >= 48 && charCode <= 57) {
      let num = Number.parseInt(ch, 10);
      currentNumber = currentNumber * 10 + num;
    } else {
      currentStr += ch;
    }
  }

  return currentStr;
}

describe("Decode String", () => {
  it("Happy Path", () => {
    expect(decodeString("3[a]2[bc]")).toStrictEqual("aaabcbc");
  });
  it("Happy Path", () => {
    expect(decodeString("100[leetcode]")).toStrictEqual(
      "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
    );
  });

  it("Happy Path - Recursive", () => {
    i = 0
    expect(decodeString_recursive("3[a]2[bc]")).toStrictEqual("aaabcbc");
  });
  it("Happy Path - Recursive", () => {
    i = 0
    expect(decodeString_recursive("100[leetcode]")).toStrictEqual(
      "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
    );
  });
});
