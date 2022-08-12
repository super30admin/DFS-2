// Time Complexity : o(N) 
// Space Complexity : o(k) number of opening bracket
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0) return "";
        
        int num=0; //if encounter number
        StringBuilder curr = new StringBuilder(); //if encounter character
        
        Stack<StringBuilder> strstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);  // traversing string 
            
            if(Character.isDigit(c)){   // character is digit
                num=num*10+(c-'0'); //num*10 for two digit. c is char not int so asci c - '0'
            }
            else if(c=='['){  //if open bracket push curr and nums
                strstack.push(curr);
                numstack.push(num);
                num=0;
                curr= new StringBuilder();
            }
            else if(c==']'){
                int size=numstack.pop();
                StringBuilder newstring = new StringBuilder(); // taking new as after making                                                                     curr 3(size) times it need                                                                     to append with strstack.pop                                                                   string 
                for(int j=0;j<size;j++){
                    newstring.append(curr);
                }
                curr = strstack.pop().append(newstring);
            }
            else{  // c is character
                curr.append(c);
            }
        }
        return curr.toString();
    }
}                                 
}