class Solution {
    public String decodeString(String s) {
        return decode(s, new int[]{0});
    }
    
    private String decode(String s, int[] index) {
        StringBuilder result = new StringBuilder();
        
        while (index[0] < s.length() && s.charAt(index[0]) != ']') {
            char currentChar = s.charAt(index[0]);
            
            if (Character.isDigit(currentChar)) {
                // Build the number for k
                int k = 0;
                while (index[0] < s.length() && Character.isDigit(s.charAt(index[0]))) {
                    k = k * 10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }
                
                // Skip the '[' character
                index[0]++; 
                
                // Recursively decode the substring inside the brackets
                String decodedSubstring = decode(s, index);
                
                // Repeat decoded substring k times
                for (int i = 0; i < k; i++) {
                    result.append(decodedSubstring);
                }
                
                // Skip the ']' character
                index[0]++;
            } else {
                // Append regular characters to the result
                result.append(currentChar);
                index[0]++;
            }
        }
        
        return result.toString();
    }
}
