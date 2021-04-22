// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class DecodeStringTwoStacks {
    public String decodeString(String s) {
        if(s==null|| s.length() == 0) return s;
        
        int num =0; 
        String cur = "";
        
        Deque<String> str = new ArrayDeque();
        Deque<Integer> number = new ArrayDeque();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (int)(c-'0');
            }
            else if(c == '['){
                str.push(cur);
                number.push(num);
                cur = new String();
                num=0;
            }
            else if(c == ']'){
                int cnt = number.pop();
                String curString = "";
                for(int i=0;i<cnt;i++) curString = curString + cur;
                cur = str.pop()  + curString;
                
            }
            else{
                cur = cur + c;
            }
        }
        
        return cur;
        
    }
}
// Time Complexity : O(n) n is the length of the string
// Space Complexity : O(k) where k is the depth of the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class DecodeStringRecursive {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        String cur = "" , result = "";
        int num = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (int)(s.charAt(i) - '0');
            }else if(s.charAt(i)=='['){
                int k = i+1;
                Deque<Character> stack = new ArrayDeque();
                stack.push('[');
                while(k<s.length() && !stack.isEmpty()){
                    //System.out.println(s.charAt(k) + " /");
                    if(s.charAt(k) == '[') stack.push('[');
                    else if(s.charAt(k) == ']') stack.pop();
                    k++;
                }
                String substr = s.substring(i+1,k == s.length() ? s.length() -1 : k-1);
                
                substr = decodeString(substr);
                //System.out.println(substr);
                
                //System.out.println(cur + " " + num);
                for(int j = 0; j < num; j++){
                    cur = cur + substr;
                }
                result = result + cur;
                //System.out.println(result);
                cur = new String();
                num = 0;
                i=k-1;
            }else{
                cur = cur + s.charAt(i);
            }
        }
        return result+cur;
    }
}