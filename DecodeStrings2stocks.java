/*
TC: O(maxK.n) where k is mak times and n is string length
SC: O(n) where n is length of string
*/
class Solution {

    public String decodeString(String s) {
        Stack<StringBuilder> developedString = new Stack<>();
        Stack<Integer> times = new Stack<>();

        StringBuilder currentStr = new StringBuilder();
        int currentTimes = 0;

        for (int i = 0 ; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(Character.isDigit(curr)) {
                currentTimes = currentTimes * 10 + curr - '0';
            } else if (curr == '[') {
                developedString.push(currentStr);
                times.push(currentTimes);
                currentStr = new StringBuilder();
                currentTimes = 0;
            } else if (curr == ']') {
                int currTimes = times.pop();

                StringBuilder newStr = new StringBuilder();
                for(int c = 1; c <= currTimes; c++) {
                    newStr.append(currentStr);
                }

                currentStr = developedString.pop().append(newStr);
            } else {
                currentStr.append(curr);
            }
        }

        return currentStr.toString();
    }
}