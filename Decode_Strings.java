/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Space complexity is O(N^2)
//Time complexity is O(N)
public class Decode_Strings {

	/**
	 * @param args
	 */
	
	public  String decodeString(String s) {
		int[] index = new int[1];
		index[0] = 0;
		return decodeStringHelper(s, index); //Start from index 0 
	}
	
	
	private String decodeStringHelper(String s, int[] index) {
		StringBuilder sb = new StringBuilder();
		String num = "";
		for (int i = index[0]; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '[' && c != ']' && !Character.isDigit(c)) // the string lexicon is a character
				sb.append(c);//Append it 
			else if (Character.isDigit(c))//If its a number add it to the number of occurences
				num += c;
			else if (c == '[') {//If its a bracket, go ahead by one index
				index[0] = i + 1;
				String next = decodeStringHelper(s, index);
				for (int n = Integer.valueOf(num); n > 0; n--)//For the number of occurences, 
					sb.append(next);//Append that string
				num = "";
				i = index[0];
			} else if (c == ']') {
				index[0] = i;
				return sb.toString();
			}
		}
		return sb.toString();}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s  = "3[a]2[bc]";
		Decode_Strings obj = new Decode_Strings();
		String sb = obj.decodeString(s);
		System.out.println(sb);
	}

}
