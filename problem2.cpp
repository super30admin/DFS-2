//Time Complexity - O(kn)
//Space Complexity - O(kn)
class Solution {
public:
    int i;
    string decodeString(string s) {
        int num=0;
        string currString="";
        while(i<s.size()){
            char c = s[i];
            i++;
            if(isdigit(c)){
                num=num*10 + (c-'0');
            }
            else if(c=='['){
                string child = decodeString(s);
                string newString;
                for(int j=0;j<num;j++){
                    newString+=child;
                }
                currString +=newString;
                num=0;
            }
            else if(c==']'){
                return currString;
            }
            else{
                currString+=c;
            }
        }
        return currString;
    }
};