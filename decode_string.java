// Time Complexity : O(N) iterating string characters
// Space Complexity : O(N) recursrive call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

	//we need to initialize cursor outside, so that it's not initialized everytime
    private int cursor = 0;
    
    public String decodeString(String s) {

    	//base check
        if(s == null || s.length() == 0) return s;
        
        
        
        //variable to store the multiple
        int k = 0; 
        
        //store result
        StringBuilder res = new StringBuilder();
        
        //loop through the string
        while(cursor < s.length()){
            
            //process each charcater of the string
            char token = s.charAt(cursor);
            
            if(token>= '0' && token <= '9'){//character is digit
                cursor++; // increment the cursor
                k = k*10 + (token - '0');
            }else if (token == '['){ // '[' then recurse and multiply
                cursor++;
                String nextResult = decodeString(s);
                while(k > 0){
                    res.append(nextResult);
                    k--;
                }
            }else if (token == ']'){ // ']' then return
                cursor++;
                return res.toString();
            }else{ //append to result
                cursor++;
                res.append(token);
            }
            
            
        }
        
        
        
        return res.toString();
    }
}