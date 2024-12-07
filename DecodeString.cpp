//given is an encoded string
// s= "3[a]2[bc]"
// we have to return the decoded string 
// s = aaabcbc

// s="1[[[[[c3[d[2[b]1[a]]]]"
// s= cdbbadbbadbba

// ok so the first data structure comes to mind is stack but we need to keep track of number and letter
// as the number is always followed by the letter
// create two stacks [] for num
//                   [] for letter
// now we iterate over the coded string and if we get number we push it in numstack or letterstack
// while iteration we iterate upto ] bracket if we encounter the close bracket
// we pop the letter and num and store the it times the number in the result string
// [1,3,1]
// [a,d,c]

// now we encounter first closing bracket 
// we pop a an 1 , result = a;
// b 2  result = bba



class Solution {
public:
    string decodeString(string s) {
        // create two stacks
        stack<int>numStack;
        stack<string>letterStack;
        string result;
        int num = 0;
        for(int i = 0; i < s.size(); i++)
        {
            // now untill we encounter the closing bracket 
            // we will check if we found no or letter
            if(isdigit(s[i]))
            {
                num = num *10 + s[i] - '0';
               
            }
            else if(s[i] == '[')
            {
                numStack.push(num);
                letterStack.push(result);

                // reset the num and letter
                num = 0;
                result = "";
            }
            else if(s[i]== ']')
            {
                int repeatedCount = numStack.top();
                numStack.pop();
                string let = letterStack.top();
                letterStack.pop();

                for(int i = 0; i <repeatedCount; i++)
                    let += result;
                result = let;
            }
            else
            {
                result += s[i];
            }
        }
        return result;
    }
};
//Time complexity O(N)
//Space complexity O(N)