class DecodeString {
    
    // Time Complexity: O(n)    (where n -> length of the input string)
    // Space Complexity: O(n)
    
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        String result = "";
        // Stack to maintain the counts - to repeat string that many number of times
        Stack<Integer> counts = new Stack<>();
        
        // Stack to maintain strings
        Stack<String> strings = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            // When we see a number - get the complete number and add it to the counts stack
            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                counts.push(count);
            }
            // When we see an open bracket - add to the strings stack whatever string we were building till that point.
            else if(s.charAt(i) == '['){
                strings.push(result);
                result = "";
                i++;
            }
            // When we see a closing bracket - get the last string from the strings stack, get the count - append to the last string of the stack - the current string which we were building for count number of times.
            else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder(strings.pop());
                int count = counts.pop();
                while(count-- > 0){
                    temp = temp.append(result);
                }
                result = temp.toString();
                i++;
            }
            // Keep building the string - if we see just a letter
            else{
                result += s.charAt(i);
                i++;
            }
        }
        return result;
    }
}