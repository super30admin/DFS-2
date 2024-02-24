/*
Time: O(N) (N = length of decoded string)
Space: O(N)

Maintain two stacks: one for the digits, one for the characters
When you find digits, cast them together to int and push to digit stack
When you find '[', start pushing to char stack
When you find ']', extract everything from char stack upto '[' (store them in str), extract the digit from digits stack, 
and push back str $digit times to chars.

At the end, chars stack will hold the decoded data (in reverse order)
*/
class Solution {
public:
    bool isDigit(char c){
        return c>='0' && c<='9';
    }

    string decodeString(string s) {
        stack<int> digits;
        stack<char> chars;
        string digit = "";

        for(auto c: s){
            if(isDigit(c)){
                digit += c;
            }
            else if(c=='['){
                digits.push(stoi(digit));
                digit = "";

                chars.push(c);
            }
            else if(c!=']'){
                chars.push(c);
            }
            else if(c == ']'){
                string tmp = "";
                while(!chars.empty()){
                    char ch = chars.top();
                    chars.pop();

                    if(ch=='['){
                        int d = digits.top();
                        digits.pop();

                        reverse(tmp.begin(),tmp.end());

                        while(d--){
                            for(auto c: tmp)  chars.push(c);
                        }

                        break;
                    }
                    tmp +=  ch;
                }
            }
          
        }
        
        string ret = "";
        while(!chars.empty()){
            ret += chars.top();
            chars.pop();
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};
