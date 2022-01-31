/**
 * Time Complexity:
 * It depends on the max value of the digit in the string and the length of the string
 * So it will be O(max(d)*s) where d is digit and s is the size of the string
 */


/**
 * Space Complexity:
 * We are maintaing two stacks i.e. for numbers and for string
 * So the space complexity will be O(d + s) where d is the number of digits in the
 * string and s is the number of letters in the string
 */


/**
 * Approach:
 * The intution is we have to divide the problem in three parts. First keep the track
 * of the numbers. Second, the string after the bracket starts which includes numbers
 * and characters. Third, when the bracket closes what was inside the brackets and 
 * how many times we have to multiply it.
 * 
 * Based on this intution we maintain two stacks. One to keep the track of the numbers
 * and second to store the string before the bracket starts so that when the bracket 
 * closes we can get this parent string and append the child string with it.
 * 
 * We maintain a current variable to store the string and then we itertate over the given
 * string. If we encounter a digit we store it in a variable to keep track of the digit.
 * Then if we encounter a starting bracket we have to push the current string and the
 * digit into the stacks and reset these variable so that we can start the subproblem 
 * or the child string in the brackets. Then when we encounter the closing brackets. 
 * We take the last element from the stack which is the top element and keep on appending
 * the current string to the child string. Then we take the top element from the
 * string stack and append the child to the parent string. 
 * 
 */

// The code ran perfectly on leetcode




class Solution {
public:
    string decodeString(string s) {
        stack<int> numTrk;
        stack<string> strTrk;
        int num = 0;
        string curr;
        for(int i =0; i<s.size(); i++){
            auto c = s[i];
            if(isdigit(c)){
                num = num*10 + c - '0';
            } else if (c == '[') {
                numTrk.push(num);
                strTrk.push(curr);
                num = 0; 
                curr = "";
            } else if (c == ']'){
                int nNum = numTrk.top();
                numTrk.pop();
                string child;
                for(int i = 0; i<nNum; i++){
                    child.append(curr);
                }
                string parent = strTrk.top();
                strTrk.pop();
                curr = parent.append(child);
            } else {
                curr = curr +c;
            }
        }
        
        return curr;
        
    }
};