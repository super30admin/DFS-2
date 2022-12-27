//Time Complexity : O(N) where N is the length of decoded String 
//Space Complexity :O(N) where N is the length of decoded String 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :


public class DecodeString {
	 // DFS  recursive approach
    // index at the global level to track processed characters index
    int i=0;
    public String decodeString(String s) {
        StringBuilder currString = new StringBuilder();
        int currNum=0;
        // taverse the current string and call sub string decode as soon as you get opening bracket
        while(i<s.length()){
           
            // take the cirrent charactr out 
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                i++;
                currNum = 10*currNum + c -'0';
            }
            else if(c =='['){
                i++;  
                String innerDecode =  decodeString(s);
                for(int i=0;i<currNum;i++){
                    currString.append(innerDecode);   
                }
                currNum=0;
            }else if(c == ']'){
                i++;
                return currString.toString();
            }
            else {
                i++;
                currString.append(c);
            }
            
            
        }
        return currString.toString();
    }
}
