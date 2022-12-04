// Time Complexity : O(length of output) the loop runs n + inner for loop for char repititions 
// Space Complexity : O(depth of the nesting in the string) 
// Did this code successfully run on Leetcode : Yes

//Approach 1: Stack solution (iterative DFS)

/*
Why DFS? : We have to resolve the innermost code first, which is essentially DFS. 
Why Stack? : DFS is nothing but a stack iterative implemention 
*/

class Solution {
public:
    string decodeString(string s) {
        //base case
        if(s.length() == 0) return s;
        //init
        stack<int> numStack;
        stack<string> strStack;
        int num = 0;
        string curr = "";

        for(int i=0; i<s.length(); i++){
            char c = s[i];
            //4 possibilities 
            if (isdigit(c)){
                num = num*10 + (c - '0');
            }
            else if (c == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = "";
            }
            else if (c == ']') {
                int times = numStack.top(); 
                numStack.pop();
                string str = strStack.top();
                strStack.pop();
                //decoding the innermost 
                // top from number stack * current string
                string temp;
                for(int i = 0; i<times; i++)
                    temp += curr;
                curr = temp;
                curr = str + curr;
            }
            else {
                //convert char to string using the string constructor 
                //takes the size of the char as 1st param and the char as the second param
                curr.append(string(1,c));
            }
                
        }
        return curr;
    }
};

//Approach 2: Recursive DFS
class Solution {
public:
    int i;
    string decodeString(string s) {
        //base case
        if(s.length() == 0) return s;
        //init
        int num = 0;
        string curr = "";
        //we pick up processing from wherever we left off
        //Increment 'i' after we get the character at i
        //we need while and not for since return statements are involved and the loop might never complete to increment i
        while(i < s.length()){
            char c = s[i];
            i++;
            //4 possibilities 
            if (isdigit(c)){
                num = num*10 + (c - '0');
            }
            else if (c == '[') {
                string decoded = decodeString(s);
                //after this call returns, a pop would have happened 
                // I will have my new values of curr and num 
                string temp;
                for(int j = 0; j<num; j++){
                    temp += decoded;
                }
                curr = curr + temp;

                num = 0;
            }
            else if (c == ']') {
                return curr;
            }
            else {
                //convert char to string using the string constructor 
                //takes the size of the char as 1st param and the char as the second param
                curr.append(string(1,c));
            }
        }
        return curr;
    }
};