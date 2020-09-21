// Time Complexity : O(n + no of pops form stack)
// Space Complexity : O(n) for the extra stacks created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    
    string decodeString(string s) {
         if( s.size() == 0)
             return "";
        
        stack<int> numStack;
        
        stack<string> strStack;
        
        int currNum = 0;
        string currStr = "";
        for( int x = 0; x <s.size(); x++){
            
          
            char ch = s.at(x);
            
            if(isdigit(ch)){
                currNum = currNum*10 + (ch-'0');  // checking whether the values is digit or not. And in order to bulld the digit( if >9) we are using logic to multiply prev with 10 and add current
            }else if(ch == '['){
                numStack.push(currNum);
                strStack.push(currStr); // logic when we enocunter [ . we will just push all the current number and current string into the stacks.
                
                currNum = 0;
                currStr = "";
            }else if (ch ==']'){
                int popint = numStack.top(); // when we hit ] we will get the recent number and then multiply the current string that number of times and then add that to the recnt string in the stack.
                numStack.pop();
                string temp = "";
                for ( int i = 0; i <popint; i++){
                    temp += currStr;
                }
                
                currStr = strStack.top();
                    strStack.pop();
                currStr= currStr + temp;
            } else{
                currStr += ch; // when we are with just characters we will just keep on appending them to the currStr 
            }
            }
            return currStr;
        }
    
    

};