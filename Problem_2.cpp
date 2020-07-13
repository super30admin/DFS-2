class Solution {
public:
    int i = 0;
    string decodeString(string s) {
       long curr_num = 0;
        string curr_str = "";
        stack<string>s1;
        stack<int>s2;
        while(i<s.length()){
            if(isdigit(s.at(i))){
                curr_num = curr_num*10 + s.at(i)-'0';
            }
            else if(s.at(i)=='['){
                i++;
                string temp = decodeString(s);
                for(int i=0; i<curr_num;i++){
                    curr_str+=temp;
                }
                curr_num=0;
            }
            else if(s.at(i)==']'){
                i++;
                return curr_str;
            }
            else{
                curr_str+=s.at(i);
                i++;
            }
        }
        return curr_str;
    }
};