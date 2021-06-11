// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use DFS to explore all the inner strings in a recurcive fasion.
*/

class Solution {

    int i;
    public String decodeString(String s) {
    
        int num = 0;
        StringBuilder resultBuiler = new StringBuilder();
        
        for (;i<s.length();){            
            char c = s.charAt(i);
            
            if (Character.isDigit(c)){
                i++;
                num = num*10 + (c-'0');
            }
            else if (c == '['){
                i++;
                String child = decodeString(s);
                StringBuilder childrenBuilder = new StringBuilder();
                for (int n=0; n<num; n++)
                    childrenBuilder.append(child);
                resultBuiler.append(childrenBuilder);
                num = 0;
            }
            else if (c == ']'){
                i++;
                return resultBuiler.toString();
            }
            else {
                i++;
                resultBuiler.append(c); 
            } 
        }
        return resultBuiler.toString();   
    }
}