class DecodeString {
    
    // Approach 1 - Using recursion (optimal solution)
    // Time complexity - O(n)
    // Space complexity - O(n)
    
    //global variable
    int index =0;
    String s;
    
    // This function is the driver function of decodeHelper() and decoder() function.
     public String decodeString1(String s) {
        this.s = s;
        return decodeHelper();
    }
    
    // This function stores characters into a stringbuilder exists inside the brackes "[]" and calls decoder function to repeat upto the defined       // number of times and maintains the result while iteration of input so far.
    public String decodeHelper(){
        StringBuilder sb = new StringBuilder();
        
        // loop till index is reached to the end of the input string 
        while(index < s.length() && s.charAt(index) != ']'){
            char c  = s.charAt(index);
            
            // if character is digit call decoder for repeat string upto specified times
            if(Character.isDigit(c)){
                sb.append(decoder());
            // otherwise build string
            }else{
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }
    
    // thid function duplicate string upto given number of time, it asks string to be repeted from the decodeHelper.
    public String decoder(){
        // find the nearest index of '[' from the current index.
        int leftIndex = s.indexOf('[',index);
        
        // substring the number and convert into the number 
        String subs = s.substring(index, leftIndex);
        int count = Integer.valueOf(subs);
        index = leftIndex+1;
        // receive string to be reated from decodeHelper
        String temp = decodeHelper();
        
        //repeat and store into the stringbuilder
        StringBuilder result = new StringBuilder();
        for(int i=0; i< count ; i++){
            result.append(temp);
        }
        
        if(index < s.length() && s.charAt(index) == ']')
            index++;
        
        return result.toString();
    }
    
    
    // Approach 2 - Using Stack 
    // Time complexity - O(n)
    // Space complexity - O(n)
    
    // Buggy code - this solution fails for input "3[z]2[2[y]pq4[2[jk]e1[f]]]ef". Please help into debugging.
    
    
    // Used a stack to store strings and result into a stringbuilder.
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        // loop untill all charcters of string has been processed
        for(int i = 0 ; i<s.length(); i++){
            char c = s.charAt(i);
            
            // when character is ']', pop all top strings which are letter and store into a stringbuilder. 
            // once all letter string are popped from the stack, then pop all digit character from the top of the stack, form a int number n.
            // repeat the string stored into the sringbuilder upto n times.
            // push result string into the stack.
            if(c == ']'){
                StringBuilder sb = new StringBuilder();
                String str = "";
                while(!stack.isEmpty() && !stack.peek().matches("\\d+")){
                    sb.insert(0,stack.pop());
                }
                String num = "";
                while(!stack.isEmpty() && stack.peek().matches("\\d+")){
                    num += stack.pop();
                }
                
                int total =0;
                if(num != null || num.length() != 0)
                    total = Integer.parseInt(num);
                
                while(total >= 1){
                    str += sb.toString();
                    total--;
                }
                stack.push(str);
            }
            else if(c == '[')
                continue;
            else
                stack.push(Character.toString(c));
        }
        
        // form the result 
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
}