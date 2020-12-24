// USING RECURSION

// TC: O( N X MAX NUMBER) || LENGTH OF OUTPUT STRING
// SC: O(N)

class Solution {
    int i;
    
    public String decodeString(String s) {
        
        if( s == null || s.length() == 0)
            return s;
        StringBuilder currString = new StringBuilder();
        
        int num = 0;
        
        while( i < s.length()){
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            } 
            
            else if( c == '[' ){
                String returnedString = decodeString(s);
                StringBuilder newString = new StringBuilder();
                
                for(int j=0; j < num ; j++){
                    newString.append(returnedString);
                }
                currString.append(newString);
                num = 0;
            } 
            
            else if( c == ']'){
                return currString.toString();
            } 
            
            
            else {
                currString.append(c);
            }
        }
        
        return currString.toString();
        
    }
}


// TC: O( N X MAX NUMBER) || LENGTH OF OUTPUT STRING
// SC: O(N)

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        StringBuilder currString = new StringBuilder();
        
        Stack<Integer> nums = new Stack<>();
        
        Stack<StringBuilder> strings = new Stack<>();
        
        int num = 0;
        
        for(int i = 0; i< s.length();i++){
        
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
            }
            else if( c == '['){
                nums.push(num);
                strings.push(currString);
                num = 0;
                currString = new StringBuilder();
                
            }else if(c == ']'){
                
                int times = nums.pop();
                StringBuilder newString = new StringBuilder();
                
                for(int j = 0 ; j < times; j++){
                    newString.append(currString);
                }
                
                currString = strings.pop().append(newString);
                
            }
            else{
                currString.append(c);
            }
            
        }
        return currString.toString();
    }
}