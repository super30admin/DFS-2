// Time Complexity :O(kn)
// Space Complexity :O(KN)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :

//Using stack to apply LIFO and go from innermost bracket to outermost bracket
// Your code here along with comments explaining your approach

class Solution {
public:
    string decodeString(string s) {
        
        stack<int> numStack;
        stack<string> strStack;
        int currNum = 0;
        string currStr = "";

        for(char c:s){
            if(isdigit(c)){
                currNum = currNum*10+(c-'0');
            }
            else if(c=='['){
                strStack.push(currStr);
                numStack.push(currNum);
                currNum=0;
                currStr="";

            }
            else if(c==']'){
               int a=numStack.top();
               numStack.pop();
               string newStr="";

               for(int i=1;i<=a;i++){
                   newStr=newStr+currStr;

               }

               string str = strStack.top();
               strStack.pop();
               str=str+newStr;

               currStr = str;


                

            }
            else{
                currStr.push_back(c);





            }
        }

        return currStr;
    
    }
};