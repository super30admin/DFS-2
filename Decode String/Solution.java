class Solution {
    public String decodeString(String s) {
                
        Stack<String> letters = new Stack<>();
        Stack<String> nums = new Stack<>();

        letters.add("");
        int idx=0;
        String result="";
        while(idx < s.length()) {
            
            // if character
            
            if(Character.isLetter(s.charAt(idx))) {
                String temp = "";
                while(idx < s.length() && Character.isLetter(s.charAt(idx))) {
                    temp += s.charAt(idx);
                    idx++;                    
                }
                letters.push(letters.pop() + temp);
                //System.out.println("letter stack " + letters);
             }
            
            // if num
            else if(idx < s.length() && Character.isDigit(s.charAt(idx))) {
                String temp = "";
                while(Character.isDigit(s.charAt(idx))) {
                    temp += s.charAt(idx);
                    idx++;
                }
                
                nums.push(temp);
                idx++;
                letters.push("");
                //System.out.println("num stack " + nums);
            }
            else if(s.charAt(idx) == ']') {
                String chars = letters.pop();
                int count = Integer.parseInt(nums.pop());
                //String temp = (!letters.isEmpty()) ? letters.pop() : "";
                String temp = letters.pop();
                while(count > 0) {
                    temp = temp + chars;
                    count--;
                }
                letters.push(temp);
                idx++;
                //System.out.println("letters stack fin " + letters);
            }
            
            
            // if ]
        }
        


        return letters.pop();
    }
}