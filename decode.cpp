//T: O(n)
//S :O(n)

class Solution {
public:
    string decodeString(string s) {
        int currNum = 0;
        string currStr = "";
        int popNum = 0;
        string popStr = "";
        stack<int> digits;
        stack<string> strings;
        for(int i=0; i<s.size(); i++){
            if(s[i]-'0'>=0 && s[i]-'0'<10){
                currNum = currNum*10 + (s[i]-'0');
                //cout<<"Curr Num :"<<currNum<<endl;
            }else if(s[i] == '['){
                //cout<<"Curr Num :"<<currNum<<endl;
                digits.push(currNum);
                strings.push(currStr);
                currNum =0;
                currStr = "";
            }else if(s[i] == ']'){
                popNum  = digits.top(); digits.pop();
                //cout<<popNum<<" "<<currStr<<endl;
                string temp ="";
                for(int i=0; i<popNum; i++){
                    temp+=currStr;
                }
                currStr = strings.top();
                strings.pop();
                currStr+=temp;
                // cout<<"Last push "<<currStr<<endl;
                //strings.push(currStr);
                //popStr = "";
                //currStr = "";
            }else{
                currStr += s[i];
            }
        }
        return currStr;
    }
};