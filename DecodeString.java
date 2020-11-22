
//idea: iterate over string and use two stack one is to store number and other to store string. when closing brackets come pop string from string stack and number from number stack to repeat element those no of times . 
//if characters come then append it into result string  and append that result string to element which are poped from string stack. when opening brackets comes store result string into stack and clear out result string 
//time complexity is o(n)
//space complexity:its recursive so o(n)
//run on leetcode:yes
//no problem faced.
import java.util.Stack;
public class DecodeString {
	 public  static String decodeString(String s) {
	        String res = "";
	        
	        //twostack to store number and string
	        Stack<Integer> countStack = new Stack<>();
	        Stack<String> resStack = new Stack<>();
	        int idx = 0;
	        //iterate over string
	        while (idx < s.length()) {
	        	//check if string contains digit convert digit to int nd if twodigit number then multiply by 10 and add to privious digit
	            if (Character.isDigit(s.charAt(idx))) {
	                int count = 0;
	                while (Character.isDigit(s.charAt(idx))) {
	                    count = 10 * count + (s.charAt(idx) - '0');
	                    idx++; //goto next element
	                }
	                //store into number stack
	                countStack.push(count);
	            }
	            //if [ bracket come then push res veriable which is privious bracket string values into stack
	            else if (s.charAt(idx) == '[') {
	                resStack.push(res);
	                res = "";
	                idx++; // got to next element inside string
	            }
	            //if closing bracket come then take privious string from stack and append it to current string from res variable
	            //repeat the current string the size which is popped element from number stack
	            else if (s.charAt(idx) == ']') {
	                StringBuilder temp = new StringBuilder (resStack.pop());
	                int repeatTimes = countStack.pop();
	                for (int i = 0; i < repeatTimes; i++) {
	                    temp.append(res);
	                }
	                //convert into string
	                res = temp.toString();
	                idx++; //got to next element
	            }
	            else {
	            	//res string which holdes current string 
	                res += s.charAt(idx++);
	            }
	        }
	        return res;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "3[a]2[bc]";
       String result= decodeString(s);
       System.out.println("new String is="+result);
       
	}

}
