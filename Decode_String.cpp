//Here in Java we have string builder class, but in cpp we have stringstream class, works the same but the + operator to concatinate won't work, instead it has its own implementation.
class Solution {
public:
    string decodeString(string s) {
        stack<int> numSt;
        stack<string> strSt;
        int num = 0;
        stringstream currStr;
        currStr.str("");
        for(int i=0;i<s.size();i++){
            char c = s[i];
            if(isdigit(c)){
                num = num*10 + c - '0';
            }
            else if(c == '['){
                numSt.push(num);
                strSt.push(currStr.str());
                num=0;
                currStr.str("");
            }
            else if(c == ']'){
                int count = numSt.top();
                numSt.pop();
                stringstream baby;
                for(int k = 0; k < count; k++) {
                    baby << currStr.str();
                }
                string topString = strSt.top();
                strSt.pop();
                currStr.str("");  // Clear the current string
                currStr << topString << baby.str();
            }
            else{
                
                currStr<<c;
            }
        }
      return currStr.str();  
    }
};
