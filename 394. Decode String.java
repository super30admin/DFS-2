class Solution {
    // Method I
    // Time complexity: O(k * n), k indicates the maximum repeating number in the string
    // Space complexity: O(m + n)
    public String decodeString(String s) {
        Stack<Integer> digitStack = new Stack();
        Stack<String> stringStack = new Stack();
        
        char[] chars = s.toCharArray();
        String cs = "";
        int i = 0;
        while(i < chars.length){
            if(Character.isDigit(chars[i])){
                int k = 0;
                while(Character.isDigit(chars[i])){
                    k = 10 * k + (chars[i] - '0');
                    i++;
                }
                digitStack.push(k);
            }else if(chars[i] == '['){
                stringStack.push(cs);
                cs = "";
                i++;
            }else if(chars[i] == ']'){
                String prevString = stringStack.pop();
                int times = digitStack.pop();
                while(times-- > 0){
                    prevString += cs;
                }
                cs = prevString;
                i++;
            }else{
                cs += chars[i++];
            }
        }
        
        return cs;
        // Method II
        // int index = 0;
        // String res = "";
        // while(index < s.length() && s.charAt(index) != ']'){
            
        //     if(Character.isDigit(s.charAt(index))){
        //         //记录digit的值
        //         int k = 0;
        //         while(index < s.length() && Character.isDigit(s.charAt(index))){
        //             k = k * 10 + (s.charAt(index) - '0');
        //             index++;
        //         }
        //         // escape [
        //         index++;
                
        //         String decodeString = decodeString(s); //acc
        //         // escape ]
        //         index++;
                
        //         while(k-- > 0){
        //             res += decodeString;
        //         }
                
        //     }else{
        //         res += s.charAt(index);
        //         index++;
        //     }
        // }
        
        // return res;
    }
}