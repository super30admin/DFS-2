// Time Complexity :O(max(num)*n) n being the no of characters in  th string and num is maximum value of num in the string
// Space Complexity :O(n) recursive stack space n being the no of characters in  the string 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Solution2{
    //using global variable to move along teh string among teh recursive calls
    int i;
    //Recursive
    public String decodeString(String s) {
        if(s.isEmpty()||s==null) return s;
        int num=0;
        StringBuilder currStr=new StringBuilder();
        while(i<s.length()){
            char c=s.charAt(i);
            
            if(Character.isDigit(c)){
                num= num*10+c-'0';
                i++;    
            }
            else if(c=='['){
                i++;
                // get the decoded string
                String decoded=decodeString(s);
                StringBuilder newStr= new StringBuilder();
                // repeat it num times and add it to current string
                for(int j=0;j<num;j++){
                    newStr.append(decoded);
                }
                currStr.append(newStr);
                // need to set it to 0 because num is obtained from previous recurisve call
                num=0;
            }
            else if(c==']'){
                i++;
                // return evaluated string
               return currStr.toString(); 
                 
            }
            else{
                
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
     //Iterative
     // Time Complexity :O(max(num)*n) n being the no of characters in  th string and num is maximum value of num in the string
    // Space Complexity :O(n) stack spaces n being the no of characters in  th string 
     public String decodeString1(String s) {
        if(s.isEmpty()||s==null) return s;
        
        Stack<Integer> numStack= new Stack<>();
        Stack<StringBuilder> charStack= new Stack<>();
        int num=0;
        StringBuilder currStr=new StringBuilder();;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            else if(c=='['){
                numStack.push(num);
                charStack.push(currStr);
                num=0;
                currStr=new StringBuilder();
            }
            else if(c==']'){
                int times= numStack.pop();
                StringBuilder newStr= new StringBuilder();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr=charStack.pop().append(newStr);
                
            }
            else
            {
               currStr.append(c); 
            }
        }
        return currStr.toString();
    }
}