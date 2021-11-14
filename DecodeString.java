class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> data = new Stack<>();
        Stack<Integer> count = new Stack<>();

        int i=0;
        char c;
        int temp;
        StringBuilder sb,small;
        StringBuilder currentString=new StringBuilder();
        int currentCount = 0;
        while(i<s.length()){
            c = s.charAt(i);


            if(c=='['){
                data.push(currentString);
                count.push(currentCount);
                currentString = new StringBuilder();
                currentCount=0;
            }
            else if(c==']'){
                temp = count.pop();
                sb = data.pop();
                for(int j=0;j<temp;j++)
                    sb.append(currentString);
                currentString = sb;
            }
            else if(Character.isLetter(c)){
                currentString.append(c);
            }
            else{
                currentCount = currentCount*10 + c - '0';
            }

            i++;

        }
        return currentString.toString();


    }
}