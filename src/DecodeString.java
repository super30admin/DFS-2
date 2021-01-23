import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {

		if (s == null || s.length() == 0)
			return s;

		Stack<Integer> numStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();

		StringBuilder currStr = new StringBuilder();

		int num = 0;

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (Character.isDigit(c)) {

				num = num * 10 + c - '0';

			} else if (c == '[') {

				numStack.push(num);
				num = 0;
				stringStack.push(currStr);
				currStr = new StringBuilder();

			} else if (c == ']') {

				int times = numStack.pop();
				StringBuilder newStr = new StringBuilder();
				for (int k = 0; k < times; k++) {

					newStr.append(currStr);
				}

				currStr = stringStack.pop().append(newStr);

			} else {

				currStr.append(c);
			}

		}

		return currStr.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
