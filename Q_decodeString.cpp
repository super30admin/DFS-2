
class Solution {
public:
    string decodeString(string s) {
        
        stack<int> s1;
        stack<string> s2;
        
        int num=0;
        string currString;
        
        for(int i=0; i< s.size(); i++){
            
            char ch = s[i];
            if(isdigit(ch)){
                //do this as no before [  can be 2 or 23 or 235 as well
                num = num* 10 + ch- '0';     
            }
            
            else if( ch =='['){
                
                s1.push( num);
                s2.push( currString);
                num=0;
                currString = "";
            }
            else if( ch==']'){
                int times= s1.top();
                s1.pop();
                string newString;
                for(int j=0; j< times; j++){
                    newString.append( currString);
                }
                
                currString = s2.top().append(newString);
                s2.pop();
            }
            else{
                currString= currString +ch;
            }
        }
        
        return currString;
    }
};