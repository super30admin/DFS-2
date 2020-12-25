// Time - O(N)
// Space - O(N)
class Solution {
    public String decodeString(String s) {
        
        StringBuilder result = new StringBuilder();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<StringBuilder> s2 = new Stack<StringBuilder>();
        int num = 0;
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            
            
            if (Character.isDigit(ch)) {
                num = 10 * num + ch - '0';
            }
            else if(ch =='[') {                
                s1.add(num);
                num = 0;
                s2.add(temp);                
                temp = new StringBuilder();
            }
            else if (ch == ']') {
                int times = s1.pop();
                StringBuilder t = new StringBuilder();
                for(int j = 0;j<times;j++) {
                    t.append(temp);
                }
                temp = s2.pop().append(t);                
            }
            else {
                temp.append(ch);
            }
        }
        
        return temp.toString();
        
    }
}
