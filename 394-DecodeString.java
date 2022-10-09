//Approach-1: DFS - Iterative Approach
//Overall Time Complexity: O(Length of the output String)
//Overall Space Complexity: O(Number of opening brackets)
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        
        Stack<StringBuilder> stringQ = new Stack<>();
        Stack<Integer> intQ = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '['){
                stringQ.push(currStr);
                intQ.push(num);
                currStr = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                int repeat = intQ.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < repeat ; j++){
                    temp.append(currStr);
                }
                currStr = stringQ.pop().append(temp);
            }else{
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }
}




//Approach-1: DFS - Recursive Approach
//Overall Time Complexity: O(Length of the output String)
//Overall Space Complexity: O(Number of opening brackets)
class Solution {
    int i = 0;
    public String decodeString(String s) {
        
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }else if(c == '['){
                i++;
                String decoded = decodeString(s);
                //For the parent itself connect the repeating strings
                for(int i = 0; i < num; i++){
                    currStr.append(decoded);
                }
                num = 0;
            }else if(c == ']'){
                i++;
                return currStr.toString();
            }else{
                currStr.append(c);
                i++;
            }
        }
        
        return currStr.toString();
    }
}