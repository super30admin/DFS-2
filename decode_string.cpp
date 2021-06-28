// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Partially
// Any problem you faced while coding this : My code only reads single digit numbers.
                                    // The logic to read multiple digit numbers is absent

class Solution {
public:
    string get_bkt_str(string &s, int &ptr)
    {
        string ret_str;
        
        int num = int(s[ptr])-48;
        ptr++;
        ptr++;
        
        while(s[ptr] != ']' && s[ptr] != '\0')
        {
            if(int(s[ptr]) > 95)
            {
                ret_str += s[ptr];
            }
            else
            {
                int num = int(s[ptr])-48;
                string temp_str = get_bkt_str(s, ptr);
                
                for(int i = 0; i < num; i++)
                {
                    ret_str += temp_str;
                }
            }
            
            ptr++;
        }
        
        ptr++;
        return ret_str;
    }
    
    string decodeString(string s) {\
                
        string ret_str;
        
        int ptr = 0;
        
        while(s[ptr] != '\0')
        {
            if(int(s[ptr]) > 95)
            {
                ret_str += s[ptr];
                ptr++;
            }
            else
            {
                int num = int(s[ptr])-48;
                string temp_str = get_bkt_str(s, ptr);
                
                for(int i = 0; i < num; i++)
                {
                    ret_str += temp_str;
                }
            }
        }
        
        return ret_str;
        
    }
};