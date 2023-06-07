// TC:O(maxK.N)
// SC:O(m+n)m->no of char's ; n->no of digits

// Approach:
// Here, traversing through the string and then using two stacks one for number and other for string 
// and then whenever we encounter '[' we push both string and number on to respective stacks 
// and when we encounter ']' pop from int stack and create a string repeating these number of times ,
// And then pop the string from stack and attach the newly generated string to  it.


class Solution {
public:
    string decodeString(string s) {
        stack<int> I;       // Stack to store the number of repetitions
        stack<string> K;    // Stack to store the corresponding substrings
        int num = 0;        // Variable to store the current number
        string temp = "";   // Variable to store the current substring being constructed

        for (int i = 0; i < s.size(); i++) 
        {
            // temp=s[i];
            if (s[i] >= '0' && s[i] <= '9') 
            {
                num = num * 10 + (s[i] - '0');     // Form the number by considering multiple digits
            } 
            else if (s[i] == '[') 
            {
                I.push(num);                        // Push the number of repetitions to the stack
                K.push(temp);                       // Push the current substring to the stack
                num = 0;                            // Reset the number
                temp = "";                          // Reset the current substring
            }
            else if (s[i] == ']') 
            {
                string ans = "";                    // Variable to store the repeated substring
                int t = I.top();                     // Retrieve the number of repetitions
                I.pop();                            // Pop the top element from the repetitions stack
                for (int i = 0; i < t; i++) 
                {
                    ans += temp;                    // Repeat the current substring t times
                }
                temp = K.top() + ans;                // Append the repeated substring to the previous substring
                K.pop();                            // Pop the top element from the substring stack
            } 
            else 
            {
                temp += s[i];                       // Append the character to the current substring
            }
        }

        return temp;                                // Return the final decoded string
    }
};