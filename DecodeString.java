/* Time Complexity - O(OutputLength) or O(max_Integer*N)
Space COmplexity - O(OutPutLength) or O(max_Integer*N)
Idea : Use stack and process it using string builder to avoid copying also the intution is u
solve one pair and then store it stack number of times the value infront of pair.
*/
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!=']'){
                stack.push(ch);
            }else{
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty() && stack.peek()!='['){
                    temp.insert(0,stack.pop());
                }
                stack.pop();
                StringBuilder intVal = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    intVal.insert(0,stack.pop());
                }
                int number_of_repeat = Integer.valueOf(intVal.toString());
                while(number_of_repeat!=0){
                    for(char c : temp.toString().toCharArray()){
                        stack.push(c);
                    }
                    number_of_repeat--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}