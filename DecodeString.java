// TC: O(N) where N represents the length of the string
// SC : O(N) where we are using Stack to store our digits and string.

// We are traversing through the string and checking if the string is a digit, we convert the digit strings into number and push the digits onto count stack. Next we check if our character is opening bracket, 
// if so, we know that the characters will start after the bracket, so we push our result onto result Stack. If incase we have already processed our result, we reset the resultant string to null so that we can initialize the string result to new string that we process
// Once we come across closing bracket, we know that we have our count for string in cntStack and our result string in our result Stack, we append that to our resultant string for the count provided for that string
// This way, we process our result stack and count stack to store our results onto String.

import java.util.*;

public class DecodeString {

	public String decodeString(String s) {
		
		if( s== null || s.length() == 0)
			return "";
		
		int idx = 0; String res = "";
		Stack<Integer> cntSt = new Stack<>();
		Stack<String> resSt = new Stack<>();
		
		while(idx < s.length()) {
		
			if(Character.isDigit(s.charAt(idx))) {
				int cnt = 0;
				
				while(Character.isDigit(s.charAt(idx))) {
					cnt = cnt*10 + (s.charAt(idx)-'0');
					idx++;
				}
				cntSt.push(cnt);
			}
			else if(s.charAt(idx)=='[') {
				resSt.push(res);
				res = "";
				idx++;
			}
			else if(s.charAt(idx)==']') {
				
				StringBuilder sb = new StringBuilder(resSt.pop());
				int repeatTimes = cntSt.pop();
				
				for(int i = 0;i < repeatTimes; i++) {
					sb.append(res);
				}
				
				res = sb.toString();
				idx++;
			}else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[a2[c]]"));
	}
}
